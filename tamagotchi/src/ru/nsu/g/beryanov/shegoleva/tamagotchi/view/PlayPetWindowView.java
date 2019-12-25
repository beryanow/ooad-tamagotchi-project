package ru.nsu.g.beryanov.shegoleva.tamagotchi.view;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.ChiefWindowController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlayPetWindowView extends JFrame {
    private JFrame playPetFrame;
    private JLabel petPicture;

    private JLabel getPetPicture() {
        return petPicture;
    }

    private JFrame getPlayPetFrame() {
        return playPetFrame;
    }

    public void createPlayPetWindow(ChiefWindowController chiefWindowController) {
        playPetFrame = new JFrame("Игра с питомцем");
        playPetFrame.getContentPane().setBackground(Color.white);

        JButton okayPlayPetButton = new JButton("Закончить игру");
        okayPlayPetButton.addActionListener(e -> {
            chiefWindowController.getPlayPetWindow().getPlayPetFrame().setVisible(false);
        });

        JButton tossBallButton = new JButton("Бросить мячик");
        tossBallButton.addActionListener(e -> {
            switch (chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getPetType()) {
                case "Ёж":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/sonic_collect.png"));
                        chiefWindowController.getPlayPetWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Заяц":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/pinky_collect.png"));
                        chiefWindowController.getPlayPetWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Лис":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/puppy_collect.png"));
                        chiefWindowController.getPlayPetWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            int happinessState = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getHappinessState();
            happinessState = Math.min(happinessState + 10, 100);
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
        });

        JButton playGameOfTagButton = new JButton("Играть в догонялки");
        playGameOfTagButton.addActionListener(e -> {
            switch (chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getPetType()) {
                case "Ёж":
                    try {
                        BufferedImage bufferedPicture = ImageIO.read(new File("resources/sonic_run.png"));
                        chiefWindowController.getPlayPetWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Заяц":
                    try {
                        BufferedImage bufferedPicture = ImageIO.read(new File("resources/pinky_run.png"));
                        chiefWindowController.getPlayPetWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Лис":
                    try {
                        BufferedImage bufferedPicture = ImageIO.read(new File("resources/puppy_run.png"));
                        chiefWindowController.getPlayPetWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            int happinessState = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getHappinessState();
            happinessState = Math.min(happinessState + 20, 100);
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setHappinessState(happinessState);
            chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("HappinessStateProperty", 0, 1);

            int vivacityState = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getVivacityState();
            vivacityState = Math.max(vivacityState - 20, 0);
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setVivacityState(vivacityState);
            chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("VivacityStateProperty", 0, 1);

            int satietyState = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getSatietyState();
            satietyState = Math.max(satietyState - 4, 0);
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setSatietyState(satietyState);
            chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("SatietyStateProperty", 0, 1);
        });

        playGameOfTagButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        tossBallButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okayPlayPetButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.white);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.add(playGameOfTagButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(tossBallButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(okayPlayPetButton);

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

        playPetFrame.setLayout(new FlowLayout());
        playPetFrame.setSize(430, 250);

        playPetFrame.add(petPicture);
        playPetFrame.add(buttonsPanel);
        playPetFrame.setIconImage(new ImageIcon("resources/icon.png").getImage());
        playPetFrame.setLocationRelativeTo(null);
        playPetFrame.setVisible(true);
    }
}

