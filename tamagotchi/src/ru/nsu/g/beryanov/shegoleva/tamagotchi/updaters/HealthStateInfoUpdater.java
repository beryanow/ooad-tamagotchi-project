package ru.nsu.g.beryanov.shegoleva.tamagotchi.updaters;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.ModelPropertyChange;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.model.TamagotchiModel;

import java.util.TimerTask;

public class HealthStateInfoUpdater extends TimerTask {
    private final ModelPropertyChange modelPropertyChange;
    private TamagotchiModel tamagotchiModel;

    public HealthStateInfoUpdater(ModelPropertyChange modelPropertyChange, TamagotchiModel tamagotchiModel) {
        this.modelPropertyChange = modelPropertyChange;
        this.tamagotchiModel = tamagotchiModel;
    }

    private void accessHealth() {
        if ((tamagotchiModel.getHappinessState() == 0) || (tamagotchiModel.getSatietyState() == 0)) {
            int healthState = tamagotchiModel.getHealthState();
            if (healthState > 0) {
                --healthState;
            }
            tamagotchiModel.setHealthState(healthState);
        }
    }

    private void updateInfo() {
        modelPropertyChange.firePropertyChange("HealthStateProperty", 0, 1);
    }

    @Override
    public void run() {
        synchronized (modelPropertyChange) {
            accessHealth();
        }
        updateInfo();
    }
}