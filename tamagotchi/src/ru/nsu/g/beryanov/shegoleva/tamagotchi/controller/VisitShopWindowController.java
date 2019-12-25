package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.VisitShopWindowView;

import javax.swing.*;

public class VisitShopWindowController extends AbstractWindowController {
    private VisitShopWindowView visitShopWindowView;

    @Override
    void createWindow() {
        visitShopWindowView = new VisitShopWindowView();
    }

    @Override
    JFrame getWindow() {
        return getVisitShopWindowView();
    }

    VisitShopWindowController() {
        createWindow();
    }

    VisitShopWindowView getVisitShopWindowView() {
        return visitShopWindowView;
    }
}
