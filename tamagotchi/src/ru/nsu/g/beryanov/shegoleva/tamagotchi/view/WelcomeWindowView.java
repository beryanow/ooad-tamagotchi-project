package ru.nsu.g.beryanov.shegoleva.tamagotchi.view;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.ChiefWindowController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WelcomeWindowView extends JFrame {
    private boolean newPetFlag;
    private boolean enterOwnerFlag;
    private JButton startGameButton;
    private JFrame welcomeFrame;

    void setNewPetFlag() {
        newPetFlag = true;
    }

    void setEnterOwnerFlag() {
        enterOwnerFlag = true;
    }

    boolean getNewPetFlag() {
        return newPetFlag;
    }

    boolean getEnterOwner() {
        return enterOwnerFlag;
    }

    JButton getStartGameButton() {
        return startGameButton;
    }

    public void createWelcomeWindow(ChiefWindowController chiefWindowController) {
        welcomeFrame = new JFrame("Начало");
        welcomeFrame.getContentPane().setBackground(Color.white);

        JButton newPetButton = new JButton("Выбрать питомца");
        newPetButton.addActionListener(e -> chiefWindowController.startCreatePetWindow());

        JButton ownerInfoButton = new JButton("Ввести данные владельца");
        ownerInfoButton.addActionListener(e -> chiefWindowController.startEnterOwnerWindow());

        startGameButton = new JButton("Начать игру Тамагочи");
        startGameButton.setEnabled(false);
        startGameButton.addActionListener(e -> chiefWindowController.startGameWindow());

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

        BufferedImage bufferedPicture = null;
        try {
            bufferedPicture = ImageIO.read(new File("resources/main.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel picLabel = new JLabel(new ImageIcon(bufferedPicture));

        welcomeFrame.add(picLabel);
        welcomeFrame.add(buttonsPanel);
        welcomeFrame.add(ownerInputPanel);
        welcomeFrame.setIconImage(new ImageIcon("resources/icon.png").getImage());
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setVisible(true);
    }

    public WelcomeWindowView()  {
        newPetFlag = false;
        enterOwnerFlag = false;
    }
}

