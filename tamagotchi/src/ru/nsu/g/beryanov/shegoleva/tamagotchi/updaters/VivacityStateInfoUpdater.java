package ru.nsu.g.beryanov.shegoleva.tamagotchi.updaters;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.ChiefWindowController;

import java.beans.PropertyChangeSupport;

public class VivacityStateInfoUpdater extends AbstractUpdater {
    public VivacityStateInfoUpdater(PropertyChangeSupport modelPropertyChange, ChiefWindowController chiefWindowController) {
        super(modelPropertyChange, chiefWindowController);
    }

    @Override
    void access() {
        getChiefWindowController().getTamagotchiModelController().accessSatiety();
    }

    @Override
    void updateInfo() {
        getModelPropertyChange().firePropertyChange("VivacityStateProperty", 0, 1);
    }

    @Override
    public void run() {
        access();
        updateInfo();
    }
}