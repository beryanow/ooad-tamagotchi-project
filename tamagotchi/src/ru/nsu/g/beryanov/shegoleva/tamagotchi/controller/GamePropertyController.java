package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GamePropertyController implements PropertyChangeListener {
    private ChiefWindowController chiefWindowController;

    GamePropertyController(ChiefWindowController chiefWindowController) {
        this.chiefWindowController = chiefWindowController;
    }

    @Override
    public void propertyChange(PropertyChangeEvent changeEvent) {
        switch (changeEvent.getPropertyName()) {
            case "OwnerProperty":
                chiefWindowController.getGameWindow().getOwnerName().setText(chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getOwnerName());
                chiefWindowController.getGameWindow().getCoinsAmount().setText(String.valueOf(chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getCoinsAmount()));
                chiefWindowController.getGameWindow().getOwnerAge().setText(String.valueOf(chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getOwnerGender()));
                chiefWindowController.getGameWindow().getFoodAmount().setText(String.valueOf(chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getFoodAmount()));
                chiefWindowController.getGameWindow().getWaterAmount().setText(String.valueOf(chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getDrinkAmount()));
                break;
            case "PetProperty":
                chiefWindowController.getGameWindow().getPetName().setText(chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getPetName());
                chiefWindowController.getGameWindow().getPetAge().setText(String.valueOf(chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getPetAge()));
                chiefWindowController.getGameWindow().getPetType().setText(chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getPetType());
                break;
            case "HappinessStateProperty":
                chiefWindowController.getGameWindow().getHappinessBar().setValue(chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getHappinessState());
                break;
            case "SatietyStateProperty":
                chiefWindowController.getGameWindow().getSatietyBar().setValue(chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getSatietyState());
                break;
            case "VivacityStateProperty":
                chiefWindowController.getGameWindow().getVivacityBar().setValue(chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getVivacityState());
                break;
            case "HealthStateProperty":
                chiefWindowController.getGameWindow().getHealthBar().setValue(chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getHealthState());
                break;
        }
    }
}
