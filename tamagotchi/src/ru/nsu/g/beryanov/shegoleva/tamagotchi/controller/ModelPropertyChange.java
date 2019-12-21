package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import java.beans.PropertyChangeSupport;

public class ModelPropertyChange extends PropertyChangeSupport {
    public ModelPropertyChange(Object sourceBean) {
        super(sourceBean);
    }
}
