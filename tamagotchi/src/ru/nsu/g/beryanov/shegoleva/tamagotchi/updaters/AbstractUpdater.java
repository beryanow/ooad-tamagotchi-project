package ru.nsu.g.beryanov.shegoleva.tamagotchi.updaters;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.ChiefWindowController;

import java.beans.PropertyChangeSupport;
import java.util.TimerTask;

public abstract class AbstractUpdater extends TimerTask {
    private ChiefWindowController chiefWindowController;
    private PropertyChangeSupport modelPropertyChange;

    ChiefWindowController getChiefWindowController() {
        return chiefWindowController;
    }

    PropertyChangeSupport getModelPropertyChange() {
        return modelPropertyChange;
    }

    AbstractUpdater(PropertyChangeSupport modelPropertyChange, ChiefWindowController chiefWindowController) {
        this.chiefWindowController = chiefWindowController;
        this.modelPropertyChange = modelPropertyChange;
    }

    abstract void updateInfo();
    abstract void access();

    @Override
    public abstract void run();
}
