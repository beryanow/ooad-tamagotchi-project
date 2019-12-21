package ru.nsu.g.beryanov.shegoleva.tamagotchi.updaters;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.ModelPropertyChange;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.model.TamagotchiModel;

import java.util.TimerTask;

public class HappinessStateInfoUpdater extends TimerTask {
    private final ModelPropertyChange modelPropertyChange;
    private TamagotchiModel tamagotchiModel;

    public HappinessStateInfoUpdater(ModelPropertyChange modelPropertyChange, TamagotchiModel tamagotchiModel) {
        this.modelPropertyChange = modelPropertyChange;
        this.tamagotchiModel = tamagotchiModel;
    }

    private void accessHappiness() {
        if (tamagotchiModel.getHealthState() < 30) {
            int happinessState = tamagotchiModel.getHappinessState();
            if (happinessState > 0) {
                --happinessState;
            }
            tamagotchiModel.setHappinessState(happinessState);
        }
    }

    private void updateInfo() {
        modelPropertyChange.firePropertyChange("HappinessStateProperty", 0, 1);
    }

    @Override
    public void run() {
        synchronized (modelPropertyChange) {
            accessHappiness();
        }
        updateInfo();
    }
}