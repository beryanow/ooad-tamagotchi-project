package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.FeedPetWindowView;

import javax.swing.*;

public class FeedPetWindowController extends AbstractWindowController {
    private FeedPetWindowView feedPetWindow;

    @Override
    void createWindow() {
        feedPetWindow = new FeedPetWindowView();
    }

    @Override
    JFrame getWindow() {
        return getFeedPetWindow();
    }

    FeedPetWindowController() {
        createWindow();
    }

    FeedPetWindowView getFeedPetWindow() {
        return feedPetWindow;
    }

}
