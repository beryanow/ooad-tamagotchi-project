package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.EarnMoneyWindowView;

import javax.swing.*;

public class EarnMoneyWindowController extends AbstractWindowController {
    private EarnMoneyWindowView earnMoneyWindow;

    @Override
    void createWindow() {
        earnMoneyWindow = new EarnMoneyWindowView();
    }

    @Override
    JFrame getWindow() {
        return getEarnMoneyWindow();
    }

    EarnMoneyWindowController() {
        createWindow();
    }

    EarnMoneyWindowView getEarnMoneyWindow() {
        return earnMoneyWindow;
    }

}
