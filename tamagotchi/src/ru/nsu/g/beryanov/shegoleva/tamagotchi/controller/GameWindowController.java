package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindowController implements ActionListener {
    private TamagotchiModelController tamagotchiModelController;

    public GameWindowController(TamagotchiModelController tamagotchiModelController) {
        this.tamagotchiModelController = tamagotchiModelController;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "playPetButtonPressed":
                PlayPetWindowView playPetWindow = new PlayPetWindowView(tamagotchiModelController);
                tamagotchiModelController.setPlayPetWindow(playPetWindow);
                break;
            case "visitDoctorButtonPressed":
                VisitDoctorWindowView visitDoctorWindow = new VisitDoctorWindowView(tamagotchiModelController);
                tamagotchiModelController.setVisitDoctorWindow(visitDoctorWindow);
                break;
            case "visitShopButtonPressed":
                VisitShopWindowView visitShopWindow = new VisitShopWindowView(tamagotchiModelController);
                tamagotchiModelController.setVisitShopWindow(visitShopWindow);
                break;
            case "earnMoneyButtonPressed":
                EarnMoneyWindowView earnMoneyWindow = new EarnMoneyWindowView(tamagotchiModelController);
                tamagotchiModelController.setEarnMoneyWindow(earnMoneyWindow);
                break;
            case "walkPetButtonPressed":
                WalkPetWindowView walkPetWindow = new WalkPetWindowView(tamagotchiModelController);
                tamagotchiModelController.setWalkPetWindow(walkPetWindow);
                break;
            case "feedPetButtonPressed":
                FeedPetWindowView feedPetWindow = new FeedPetWindowView(tamagotchiModelController);
                tamagotchiModelController.setFeedPetWindow(feedPetWindow);
                break;
            case "sleepPetButtonPressed":
                tamagotchiModelController.getTamagotchiModel().setVivacityState(100);
                tamagotchiModelController.getModelPropertyChange().firePropertyChange("VivacityStateProperty", 0, 1);
                break;
        }
    }
}
