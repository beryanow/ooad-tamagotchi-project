package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.PlayPetWindowView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlayPetWindowController implements ActionListener {
    private PlayPetWindowView playPetWindow;
    private TamagotchiModelController tamagotchiModelController;

    public PlayPetWindowController(PlayPetWindowView playPetWindow, TamagotchiModelController tamagotchiModelController) {
        this.playPetWindow = playPetWindow;
        this.tamagotchiModelController = tamagotchiModelController;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "okayPetPlayButtonPressed":
                playPetWindow.getPlayPetFrame().setVisible(false);
                break;
            case "tossBallButtonPressed":
                switch (tamagotchiModelController.getTamagotchiModel().getPetType()) {
                    case "Ёж":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/sonic_collect.png"));
                            playPetWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Заяц":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/pinky_collect.png"));
                            playPetWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Лис":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/puppy_collect.png"));
                            playPetWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                }

                int happinessState = tamagotchiModelController.getTamagotchiModel().getHappinessState();
                happinessState = Math.min(happinessState + 10, 100);
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
                break;
            case "playGameOfTagButtonPressed":
                switch (tamagotchiModelController.getTamagotchiModel().getPetType()) {
                    case "Ёж":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/sonic_run.png"));
                            playPetWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Заяц":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/pinky_run.png"));
                            playPetWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Лис":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/puppy_run.png"));
                            playPetWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                }

                happinessState = tamagotchiModelController.getTamagotchiModel().getHappinessState();
                happinessState = Math.min(happinessState + 20, 100);
                tamagotchiModelController.getTamagotchiModel().setHappinessState(happinessState);
                tamagotchiModelController.getModelPropertyChange().firePropertyChange("HappinessStateProperty", 0, 1);

                vivacityState = tamagotchiModelController.getTamagotchiModel().getVivacityState();
                vivacityState = Math.max(vivacityState - 20, 0);
                tamagotchiModelController.getTamagotchiModel().setVivacityState(vivacityState);
                tamagotchiModelController.getModelPropertyChange().firePropertyChange("VivacityStateProperty", 0, 1);

                satietyState = tamagotchiModelController.getTamagotchiModel().getSatietyState();
                satietyState = Math.max(satietyState - 4, 0);
                tamagotchiModelController.getTamagotchiModel().setSatietyState(satietyState);
                tamagotchiModelController.getModelPropertyChange().firePropertyChange("SatietyStateProperty", 0, 1);
                break;
        }
    }
}
