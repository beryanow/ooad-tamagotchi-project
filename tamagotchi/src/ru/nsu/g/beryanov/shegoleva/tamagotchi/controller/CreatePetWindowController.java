package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.CreatePetWindowView;

import javax.swing.*;

public class CreatePetWindowController extends AbstractWindowController {
    private CreatePetWindowView createPetWindow;

    @Override
    void createWindow() {
        createPetWindow = new CreatePetWindowView();
    }

    @Override
    JFrame getWindow() {
        return getCreatePetWindow();
    }

    CreatePetWindowController() {
        createWindow();
    }

    CreatePetWindowView getCreatePetWindow() {
        return createPetWindow;
    }
}
