package ru.nsu.g.beryanov.shegoleva.tamagotchi.view;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.ChiefWindowController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WalkPetWindowView extends JFrame {
    private JFrame walkPetFrame;
    private JLabel petPicture;

    private JLabel getPetPicture() {
        return petPicture;
    }

    public void createWalkPetWindow(ChiefWindowController chiefWindowController) {
        walkPetFrame = new JFrame("Прогулка с питомцем");
        walkPetFrame.getContentPane().setBackground(Color.white);

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

        JButton returnHomeWalkPetButton = new JButton("Вернуться домой");
        returnHomeWalkPetButton.addActionListener(e -> walkPetFrame.setVisible(false));

        JButton batheLakeButton = new JButton("Покупаться в озере");
        batheLakeButton.addActionListener(e -> {
            switch (chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getPetType()) {
                case "Ёж":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/sonic_enjoy.png"));
                        chiefWindowController.getWalkPetWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Заяц":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/pinky_enjoy.png"));
                        chiefWindowController.getWalkPetWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Лис":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/puppy_enjoy.png"));
                        chiefWindowController.getWalkPetWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            int happinessState = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getHappinessState();
            happinessState = Math.min(happinessState + 50, 100);
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setHappinessState(happinessState);
            chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("HappinessStateProperty", 0, 1);

            int vivacityState = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getVivacityState();
            vivacityState = Math.max(vivacityState - 10, 0);
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setVivacityState(vivacityState);
            chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("VivacityStateProperty", 0, 1);

            int satietyState = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getSatietyState();
            satietyState = Math.max(satietyState - 2, 0);
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setSatietyState(satietyState);
            chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("SatietyStateProperty", 0, 1);

            int healthState = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getHealthState();
            healthState = Math.min(healthState + 20, 100);
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setHealthState(healthState);
            chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("HealthStateProperty", 0, 1);
        });


        JButton forestHuntButton = new JButton("Охотиться в лесу");
        forestHuntButton.addActionListener(e -> {
            switch (chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getPetType()) {
                case "Ёж":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/sonic_enjoy.png"));
                        chiefWindowController.getWalkPetWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Заяц":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/pinky_enjoy.png"));
                        chiefWindowController.getWalkPetWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Лис":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/puppy_enjoy.png"));
                        chiefWindowController.getWalkPetWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            int happinessState = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getHappinessState();
            happinessState = Math.min(happinessState + 25, 100);
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setHappinessState(happinessState);
            chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("HappinessStateProperty", 0, 1);

            int vivacityState = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getVivacityState();
            vivacityState = Math.max(vivacityState - 25, 0);
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setVivacityState(vivacityState);
            chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("VivacityStateProperty", 0, 1);

            int satietyState = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getSatietyState();
            satietyState = Math.max(satietyState - 4, 0);
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setSatietyState(satietyState);
            chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("SatietyStateProperty", 0, 1);

            int healthState = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getHealthState();
            healthState = Math.min(healthState + 30, 100);
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setHealthState(healthState);
            chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("HealthStateProperty", 0, 1);
        });

        forestHuntButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        batheLakeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnHomeWalkPetButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.white);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.add(forestHuntButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(batheLakeButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(returnHomeWalkPetButton);

        walkPetFrame.setLayout(new FlowLayout());
        walkPetFrame.setSize(440, 240);

        walkPetFrame.add(petPicture);
        walkPetFrame.add(buttonsPanel);
        walkPetFrame.setIconImage(new ImageIcon("resources/icon.png").getImage());
        walkPetFrame.setLocationRelativeTo(null);
        walkPetFrame.setVisible(true);
    }
}

