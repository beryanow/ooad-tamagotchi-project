package ru.nsu.g.beryanov.shegoleva.tamagotchi;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.ChiefWindowController;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.TamagotchiModelController;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Main {
    static public void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                TamagotchiModelController tamagotchiModelController = new TamagotchiModelController();
                ChiefWindowController chiefWindowController = new ChiefWindowController(tamagotchiModelController);
                chiefWindowController.startWelcomeWindow();
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
