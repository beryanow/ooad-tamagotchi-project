package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.*;

import javax.swing.*;

public class GameWindowController extends AbstractWindowController {
    private GameWindowView gameWindowView;

    @Override
    void createWindow() {
        gameWindowView = new GameWindowView();
    }

    @Override
    JFrame getWindow() {
        return getGameWindowView();
    }

    GameWindowController() {
       createWindow();
    }

    GameWindowView getGameWindowView() {
        return gameWindowView;
    }
}
