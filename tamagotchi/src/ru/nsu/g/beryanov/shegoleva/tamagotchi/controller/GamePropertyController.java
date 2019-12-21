package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.model.TamagotchiModel;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.GameWindowView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GamePropertyController implements PropertyChangeListener {
    private GameWindowView gameWindow;
    private TamagotchiModel tamagotchiModel;

    public GamePropertyController(GameWindowView gameWindow, TamagotchiModel tamagotchiModel) {
        this.gameWindow = gameWindow;
        this.tamagotchiModel = tamagotchiModel;
    }

    @Override
    public void propertyChange(PropertyChangeEvent changeEvent) {
        switch (changeEvent.getPropertyName()) {
            case "OwnerProperty":
                gameWindow.getOwnerName().setText(tamagotchiModel.getOwnerName());
                gameWindow.getCoinsAmount().setText(String.valueOf(tamagotchiModel.getCoinsAmount()));
                gameWindow.getOwnerAge().setText(String.valueOf(tamagotchiModel.getOwnerGender()));
                gameWindow.getFoodAmount().setText(String.valueOf(tamagotchiModel.getFoodAmount()));
                gameWindow.getWaterAmount().setText(String.valueOf(tamagotchiModel.getDrinkAmount()));
                break;
            case "PetProperty":
                gameWindow.getPetName().setText(tamagotchiModel.getPetName());
                gameWindow.getPetAge().setText(String.valueOf(tamagotchiModel.getPetAge()));
                gameWindow.getPetType().setText(tamagotchiModel.getPetType());
                break;
            case "HappinessStateProperty":
                gameWindow.getHappinessBar().setValue(tamagotchiModel.getHappinessState());
                break;
            case "SatietyStateProperty":
                gameWindow.getSatietyBar().setValue(tamagotchiModel.getSatietyState());
                break;
            case "VivacityStateProperty":
                gameWindow.getVivacityBar().setValue(tamagotchiModel.getVivacityState());
                break;
            case "HealthStateProperty":
                gameWindow.getHealthBar().setValue(tamagotchiModel.getHealthState());
                break;
        }
    }
}
