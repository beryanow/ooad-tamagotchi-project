package ru.nsu.g.beryanov.shegoleva.tamagotchi.view;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.ChiefWindowController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EarnMoneyWindowView extends JFrame {
    private JFrame earnMoneyFrame;
    private JLabel petPicture;

    private JLabel getPetPicture() {
        return petPicture;
    }

    private JFrame getEarnMoneyFrame() {
        return earnMoneyFrame;
    }

    public void createEarnMoneyWindow(ChiefWindowController chiefWindowController) {
        earnMoneyFrame = new JFrame("Заработок денег");
        earnMoneyFrame.getContentPane().setBackground(Color.white);

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

        JButton goWorkButton = new JButton("Пойти на работу");
        goWorkButton.addActionListener(e -> {
            switch (chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getPetType()) {
                case "Ёж":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/sonic_collect.png"));
                        chiefWindowController.getEarnMoneyWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Заяц":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/pinky_collect.png"));
                        chiefWindowController.getEarnMoneyWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Лис":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/puppy_collect.png"));
                        chiefWindowController.getEarnMoneyWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            int coinsAmount = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getCoinsAmount();
            coinsAmount += 50;
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setCoinsAmount(coinsAmount);
            chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("OwnerProperty", 0, 1);
        });

        JButton sellSomethingButton = new JButton("Продать ненужную вещь");
        sellSomethingButton.addActionListener(e -> {
            switch (chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getPetType()) {
                case "Ёж":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/sonic_collect.png"));
                        chiefWindowController.getEarnMoneyWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Заяц":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/pinky_collect.png"));
                        chiefWindowController.getEarnMoneyWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Лис":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/puppy_collect.png"));
                        chiefWindowController.getEarnMoneyWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            int coinsAmount = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getCoinsAmount();
            coinsAmount += 20;
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setCoinsAmount(coinsAmount);
            chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("OwnerProperty", 0, 1);
        });

        JButton askPeopleForMoneyButton = new JButton("Попросить у прохожих");
        askPeopleForMoneyButton.addActionListener(e -> {
            switch (chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getPetType()) {
                case "Ёж":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/sonic_collect.png"));
                        chiefWindowController.getEarnMoneyWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Заяц":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/pinky_collect.png"));
                        chiefWindowController.getEarnMoneyWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Лис":
                    try {
                        BufferedImage bufferedPicture1 = ImageIO.read(new File("resources/puppy_collect.png"));
                        chiefWindowController.getEarnMoneyWindow().getPetPicture().setIcon(new ImageIcon(bufferedPicture1));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            int coinsAmount = chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getCoinsAmount();

            if ((int) (Math.random() * 2) == 1) {
                coinsAmount++;
                chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setCoinsAmount(coinsAmount);
                chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("OwnerProperty", 0, 1);
            }
        });

        JButton okayEarnMoneyButton = new JButton("Закончить заработок");
        okayEarnMoneyButton.addActionListener(e -> {
            chiefWindowController.getEarnMoneyWindow().getEarnMoneyFrame().setVisible(false);
        });

        goWorkButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        sellSomethingButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        askPeopleForMoneyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okayEarnMoneyButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.white);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

        buttonsPanel.add(goWorkButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(sellSomethingButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(askPeopleForMoneyButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(okayEarnMoneyButton);

        earnMoneyFrame.setLayout(new FlowLayout());
        earnMoneyFrame.setSize(500, 270);

        earnMoneyFrame.add(petPicture);
        earnMoneyFrame.add(buttonsPanel);
        earnMoneyFrame.setIconImage(new ImageIcon("resources/icon.png").getImage());
        earnMoneyFrame.setLocationRelativeTo(null);
        earnMoneyFrame.setVisible(true);
    }
}

