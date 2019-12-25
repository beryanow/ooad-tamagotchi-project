package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.EnterOwnerWindowView;

import javax.swing.*;

public class EnterOwnerWindowController extends AbstractWindowController {
    private EnterOwnerWindowView enterOwnerWindow;

    @Override
    void createWindow() {
        enterOwnerWindow = new EnterOwnerWindowView();
    }

    @Override
    JFrame getWindow() {
        return getEnterOwnerWindow();
    }

    EnterOwnerWindowController() {
        createWindow();
    }

    EnterOwnerWindowView getEnterOwnerWindow() {
        return enterOwnerWindow;
    }
}
