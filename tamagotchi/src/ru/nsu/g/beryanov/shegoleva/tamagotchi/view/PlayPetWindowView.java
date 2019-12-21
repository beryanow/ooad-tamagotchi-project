package ru.nsu.g.beryanov.shegoleva.tamagotchi.view;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.TamagotchiModelController;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.PlayPetWindowController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlayPetWindowView {
    private JFrame playPetFrame;
    private JLabel petPicture;
    private JButton tossBallButton;
    private JButton playGameOfTagButton;
    private JButton okayPlayPetButton;

    public JLabel getPetPicture() {
        return petPicture;
    }

    public JFrame getPlayPetFrame() {
        return playPetFrame;
    }

    private void createPlayPetWindow(TamagotchiModelController tamagotchiModelController) {
        playPetFrame = new JFrame("Игра с питомцем");
        playPetFrame.getContentPane().setBackground(Color.white);

        PlayPetWindowController playPetWindowController = new PlayPetWindowController(this, tamagotchiModelController);
        okayPlayPetButton = new JButton("Закончить игру");
        okayPlayPetButton.setActionCommand("okayPetPlayButtonPressed");
        okayPlayPetButton.addActionListener(playPetWindowController);

        tossBallButton = new JButton("Бросить мячик");
        tossBallButton.setActionCommand("tossBallButtonPressed");
        tossBallButton.addActionListener(playPetWindowController);

        playGameOfTagButton = new JButton("Играть в догонялки");
        playGameOfTagButton.setActionCommand("playGameOfTagButtonPressed");
        playGameOfTagButton.addActionListener(playPetWindowController);

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

        playPetFrame.setLayout(new FlowLayout());
        playPetFrame.setSize(430, 250);

        playPetFrame.add(petPicture);
        playPetFrame.add(buttonsPanel);
        playPetFrame.setIconImage(new ImageIcon("resources/icon.png").getImage());
        playPetFrame.setLocationRelativeTo(tamagotchiModelController.getWelcomeWindowView().getWelcomeFrame());
        playPetFrame.setVisible(true);
    }

    public PlayPetWindowView(TamagotchiModelController tamagotchiModelController) {
        createPlayPetWindow(tamagotchiModelController);
    }
}

