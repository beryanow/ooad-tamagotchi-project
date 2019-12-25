package ru.nsu.g.beryanov.shegoleva.tamagotchi.view;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.ChiefWindowController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VisitDoctorWindowView extends JFrame {
    private JFrame visitDoctorFrame;
    private JLabel petPicture;
    private JButton curePetButton;
    private JButton payForTreatmentButton;

    private JLabel getPetPicture() {
        return petPicture;
    }

    private JFrame getVisitDoctorFrame() {
        return visitDoctorFrame;
    }

    private JButton getPayForTreatmentButton() {
        return payForTreatmentButton;
    }

    private JButton getCurePetButton() {
        return curePetButton;
    }

    public void createVisitDoctorWindow(ChiefWindowController chiefWindowController) {
        visitDoctorFrame = new JFrame("Посещение ветеринара");
        visitDoctorFrame.getContentPane().setBackground(Color.white);

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

        JButton returnHomeVisitDoctorButton = new JButton("Вернуться домой");
        returnHomeVisitDoctorButton.addActionListener(e -> {
            chiefWindowController.getVisitDoctorWindow().getVisitDoctorFrame().setVisible(false);
        });

        curePetButton = new JButton("Вылечить питомца");
        curePetButton.setEnabled(false);
        curePetButton.addActionListener(e -> {
            switch (chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getPetType()) {
                case "Ёж":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/sonic_victory.png"));
                        chiefWindowController.getVisitDoctorWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Заяц":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/pinky_victory.png"));
                        chiefWindowController.getVisitDoctorWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Лис":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/puppy_victory.png"));
                        chiefWindowController.getVisitDoctorWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            int healthState = 100;
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setHealthState(healthState);
            chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("HealthStateProperty", 0, 1);
            chiefWindowController.getVisitDoctorWindow().getCurePetButton().setEnabled(false);
            chiefWindowController.getVisitDoctorWindow().getPayForTreatmentButton().setEnabled(true);
        });

        payForTreatmentButton = new JButton("Заплатить за лечение");
        payForTreatmentButton.addActionListener(e -> {
            switch (chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getPetType()) {
                case "Ёж":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/sonic_cool.png"));
                        chiefWindowController.getVisitDoctorWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Заяц":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/pinky_cool.png"));
                        chiefWindowController.getVisitDoctorWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Лис":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/puppy_cool.png"));
                        chiefWindowController.getVisitDoctorWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            int coinsAmount = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getCoinsAmount();
            if (coinsAmount - 2 < 0) {
                return;
            }
            coinsAmount -= 2;
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setCoinsAmount(coinsAmount);
            chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("OwnerProperty", 0, 1);

            chiefWindowController.getVisitDoctorWindow().getCurePetButton().setEnabled(true);
            chiefWindowController.getVisitDoctorWindow().getPayForTreatmentButton().setEnabled(false);
        });

        payForTreatmentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        curePetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnHomeVisitDoctorButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.white);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.add(payForTreatmentButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(curePetButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(returnHomeVisitDoctorButton);

        visitDoctorFrame.setLayout(new FlowLayout());
        visitDoctorFrame.setSize(450, 260);

        visitDoctorFrame.add(petPicture);
        visitDoctorFrame.add(buttonsPanel);
        visitDoctorFrame.setIconImage(new ImageIcon("resources/icon.png").getImage());
        visitDoctorFrame.setLocationRelativeTo(null);
        visitDoctorFrame.setVisible(true);
    }
}

