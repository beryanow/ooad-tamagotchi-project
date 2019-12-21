package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.FeedPetWindowView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FeedPetWindowController implements ActionListener {
    private FeedPetWindowView feedPetWindow;
    private TamagotchiModelController tamagotchiModelController;

    public FeedPetWindowController(FeedPetWindowView feedPetWindow, TamagotchiModelController tamagotchiModelController) {
        this.feedPetWindow = feedPetWindow;
        this.tamagotchiModelController = tamagotchiModelController;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "okayFeedPetButtonPressed":
                feedPetWindow.getFeedPetFrame().setVisible(false);
                break;
            case "feedDrinkButtonPressed":
                switch (tamagotchiModelController.getTamagotchiModel().getPetType()) {
                    case "Ёж":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/sonic_love.png"));
                            feedPetWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Заяц":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/pinky_love.png"));
                            feedPetWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Лис":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/puppy_love.png"));
                            feedPetWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                }

                int drinkAmount = tamagotchiModelController.getTamagotchiModel().getDrinkAmount();
                if (drinkAmount > 0) {
                    int satietyState = tamagotchiModelController.getTamagotchiModel().getSatietyState();
                    satietyState = Math.min(satietyState + 25, 100);
                    tamagotchiModelController.getTamagotchiModel().setSatietyState(satietyState);
                    tamagotchiModelController.getTamagotchiModel().setDrinkAmount(--drinkAmount);
                    tamagotchiModelController.getModelPropertyChange().firePropertyChange("OwnerProperty", 0, 1);
                    tamagotchiModelController.getModelPropertyChange().firePropertyChange("SatietyStateProperty", 0, 1);
                }
                break;
            case "feedFoodButtonPressed":
                switch (tamagotchiModelController.getTamagotchiModel().getPetType()) {
                    case "Ёж":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/sonic_love.png"));
                            feedPetWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Заяц":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/pinky_love.png"));
                            feedPetWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Лис":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/puppy_love.png"));
                            feedPetWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                }

                int foodAmount = tamagotchiModelController.getTamagotchiModel().getFoodAmount();
                if (foodAmount > 0) {
                    int satietyState = tamagotchiModelController.getTamagotchiModel().getSatietyState();
                    satietyState = Math.min(satietyState + 50, 100);
                    tamagotchiModelController.getTamagotchiModel().setSatietyState(satietyState);
                    tamagotchiModelController.getTamagotchiModel().setFoodAmount(--foodAmount);
                    tamagotchiModelController.getModelPropertyChange().firePropertyChange("OwnerProperty", 0, 1);
                    tamagotchiModelController.getModelPropertyChange().firePropertyChange("SatietyStateProperty", 0, 1);
                }
                break;
        }
    }
}
