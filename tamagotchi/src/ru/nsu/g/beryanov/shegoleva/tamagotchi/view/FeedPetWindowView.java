package ru.nsu.g.beryanov.shegoleva.tamagotchi.view;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.TamagotchiModelController;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.FeedPetWindowController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FeedPetWindowView {
    private JFrame feedPetFrame;
    private JButton feedFoodButton;
    private JButton feedDrinkButton;
    private JButton okayFeedPetButton;
    private JLabel petPicture;

    public JLabel getPetPicture() {
        return petPicture;
    }

    public JFrame getFeedPetFrame() {
        return feedPetFrame;
    }

    private void createWalkPetWindow(TamagotchiModelController tamagotchiModelController) {
        feedPetFrame = new JFrame("Кормление питомца");
        feedPetFrame.getContentPane().setBackground(Color.white);

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

        FeedPetWindowController feedPetWindowController = new FeedPetWindowController(this, tamagotchiModelController);

        okayFeedPetButton = new JButton("Закончить приём пищи");
        okayFeedPetButton.setActionCommand("okayFeedPetButtonPressed");
        okayFeedPetButton.addActionListener(feedPetWindowController);

        feedFoodButton = new JButton("Накормить");
        feedFoodButton.setActionCommand("feedFoodButtonPressed");
        feedFoodButton.addActionListener(feedPetWindowController);

        feedDrinkButton = new JButton("Напоить");
        feedDrinkButton.setActionCommand("feedDrinkButtonPressed");
        feedDrinkButton.addActionListener(feedPetWindowController);

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
        feedPetFrame.setLocationRelativeTo(tamagotchiModelController.getWelcomeWindowView().getWelcomeFrame());
        feedPetFrame.setVisible(true);
    }

    public FeedPetWindowView(TamagotchiModelController tamagotchiModelController) {
        createWalkPetWindow(tamagotchiModelController);
    }
}

