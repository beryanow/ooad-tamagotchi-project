package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.model.TamagotchiModel;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.CreatePetWindowView;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.EnterOwnerWindowView;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.GameWindowView;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.WelcomeWindowView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WelcomeWindowController implements ActionListener {
    private TamagotchiModelController tamagotchiModelController;
    private WelcomeWindowView welcomeWindow;
    private TamagotchiModel tamagotchiModel;

    public WelcomeWindowController(TamagotchiModelController tamagotchiModelController, WelcomeWindowView welcomeWindow, TamagotchiModel tamagotchiModel) {
        this.tamagotchiModelController = tamagotchiModelController;
        this.welcomeWindow = welcomeWindow;
        this.tamagotchiModel = tamagotchiModel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "newPetButtonPressed":
                CreatePetWindowView createPetWindow = null;
                try {
                    createPetWindow = new CreatePetWindowView(tamagotchiModelController);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                tamagotchiModelController.setSelectPetWindow(createPetWindow);
                break;
            case "recentPetButtonPressed":
                welcomeWindow.getNewPetButton().setEnabled(false);
                break;
            case "ownerInfoButtonPressed":
                EnterOwnerWindowView enterOwnerWindow = new EnterOwnerWindowView(tamagotchiModelController);
                tamagotchiModelController.setEnterOwnerWindow(enterOwnerWindow);
                break;
            case "startGameButtonPressed":
                GameWindowView gameWindowView = new GameWindowView(tamagotchiModelController);
                tamagotchiModelController.setGameWindowView(gameWindowView);
                welcomeWindow.getWelcomeFrame().setVisible(false);
                break;
        }
    }
}
