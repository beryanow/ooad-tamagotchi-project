package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.VisitDoctorWindowView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VisitDoctorWindowController implements ActionListener {
    private VisitDoctorWindowView visitDoctorWindow;
    private TamagotchiModelController tamagotchiModelController;

    public VisitDoctorWindowController(VisitDoctorWindowView visitDoctorWindow, TamagotchiModelController tamagotchiModelController) {
        this.visitDoctorWindow = visitDoctorWindow;
        this.tamagotchiModelController = tamagotchiModelController;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "returnHomeVisitDoctorButtonPressed":
                visitDoctorWindow.getVisitDoctorFrame().setVisible(false);
                break;
            case "payForTreatmentButtonPressed":
                switch (tamagotchiModelController.getTamagotchiModel().getPetType()) {
                    case "Ёж":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/sonic_cool.png"));
                            visitDoctorWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Заяц":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/pinky_cool.png"));
                            visitDoctorWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Лис":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/puppy_cool.png"));
                            visitDoctorWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                }

                int coinsAmount = tamagotchiModelController.getTamagotchiModel().getCoinsAmount();
                if (coinsAmount - 2 < 0) {
                    break;
                }
                coinsAmount -= 2;
                tamagotchiModelController.getTamagotchiModel().setCoinsAmount(coinsAmount);
                tamagotchiModelController.getModelPropertyChange().firePropertyChange("OwnerProperty", 0, 1);

                visitDoctorWindow.getCurePetButton().setEnabled(true);
                visitDoctorWindow.getPayForTreatmentButton().setEnabled(false);
                break;
            case "curePetButtonPressed":
                switch (tamagotchiModelController.getTamagotchiModel().getPetType()) {
                    case "Ёж":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/sonic_victory.png"));
                            visitDoctorWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Заяц":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/pinky_victory.png"));
                            visitDoctorWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "Лис":
                        try {
                            BufferedImage bufferedPicture = ImageIO.read(new File("resources/puppy_victory.png"));
                            visitDoctorWindow.getPetPicture().setIcon(new ImageIcon(bufferedPicture));
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                }


                int healthState = 100;
                tamagotchiModelController.getTamagotchiModel().setHealthState(healthState);
                tamagotchiModelController.getModelPropertyChange().firePropertyChange("HealthStateProperty", 0, 1);
                visitDoctorWindow.getCurePetButton().setEnabled(false);
                visitDoctorWindow.getPayForTreatmentButton().setEnabled(true);
                break;
        }
    }
}
