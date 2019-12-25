package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.model.TamagotchiModel;

import java.beans.PropertyChangeSupport;

public class TamagotchiModelController {
    private TamagotchiModel tamagotchiModel;
    private PropertyChangeSupport modelPropertyChange;

    public void accessHealth() {
        if ((tamagotchiModel.getHappinessState() == 0) || (tamagotchiModel.getSatietyState() == 0)) {
            int healthState = tamagotchiModel.getHealthState();
            if (healthState > 0) {
                --healthState;
            }
            tamagotchiModel.setHealthState(healthState);
        }
    }

    public void accessSatiety() {
        int satietyState = tamagotchiModel.getSatietyState();
        if (satietyState > 0) {
            --satietyState;
        }
        tamagotchiModel.setSatietyState(satietyState);
    }

    public void accessVivacity() {
        int vivacityState = tamagotchiModel.getVivacityState();
        if (vivacityState + 5 < 100) {
            vivacityState += 5;
        }
        tamagotchiModel.setVivacityState(vivacityState);
    }

    public void accessHappiness() {
        if (tamagotchiModel.getHealthState() < 30) {
            int happinessState = tamagotchiModel.getHappinessState();
            if (happinessState > 0) {
                --happinessState;
            }
            tamagotchiModel.setHappinessState(happinessState);
        }
    }

    void setModelPropertyChange(PropertyChangeSupport modelPropertyChange) {
        this.modelPropertyChange = modelPropertyChange;
    }

    public TamagotchiModelController() {
        this.tamagotchiModel = new TamagotchiModel();
    }

    public PropertyChangeSupport getModelPropertyChange() {
        return modelPropertyChange;
    }

    public TamagotchiModel getTamagotchiModel() {
        return tamagotchiModel;
    }
}
