package ru.nsu.g.beryanov.shegoleva.tamagotchi.updaters;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.ChiefWindowController;

import java.beans.PropertyChangeSupport;

public class HappinessStateInfoUpdater extends AbstractUpdater {

    public HappinessStateInfoUpdater(PropertyChangeSupport modelPropertyChange, ChiefWindowController chiefWindowController) {
        super(modelPropertyChange, chiefWindowController);
    }

    @Override
    void access() {
       getChiefWindowController().getTamagotchiModelController().accessHappiness();
    }

    @Override
    void updateInfo() {
        getModelPropertyChange().firePropertyChange("HappinessStateProperty", 0, 1);
    }

    @Override
    public void run() {
        access();
        updateInfo();
    }
}