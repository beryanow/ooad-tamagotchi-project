package ru.nsu.g.beryanov.shegoleva.tamagotchi.updaters;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.ModelPropertyChange;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.model.TamagotchiModel;

import java.util.TimerTask;

public class VivacityStateInfoUpdater extends TimerTask {
    private final ModelPropertyChange modelPropertyChange;
    private TamagotchiModel tamagotchiModel;

    public VivacityStateInfoUpdater(ModelPropertyChange modelPropertyChange, TamagotchiModel tamagotchiModel) {
        this.modelPropertyChange = modelPropertyChange;
        this.tamagotchiModel = tamagotchiModel;
    }

    private void accessVivacity() {
        int vivacityState = tamagotchiModel.getVivacityState();
        if (vivacityState + 5 < 100) {
            vivacityState += 5;
        }
        tamagotchiModel.setVivacityState(vivacityState);
    }

    private void updateInfo() {
        modelPropertyChange.firePropertyChange("VivacityStateProperty", 0, 1);
    }

    @Override
    public void run() {
        synchronized (modelPropertyChange) {
            accessVivacity();
        }
        updateInfo();
    }
}