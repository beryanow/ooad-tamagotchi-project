package ru.nsu.g.beryanov.shegoleva.tamagotchi.view;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.TamagotchiModelController;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.VisitDoctorWindowController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VisitDoctorWindowView {
    private JFrame visitDoctorFrame;
    private JLabel petPicture;
    private JButton curePetButton;
    private JButton payForTreatmentButton;
    private JButton returnHomeVisitDoctorButton;

    public JLabel getPetPicture() {
        return petPicture;
    }

    public JFrame getVisitDoctorFrame() {
        return visitDoctorFrame;
    }

    public JButton getPayForTreatmentButton() {
        return payForTreatmentButton;
    }

    public JButton getCurePetButton() {
        return curePetButton;
    }

    private void createVisitDoctorWindow(TamagotchiModelController tamagotchiModelController) {
        visitDoctorFrame = new JFrame("Посещение ветеринара");
        visitDoctorFrame.getContentPane().setBackground(Color.white);

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

        VisitDoctorWindowController visitDoctorWindowController = new VisitDoctorWindowController(this, tamagotchiModelController);

        returnHomeVisitDoctorButton = new JButton("Вернуться домой");
        returnHomeVisitDoctorButton.setActionCommand("returnHomeVisitDoctorButtonPressed");
        returnHomeVisitDoctorButton.addActionListener(visitDoctorWindowController);

        curePetButton = new JButton("Вылечить питомца");
        curePetButton.setEnabled(false);
        curePetButton.setActionCommand("curePetButtonPressed");
        curePetButton.addActionListener(visitDoctorWindowController);

        payForTreatmentButton = new JButton("Заплатить за лечение");
        payForTreatmentButton.setActionCommand("payForTreatmentButtonPressed");
        payForTreatmentButton.addActionListener(visitDoctorWindowController);

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
        visitDoctorFrame.setLocationRelativeTo(tamagotchiModelController.getWelcomeWindowView().getWelcomeFrame());
        visitDoctorFrame.setVisible(true);
    }

    public VisitDoctorWindowView(TamagotchiModelController tamagotchiModelController) {
        createVisitDoctorWindow(tamagotchiModelController);
    }
}

