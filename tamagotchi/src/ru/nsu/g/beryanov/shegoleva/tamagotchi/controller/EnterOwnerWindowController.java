package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.model.TamagotchiModel;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.EnterOwnerWindowView;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.WelcomeWindowView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EnterOwnerWindowController implements ActionListener, ItemListener {
    private EnterOwnerWindowView enterOwnerWindow;
    private WelcomeWindowView welcomeWindow;
    private TamagotchiModel tamagotchiModel;

    public EnterOwnerWindowController(EnterOwnerWindowView enterOwnerWindow, WelcomeWindowView welcomeWindow, TamagotchiModel tamagotchiModel) {
        this.enterOwnerWindow = enterOwnerWindow;
        this.welcomeWindow = welcomeWindow;
        this.tamagotchiModel = tamagotchiModel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "okayEnterOwnerButtonPressed":
                welcomeWindow.setEnterOwnerFlag();
                if (welcomeWindow.getNewPetFlag() && welcomeWindow.getEnterOwner()) {
                    welcomeWindow.getStartGameButton().setEnabled(true);
                }

                String ownerName = enterOwnerWindow.getOwnerName();
                String ownerGender = enterOwnerWindow.getOwnerGender();
                int coinsAmount = enterOwnerWindow.getCoinsAmount();

                tamagotchiModel.setOwner(ownerName, coinsAmount, ownerGender);

                enterOwnerWindow.getEnterOwnerFrame().setVisible(false);
                break;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String pet = (String) e.getItem();
        switch (pet) {
            case "Мужской":
                BufferedImage bufferedPicture = null;
                try {
                    bufferedPicture = ImageIO.read(new File("resources/man.png"));
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

                JLabel ownerLabel = enterOwnerWindow.getOwnerLabel();
                ownerLabel.setIcon(new ImageIcon(bufferedPicture));
                break;
            case "Женский":
                bufferedPicture = null;
                try {
                    bufferedPicture = ImageIO.read(new File("resources/woman.png"));
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

                ownerLabel = enterOwnerWindow.getOwnerLabel();
                ownerLabel.setIcon(new ImageIcon(bufferedPicture));
                break;
        }
    }
}
