package ru.nsu.g.beryanov.shegoleva.tamagotchi.updaters;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.ModelPropertyChange;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.model.TamagotchiModel;

import java.util.TimerTask;

public class SatietyStateInfoUpdater extends TimerTask {
    private final ModelPropertyChange modelPropertyChange;
    private TamagotchiModel tamagotchiModel;

    public SatietyStateInfoUpdater(ModelPropertyChange modelPropertyChange, TamagotchiModel tamagotchiModel) {
        this.modelPropertyChange = modelPropertyChange;
        this.tamagotchiModel = tamagotchiModel;
    }

    private void accessSatiety() {
        int satietyState = tamagotchiModel.getSatietyState();
        if (satietyState > 0) {
            --satietyState;
        }
        tamagotchiModel.setSatietyState(satietyState);
    }

    private void updateInfo() {
        modelPropertyChange.firePropertyChange("SatietyStateProperty", 0, 1);
    }

    @Override
    public void run() {
        synchronized (modelPropertyChange) {
            accessSatiety();
        }
        updateInfo();
    }
}