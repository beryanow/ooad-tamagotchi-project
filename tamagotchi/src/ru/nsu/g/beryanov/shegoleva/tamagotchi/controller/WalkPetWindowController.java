package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.WalkPetWindowView;

import javax.swing.*;

public class WalkPetWindowController extends AbstractWindowController {
    private WalkPetWindowView walkPetWindow;

    @Override
    void createWindow() {
        walkPetWindow = new WalkPetWindowView();
    }

    @Override
    JFrame getWindow() {
        return getWalkPetWindow();
    }

    WalkPetWindowController() {
        createWindow();
    }

    WalkPetWindowView getWalkPetWindow() {
        return walkPetWindow;
    }
}
