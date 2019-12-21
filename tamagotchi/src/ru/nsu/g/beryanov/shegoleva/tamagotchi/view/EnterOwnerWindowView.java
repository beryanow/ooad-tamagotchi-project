package ru.nsu.g.beryanov.shegoleva.tamagotchi.view;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.TamagotchiModelController;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.EnterOwnerWindowController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EnterOwnerWindowView {
    private JFrame enterOwnerFrame;
    private JLabel ownerName;
    private JLabel coinsAmount;
    private JLabel ownerAge;
    private JButton okayEnterOwnerButton;
    private JTextField ownerNameInput;
    private JTextField coinsAmountInput;
    private JLabel ownerLabel;
    private JComboBox comboGenders;

    public JLabel getOwnerLabel() {
        return ownerLabel;
    }

    public JFrame getEnterOwnerFrame() {
        return enterOwnerFrame;
    }

    public String getOwnerName() {
        if (ownerNameInput.getText().equals("")) {
            if (comboGenders.getSelectedItem().equals("Женский"))
                return "Ариана";
            else return "Джордан";
        }
        return ownerNameInput.getText();
    }

    public String getOwnerGender() {
        return (String) comboGenders.getSelectedItem();
    }

    public int getCoinsAmount() {
        try {
            return Integer.parseInt(coinsAmountInput.getText());
        } catch (Exception e) {
            return 100;
        }
    }

    private void createEnterOwnerWindow(TamagotchiModelController tamagotchiModelController) {
        enterOwnerFrame = new JFrame("Ввод данных владельца");
        enterOwnerFrame.getContentPane().setBackground(Color.white);

        ownerName = new JLabel("Введите имя владельца:");
        ownerAge = new JLabel("Выберите пол владельца:");
        coinsAmount = new JLabel("Введите количество монет:");

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

        EnterOwnerWindowController enterOwnerWindowController = new EnterOwnerWindowController(this, tamagotchiModelController.getWelcomeWindowView(), tamagotchiModelController.getTamagotchiModel());
        okayEnterOwnerButton = new JButton("Ок");
        okayEnterOwnerButton.setActionCommand("okayEnterOwnerButtonPressed");
        okayEnterOwnerButton.addActionListener(enterOwnerWindowController);
        comboGenders.addItemListener(enterOwnerWindowController);

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
            System.out.println(e.getMessage());
        }
        ownerLabel = new JLabel(new ImageIcon(bufferedPicture));

        enterOwnerFrame.add(ownerLabel);
        enterOwnerFrame.add(enterOwnerInputPanel);
        enterOwnerFrame.add(buttonsPanel);
        enterOwnerFrame.setIconImage(new ImageIcon("resources/icon.png").getImage());
        enterOwnerFrame.setLocationRelativeTo(tamagotchiModelController.getWelcomeWindowView().getWelcomeFrame());
        enterOwnerFrame.setVisible(true);
    }

    public EnterOwnerWindowView(TamagotchiModelController tamagotchiModelController) {
        createEnterOwnerWindow(tamagotchiModelController);
    }
}

