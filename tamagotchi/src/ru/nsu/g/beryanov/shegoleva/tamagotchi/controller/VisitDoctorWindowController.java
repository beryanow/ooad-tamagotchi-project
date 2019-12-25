package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.VisitDoctorWindowView;

import javax.swing.*;

public class VisitDoctorWindowController extends AbstractWindowController {
    private VisitDoctorWindowView visitDoctorWindow;

    @Override
    void createWindow() {
        visitDoctorWindow = new VisitDoctorWindowView();
    }

    @Override
    JFrame getWindow() {
        return getVisitDoctorWindow();
    }

    VisitDoctorWindowController() {
        createWindow();
    }

    VisitDoctorWindowView getVisitDoctorWindow() {
        return visitDoctorWindow;
    }
}
