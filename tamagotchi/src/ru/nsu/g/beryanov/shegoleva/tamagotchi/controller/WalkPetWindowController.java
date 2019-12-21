package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.WalkPetWindowView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WalkPetWindowController implements ActionListener {
    private WalkPetWindowView walkPetWindow;
    private TamagotchiModelController tamagotchiModelController;

    public WalkPetWindowController(WalkPetWindowView walkPetWindow, TamagotchiModelController tamagotchiModelController) {
        this.walkPetWindow = walkPetWindow;
        this.tamagotchiModelController = tamagotchiModelController;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "returnHomeWalkPetButtonPressed":
                walkPetWindow.getWalkPetFrame().setVisible(false);
                break;
            case "batheLakeButtonPressed":
                switch (tamagotchiModelController.getTamagotchiModel().getPetType()) {
                    case "Ёж":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/sonic_enjoy.png"));
                            walkPetWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Заяц":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/pinky_enjoy.png"));
                            walkPetWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Лис":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/puppy_enjoy.png"));
                            walkPetWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                }

                int happinessState = tamagotchiModelController.getTamagotchiModel().getHappinessState();
                happinessState = Math.min(happinessState + 50, 100);
                tamagotchiModelController.getTamagotchiModel().setHappinessState(happinessState);
                tamagotchiModelController.getModelPropertyChange().firePropertyChange("HappinessStateProperty", 0, 1);

                int vivacityState = tamagotchiModelController.getTamagotchiModel().getVivacityState();
                vivacityState = Math.max(vivacityState - 10, 0);
                tamagotchiModelController.getTamagotchiModel().setVivacityState(vivacityState);
                tamagotchiModelController.getModelPropertyChange().firePropertyChange("VivacityStateProperty", 0, 1);

                int satietyState = tamagotchiModelController.getTamagotchiModel().getSatietyState();
                satietyState = Math.max(satietyState - 2, 0);
                tamagotchiModelController.getTamagotchiModel().setSatietyState(satietyState);
                tamagotchiModelController.getModelPropertyChange().firePropertyChange("SatietyStateProperty", 0, 1);

                int healthState = tamagotchiModelController.getTamagotchiModel().getHealthState();
                healthState = Math.min(healthState + 20, 100);
                tamagotchiModelController.getTamagotchiModel().setHealthState(healthState);
                tamagotchiModelController.getModelPropertyChange().firePropertyChange("HealthStateProperty", 0, 1);
                break;
            case "forestHuntButtonPressed":
                switch (tamagotchiModelController.getTamagotchiModel().getPetType()) {
                    case "Ёж":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/sonic_enjoy.png"));
                            walkPetWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Заяц":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/pinky_enjoy.png"));
                            walkPetWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Лис":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/puppy_enjoy.png"));
                            walkPetWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                }

                happinessState = tamagotchiModelController.getTamagotchiModel().getHappinessState();
                happinessState = Math.min(happinessState + 25, 100);
                tamagotchiModelController.getTamagotchiModel().setHappinessState(happinessState);
                tamagotchiModelController.getModelPropertyChange().firePropertyChange("HappinessStateProperty", 0, 1);

                vivacityState = tamagotchiModelController.getTamagotchiModel().getVivacityState();
                vivacityState = Math.max(vivacityState - 25, 0);
                tamagotchiModelController.getTamagotchiModel().setVivacityState(vivacityState);
                tamagotchiModelController.getModelPropertyChange().firePropertyChange("VivacityStateProperty", 0, 1);

                satietyState = tamagotchiModelController.getTamagotchiModel().getSatietyState();
                satietyState = Math.max(satietyState - 4, 0);
                tamagotchiModelController.getTamagotchiModel().setSatietyState(satietyState);
                tamagotchiModelController.getModelPropertyChange().firePropertyChange("SatietyStateProperty", 0, 1);

                healthState = tamagotchiModelController.getTamagotchiModel().getHealthState();
                healthState = Math.min(healthState + 30, 100);
                tamagotchiModelController.getTamagotchiModel().setHealthState(healthState);
                tamagotchiModelController.getModelPropertyChange().firePropertyChange("HealthStateProperty", 0, 1);
                break;
        }
    }
}
