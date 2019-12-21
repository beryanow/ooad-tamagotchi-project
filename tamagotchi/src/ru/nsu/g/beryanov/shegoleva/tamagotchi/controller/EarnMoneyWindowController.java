package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.EarnMoneyWindowView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EarnMoneyWindowController implements ActionListener {
    private EarnMoneyWindowView earnMoneyWindow;
    private TamagotchiModelController tamagotchiModelController;

    public EarnMoneyWindowController(EarnMoneyWindowView earnMoneyWindow, TamagotchiModelController tamagotchiModelController) {
        this.earnMoneyWindow = earnMoneyWindow;
        this.tamagotchiModelController = tamagotchiModelController;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "okayEarnMoneyButtonPressed":
                earnMoneyWindow.getEarnMoneyFrame().setVisible(false);
                break;
            case "goWorkButtonPressed":
                switch (tamagotchiModelController.getTamagotchiModel().getPetType()) {
                    case "Ёж":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/sonic_collect.png"));
                            earnMoneyWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Заяц":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/pinky_collect.png"));
                            earnMoneyWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Лис":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/puppy_collect.png"));
                            earnMoneyWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                }

                int coinsAmount = tamagotchiModelController.getTamagotchiModel().getCoinsAmount();
                coinsAmount += 50;
                tamagotchiModelController.getTamagotchiModel().setCoinsAmount(coinsAmount);
                tamagotchiModelController.getModelPropertyChange().firePropertyChange("OwnerProperty", 0, 1);
                break;
            case "sellSomethingButtonPressed":
                switch (tamagotchiModelController.getTamagotchiModel().getPetType()) {
                    case "Ёж":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/sonic_collect.png"));
                            earnMoneyWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Заяц":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/pinky_collect.png"));
                            earnMoneyWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Лис":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/puppy_collect.png"));
                            earnMoneyWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                }

                coinsAmount = tamagotchiModelController.getTamagotchiModel().getCoinsAmount();
                coinsAmount += 20;
                tamagotchiModelController.getTamagotchiModel().setCoinsAmount(coinsAmount);
                tamagotchiModelController.getModelPropertyChange().firePropertyChange("OwnerProperty", 0, 1);
                break;
            case "askPeopleForMoneyButtonPressed":
                switch (tamagotchiModelController.getTamagotchiModel().getPetType()) {
                    case "Ёж":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/sonic_collect.png"));
                            earnMoneyWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Заяц":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/pinky_collect.png"));
                            earnMoneyWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Лис":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/puppy_collect.png"));
                            earnMoneyWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                }

                coinsAmount = tamagotchiModelController.getTamagotchiModel().getCoinsAmount();

                if ((int) (Math.random() * 2) == 1) {
                    coinsAmount++;
                    tamagotchiModelController.getTamagotchiModel().setCoinsAmount(coinsAmount);
                    tamagotchiModelController.getModelPropertyChange().firePropertyChange("OwnerProperty", 0, 1);
                }

                break;
        }
    }
}
