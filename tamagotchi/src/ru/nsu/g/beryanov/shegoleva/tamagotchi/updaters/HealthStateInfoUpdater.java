package ru.nsu.g.beryanov.shegoleva.tamagotchi.updaters;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.ChiefWindowController;

import java.beans.PropertyChangeSupport;

public class HealthStateInfoUpdater extends AbstractUpdater {
    public HealthStateInfoUpdater(PropertyChangeSupport modelPropertyChange, ChiefWindowController chiefWindowController) {
        super(modelPropertyChange, chiefWindowController);
    }

    @Override
    void access() {
        getChiefWindowController().getTamagotchiModelController().accessHealth();
    }

    @Override
    void updateInfo() {
        getModelPropertyChange().firePropertyChange("HealthStateProperty", 0, 1);
    }

    @Override
    public void run() {
        access();
        updateInfo();
    }
}