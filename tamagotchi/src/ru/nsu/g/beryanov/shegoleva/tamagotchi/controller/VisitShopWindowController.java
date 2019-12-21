package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.VisitShopWindowView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VisitShopWindowController implements ActionListener {
    private VisitShopWindowView visitShopWindowView;
    private TamagotchiModelController tamagotchiModelController;

    public VisitShopWindowController(VisitShopWindowView visitShopWindowView, TamagotchiModelController tamagotchiModelController) {
        this.visitShopWindowView = visitShopWindowView;
        this.tamagotchiModelController = tamagotchiModelController;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "returnHomeVisitShopButtonPressed":
                visitShopWindowView.getVisitShopFrame().setVisible(false);
                break;
            case "buyFoodButtonPressed":
                switch (tamagotchiModelController.getTamagotchiModel().getPetType()) {
                    case "Ёж":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/sonic_food.png"));
                            visitShopWindowView.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Заяц":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/pinky_food.png"));
                            visitShopWindowView.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Лис":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/puppy_food.png"));
                            visitShopWindowView.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                }

                int coinsAmount = tamagotchiModelController.getTamagotchiModel().getCoinsAmount();
                if (coinsAmount - 10 < 0) {
                    break;
                }
                coinsAmount -= 10;
                tamagotchiModelController.getTamagotchiModel().setCoinsAmount(coinsAmount);

                int foodAmount = tamagotchiModelController.getTamagotchiModel().getFoodAmount();
                foodAmount++;
                tamagotchiModelController.getTamagotchiModel().setFoodAmount(foodAmount);
                tamagotchiModelController.getModelPropertyChange().firePropertyChange("OwnerProperty", 0, 1);
                break;
            case "buyDrinkButtonPressed":
                switch (tamagotchiModelController.getTamagotchiModel().getPetType()) {
                    case "Ёж":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/sonic_food.png"));
                            visitShopWindowView.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Заяц":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/pinky_food.png"));
                            visitShopWindowView.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Лис":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/puppy_food.png"));
                            visitShopWindowView.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                }

                coinsAmount = tamagotchiModelController.getTamagotchiModel().getCoinsAmount();
                if (coinsAmount - 5 < 0) {
                    break;
                }
                coinsAmount -= 5;
                tamagotchiModelController.getTamagotchiModel().setCoinsAmount(coinsAmount);

                int drinkAmount = tamagotchiModelController.getTamagotchiModel().getDrinkAmount();
                drinkAmount++;
                tamagotchiModelController.getTamagotchiModel().setDrinkAmount(drinkAmount);
                tamagotchiModelController.getModelPropertyChange().firePropertyChange("OwnerProperty", 0, 1);
                break;
        }
    }
}
