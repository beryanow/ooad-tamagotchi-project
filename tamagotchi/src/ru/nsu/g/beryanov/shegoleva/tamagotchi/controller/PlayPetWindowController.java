package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.PlayPetWindowView;

import javax.swing.*;

public class PlayPetWindowController extends AbstractWindowController {
    private PlayPetWindowView playPetWindow;

    @Override
    void createWindow() {
        playPetWindow = new PlayPetWindowView();
    }

    @Override
    JFrame getWindow() {
        return getPlayPetWindow();
    }

    PlayPetWindowController() {
       createWindow();
    }

    PlayPetWindowView getPlayPetWindow() {
        return playPetWindow;
    }

}
