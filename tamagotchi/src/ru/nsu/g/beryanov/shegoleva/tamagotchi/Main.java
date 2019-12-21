package ru.nsu.g.beryanov.shegoleva.tamagotchi;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.WelcomeWindowView;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    static public void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                try {
                    new WelcomeWindowView();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });
        } catch (InterruptedException | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
    }
}
