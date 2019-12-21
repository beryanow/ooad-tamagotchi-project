package ru.nsu.g.beryanov.shegoleva.tamagotchi.view;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.TamagotchiModelController;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.WelcomeWindowController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WelcomeWindowView {
    private boolean newPetFlag;
    private boolean enterOwnerFlag;
    private JButton newPetButton;
    private JButton startGameButton;
    private JButton ownerInfoButton;
    private JFrame welcomeFrame;

    public void setNewPetFlag() {
        newPetFlag = true;
    }

    public void setEnterOwnerFlag() {
        enterOwnerFlag = true;
    }

    public boolean getNewPetFlag() {
        return newPetFlag;
    }

    public boolean getEnterOwner() {
        return enterOwnerFlag;
    }

    public JFrame getWelcomeFrame() {
        return welcomeFrame;
    }

    public JButton getNewPetButton() {
        return newPetButton;
    }

    public JButton getStartGameButton() {
        return startGameButton;
    }

    private void createWelcomeWindow() throws IOException {
        welcomeFrame = new JFrame("Начало");
        welcomeFrame.getContentPane().setBackground(Color.white);

        TamagotchiModelController tamagotchiModelController = new TamagotchiModelController(this);
        WelcomeWindowController welcomeWindowController = new WelcomeWindowController(tamagotchiModelController, this, tamagotchiModelController.getTamagotchiModel());

        newPetButton = new JButton("Выбрать питомца");
        newPetButton.setActionCommand("newPetButtonPressed");
        newPetButton.addActionListener(welcomeWindowController);

        ownerInfoButton = new JButton("Ввести данные владельца");
        ownerInfoButton.setActionCommand("ownerInfoButtonPressed");
        ownerInfoButton.addActionListener(welcomeWindowController);

        startGameButton = new JButton("Начать игру Тамагочи");
        startGameButton.setEnabled(false);
        startGameButton.setActionCommand("startGameButtonPressed");
        startGameButton.addActionListener(welcomeWindowController);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.white);
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.add(newPetButton);
        buttonsPanel.add(ownerInfoButton);
        buttonsPanel.add(startGameButton);
        buttonsPanel.setPreferredSize(new Dimension(300, 400));

        JPanel ownerInputPanel = new JPanel();
        ownerInputPanel.setBackground(Color.white);
        ownerInputPanel.setLayout(new FlowLayout());
        ownerInputPanel.setPreferredSize(new Dimension(200, 400));

        welcomeFrame.setLayout(new FlowLayout());
        welcomeFrame.setSize(360, 500);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BufferedImage bufferedPicture = ImageIO.read(new File("resources/main.png"));
        JLabel picLabel = new JLabel(new ImageIcon(bufferedPicture));

        welcomeFrame.add(picLabel);
        welcomeFrame.add(buttonsPanel);
        welcomeFrame.add(ownerInputPanel);
        welcomeFrame.setIconImage(new ImageIcon("resources/icon.png").getImage());
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setVisible(true);
    }

    public WelcomeWindowView() throws IOException {
        newPetFlag = false;
        enterOwnerFlag = false;
        createWelcomeWindow();
    }
}

