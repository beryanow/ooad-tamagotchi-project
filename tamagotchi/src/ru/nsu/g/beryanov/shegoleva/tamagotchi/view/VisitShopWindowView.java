package ru.nsu.g.beryanov.shegoleva.tamagotchi.view;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.ChiefWindowController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VisitShopWindowView extends JFrame {
    private JFrame visitShopFrame;
    private JLabel petPicture;

    private JLabel getPetPicture() {
        return petPicture;
    }

    private JFrame getVisitShopFrame() {
        return visitShopFrame;
    }

    public void createVisitShopWindow(ChiefWindowController chiefWindowController) {
        visitShopFrame = new JFrame("Поход в магазин");
        visitShopFrame.getContentPane().setBackground(Color.white);

        BufferedImage bufferedPicture = null;
        try {
            switch (chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getPetType()) {
                case "Ёж":
                    bufferedPicture = ImageIO.read(new File("resources/sonic_wait.png"));
                    break;
                case "Заяц":
                    bufferedPicture = ImageIO.read(new File("resources/pinky_wait.png"));
                    break;
                case "Лис":
                    bufferedPicture = ImageIO.read(new File("resources/puppy_wait.png"));
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        petPicture = new JLabel(new ImageIcon(bufferedPicture));

        JButton buyFoodButton = new JButton("Купить еду");
        buyFoodButton.addActionListener(e -> {
            switch (chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getPetType()) {
                case "Ёж":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/sonic_food.png"));
                        chiefWindowController.getVisitShopWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Заяц":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/pinky_food.png"));
                        chiefWindowController.getVisitShopWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Лис":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/puppy_food.png"));
                        chiefWindowController.getVisitShopWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            int coinsAmount = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getCoinsAmount();
            if (coinsAmount - 10 < 0) {
                return;
            }
            coinsAmount -= 10;
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setCoinsAmount(coinsAmount);

            int foodAmount = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getFoodAmount();
            foodAmount++;
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setFoodAmount(foodAmount);
            chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("OwnerProperty", 0, 1);
        });

        JButton buyDrinkButton = new JButton("Купить напитки");
        buyDrinkButton.addActionListener(e -> {
            switch (chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getPetType()) {
                case "Ёж":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/sonic_food.png"));
                        chiefWindowController.getVisitShopWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Заяц":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/pinky_food.png"));
                        chiefWindowController.getVisitShopWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Лис":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/puppy_food.png"));
                        chiefWindowController.getVisitShopWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            int coinsAmount = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getCoinsAmount();
            if (coinsAmount - 5 < 0) {
                return;
            }
            coinsAmount -= 5;
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setCoinsAmount(coinsAmount);

            int drinkAmount = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getDrinkAmount();
            drinkAmount++;
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setDrinkAmount(drinkAmount);
            chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("OwnerProperty", 0, 1);
        });

        JButton returnHomeVisitShopButton = new JButton("Вернуться домой");
        returnHomeVisitShopButton.addActionListener(e -> {
            chiefWindowController.getVisitShopWindow().getVisitShopFrame().setVisible(false);
        });

        buyFoodButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buyDrinkButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnHomeVisitShopButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.white);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

        buttonsPanel.add(buyFoodButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(buyDrinkButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(returnHomeVisitShopButton);

        visitShopFrame.setLayout(new FlowLayout());
        visitShopFrame.setSize(430, 260);

        visitShopFrame.add(petPicture);
        visitShopFrame.add(buttonsPanel);
        visitShopFrame.setIconImage(new ImageIcon("resources/icon.png").getImage());
        visitShopFrame.setLocationRelativeTo(null);
        visitShopFrame.setVisible(true);
    }
}

