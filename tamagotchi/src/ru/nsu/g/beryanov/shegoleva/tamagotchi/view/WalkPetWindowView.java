package ru.nsu.g.beryanov.shegoleva.tamagotchi.view;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.TamagotchiModelController;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.WalkPetWindowController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WalkPetWindowView {
    private JFrame walkPetFrame;
    private JButton batheLakeButton;
    private JButton forestHuntButton;
    private JButton returnHomeWalkPetButton;
    private JLabel petPicture;

    public JLabel getPetPicture() {
        return petPicture;
    }

    public JFrame getWalkPetFrame() {
        return walkPetFrame;
    }

    private void createWalkPetWindow(TamagotchiModelController tamagotchiModelController) {
        walkPetFrame = new JFrame("Прогулка с питомцем");
        walkPetFrame.getContentPane().setBackground(Color.white);

        BufferedImage bufferedPicture = null;
        try {
            switch (tamagotchiModelController.getTamagotchiModel().getPetType()) {
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
            System.out.println(e.getMessage());
        }
        petPicture = new JLabel(new ImageIcon(bufferedPicture));

        WalkPetWindowController walkPetWindowController = new WalkPetWindowController(this, tamagotchiModelController);
        returnHomeWalkPetButton = new JButton("Вернуться домой");
        returnHomeWalkPetButton.setActionCommand("returnHomeWalkPetButtonPressed");
        returnHomeWalkPetButton.addActionListener(walkPetWindowController);

        batheLakeButton = new JButton("Покупаться в озере");
        batheLakeButton.setActionCommand("batheLakeButtonPressed");
        batheLakeButton.addActionListener(walkPetWindowController);

        forestHuntButton = new JButton("Охотиться в лесу");
        forestHuntButton.setActionCommand("forestHuntButtonPressed");
        forestHuntButton.addActionListener(walkPetWindowController);

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
        walkPetFrame.setLocationRelativeTo(tamagotchiModelController.getWelcomeWindowView().getWelcomeFrame());
        walkPetFrame.setVisible(true);
    }

    public WalkPetWindowView(TamagotchiModelController tamagotchiModelController) {
        createWalkPetWindow(tamagotchiModelController);
    }
}

