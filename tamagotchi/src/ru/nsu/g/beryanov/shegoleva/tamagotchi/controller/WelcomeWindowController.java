package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.WelcomeWindowView;

import javax.swing.*;

public class WelcomeWindowController extends AbstractWindowController {
    private WelcomeWindowView welcomeWindow;

    @Override
    void createWindow() {
        welcomeWindow = new WelcomeWindowView();
    }

    @Override
    JFrame getWindow() {
        return getWelcomeWindow();
    }

    WelcomeWindowController() {
       createWindow();
    }

    WelcomeWindowView getWelcomeWindow() {
        return welcomeWindow;
    }
}
