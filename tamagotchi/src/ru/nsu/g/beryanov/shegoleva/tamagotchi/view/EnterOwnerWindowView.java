package ru.nsu.g.beryanov.shegoleva.tamagotchi.view;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.ChiefWindowController;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.model.Owner;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EnterOwnerWindowView extends JFrame {
    private JFrame enterOwnerFrame;
    private JTextField ownerNameInput;
    private JTextField coinsAmountInput;
    private JLabel ownerLabel;
    private JComboBox comboGenders;

    private JLabel getOwnerLabel() {
        return ownerLabel;
    }

    private JFrame getEnterOwnerFrame() {
        return enterOwnerFrame;
    }

    private String getOwnerName() {
        if (ownerNameInput.getText().equals("")) {
            if (comboGenders.getSelectedItem().equals("Женский"))
                return "Ариана";
            else return "Джордан";
        }
        return ownerNameInput.getText();
    }

    private String getOwnerGender() {
        return (String) comboGenders.getSelectedItem();
    }

    private int getCoinsAmount() {
        try {
            return Integer.parseInt(coinsAmountInput.getText());
        } catch (Exception e) {
            return 100;
        }
    }

    public void createEnterOwnerWindow(ChiefWindowController chiefWindowController) {
        enterOwnerFrame = new JFrame("Ввод данных владельца");
        enterOwnerFrame.getContentPane().setBackground(Color.white);

        JLabel ownerName = new JLabel("Введите имя владельца:");
        JLabel ownerAge = new JLabel("Выберите пол владельца:");
        JLabel coinsAmount = new JLabel("Введите количество монет:");

        ownerNameInput = new JTextField();
        ownerNameInput.setHorizontalAlignment(SwingConstants.CENTER);
        ownerNameInput.setPreferredSize(new Dimension(200, 30));

        coinsAmountInput = new JTextField();
        coinsAmountInput.setHorizontalAlignment(SwingConstants.CENTER);
        coinsAmountInput.setPreferredSize(new Dimension(200, 30));

        String[] genders = new String[]{"Мужской", "Женский"};
        comboGenders = new JComboBox(genders);
        comboGenders.setSelectedIndex(0);
        comboGenders.setPreferredSize(new Dimension(200, 30));

        JButton okayEnterOwnerButton = new JButton("Ок");
        okayEnterOwnerButton.setActionCommand("okayEnterOwnerButtonPressed");
        okayEnterOwnerButton.addActionListener(e -> {
            chiefWindowController.getWelcomeWindow().setEnterOwnerFlag();
            if (chiefWindowController.getWelcomeWindow().getNewPetFlag() && chiefWindowController.getWelcomeWindow().getEnterOwner()) {
                chiefWindowController.getWelcomeWindow().getStartGameButton().setEnabled(true);
            }

            String ownerName1 = chiefWindowController.getEnterOwnerWindow().getOwnerName();
            String ownerGender = chiefWindowController.getEnterOwnerWindow().getOwnerGender();
            int coinsAmount1 = chiefWindowController.getEnterOwnerWindow().getCoinsAmount();

            Owner owner = new Owner(ownerName1, ownerGender, coinsAmount1);

            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setOwner(ownerName1, coinsAmount1, ownerGender);

            chiefWindowController.getEnterOwnerWindow().getEnterOwnerFrame().setVisible(false);
        });

        comboGenders.addItemListener(e-> {
            String pet = (String) e.getItem();
            switch (pet) {
                case "Мужской":
                    BufferedImage bufferedPicture = null;
                    try {
                        bufferedPicture = ImageIO.read(new File("resources/man.png"));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }

                    JLabel ownerLabel = chiefWindowController.getEnterOwnerWindow().getOwnerLabel();
                    ownerLabel.setIcon(new ImageIcon(bufferedPicture));
                    break;
                case "Женский":
                    bufferedPicture = null;
                    try {
                        bufferedPicture = ImageIO.read(new File("resources/woman.png"));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }

                    ownerLabel = chiefWindowController.getEnterOwnerWindow().getOwnerLabel();
                    ownerLabel.setIcon(new ImageIcon(bufferedPicture));
                    break;
            }
        });

        JPanel enterOwnerInputPanel = new JPanel();
        enterOwnerInputPanel.setBackground(Color.white);
        enterOwnerInputPanel.setLayout(new FlowLayout());
        enterOwnerInputPanel.setPreferredSize(new Dimension(200, 190));
        enterOwnerInputPanel.add(ownerName);
        enterOwnerInputPanel.add(ownerNameInput);
        enterOwnerInputPanel.add(ownerAge);
        enterOwnerInputPanel.add(comboGenders);
        enterOwnerInputPanel.add(coinsAmount);
        enterOwnerInputPanel.add(coinsAmountInput);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.white);
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.add(okayEnterOwnerButton);

        enterOwnerFrame.setLayout(new FlowLayout());
        enterOwnerFrame.setSize(280, 540);

        BufferedImage bufferedPicture = null;
        try {
            bufferedPicture = ImageIO.read(new File("resources/man.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ownerLabel = new JLabel(new ImageIcon(bufferedPicture));

        enterOwnerFrame.add(ownerLabel);
        enterOwnerFrame.add(enterOwnerInputPanel);
        enterOwnerFrame.add(buttonsPanel);
        enterOwnerFrame.setIconImage(new ImageIcon("resources/icon.png").getImage());
        enterOwnerFrame.setLocationRelativeTo(null);
        enterOwnerFrame.setVisible(true);
    }
}

