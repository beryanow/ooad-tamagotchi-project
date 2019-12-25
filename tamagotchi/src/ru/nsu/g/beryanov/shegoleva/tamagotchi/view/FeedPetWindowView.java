package ru.nsu.g.beryanov.shegoleva.tamagotchi.view;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.ChiefWindowController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FeedPetWindowView extends JFrame {
    private JFrame feedPetFrame;
    private JLabel petPicture;

    private JLabel getPetPicture() {
        return petPicture;
    }

    private JFrame getFeedPetFrame() {
        return feedPetFrame;
    }

    public void createWalkPetWindow(ChiefWindowController chiefWindowController) {
        feedPetFrame = new JFrame("Кормление питомца");
        feedPetFrame.getContentPane().setBackground(Color.white);

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

        JButton okayFeedPetButton = new JButton("Закончить приём пищи");
        okayFeedPetButton.addActionListener(e -> {
            chiefWindowController.getFeedPetWindow().getFeedPetFrame().setVisible(false);
        });

        JButton feedFoodButton = new JButton("Накормить");
        feedFoodButton.addActionListener(e -> {
            switch (chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getPetType()) {
                case "Ёж":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/sonic_love.png"));
                        chiefWindowController.getFeedPetWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Заяц":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/pinky_love.png"));
                        chiefWindowController.getFeedPetWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Лис":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/puppy_love.png"));
                        chiefWindowController.getFeedPetWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            int foodAmount = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getFoodAmount();
            if (foodAmount > 0) {
                int satietyState = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getSatietyState();
                satietyState = Math.min(satietyState + 50, 100);
                chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setSatietyState(satietyState);
                chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setFoodAmount(--foodAmount);
                chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("OwnerProperty", 0, 1);
                chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("SatietyStateProperty", 0, 1);
            }
        });

        JButton feedDrinkButton = new JButton("Напоить");
        feedDrinkButton.addActionListener(e -> {
            switch (chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getPetType()) {
                case "Ёж":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/sonic_love.png"));
                        chiefWindowController.getFeedPetWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Заяц":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/pinky_love.png"));
                        chiefWindowController.getFeedPetWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Лис":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/puppy_love.png"));
                        chiefWindowController.getFeedPetWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            int drinkAmount = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getDrinkAmount();
            if (drinkAmount > 0) {
                int satietyState = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getSatietyState();
                satietyState = Math.min(satietyState + 25, 100);
                chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setSatietyState(satietyState);
                chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setDrinkAmount(--drinkAmount);
                chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("OwnerProperty", 0, 1);
                chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("SatietyStateProperty", 0, 1);
            }
        });

        feedFoodButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        feedDrinkButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okayFeedPetButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.white);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

        buttonsPanel.add(feedDrinkButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(feedFoodButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(okayFeedPetButton);

        feedPetFrame.setLayout(new FlowLayout());
        feedPetFrame.setSize(460, 250);

        feedPetFrame.add(petPicture);
        feedPetFrame.add(buttonsPanel);
        feedPetFrame.setIconImage(new ImageIcon("resources/icon.png").getImage());
        feedPetFrame.setLocationRelativeTo(null);
        feedPetFrame.setVisible(true);
    }
}

