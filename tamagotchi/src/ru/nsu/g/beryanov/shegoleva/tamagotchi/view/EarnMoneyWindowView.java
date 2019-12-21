package ru.nsu.g.beryanov.shegoleva.tamagotchi.view;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.TamagotchiModelController;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.EarnMoneyWindowController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EarnMoneyWindowView {
    private JFrame earnMoneyFrame;
    private JButton goWorkButton;
    private JButton sellSomethingButton;
    private JButton askPeopleForMoneyButton;
    private JButton okayEarnMoneyButton;
    private JLabel petPicture;

    public JLabel getPetPicture() {
        return petPicture;
    }

    public JFrame getEarnMoneyFrame() {
        return earnMoneyFrame;
    }

    private void createEarnMoneyWindow(TamagotchiModelController tamagotchiModelController) {
        earnMoneyFrame = new JFrame("Заработок денег");
        earnMoneyFrame.getContentPane().setBackground(Color.white);

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

        EarnMoneyWindowController earnMoneyWindowController = new EarnMoneyWindowController(this, tamagotchiModelController);

        goWorkButton = new JButton("Пойти на работу");
        goWorkButton.setActionCommand("goWorkButtonPressed");
        goWorkButton.addActionListener(earnMoneyWindowController);

        sellSomethingButton = new JButton("Продать ненужную вещь");
        sellSomethingButton.setActionCommand("sellSomethingButtonPressed");
        sellSomethingButton.addActionListener(earnMoneyWindowController);

        askPeopleForMoneyButton = new JButton("Попросить у прохожих");
        askPeopleForMoneyButton.setActionCommand("askPeopleForMoneyButtonPressed");
        askPeopleForMoneyButton.addActionListener(earnMoneyWindowController);

        okayEarnMoneyButton = new JButton("Закончить заработок");
        okayEarnMoneyButton.setActionCommand("okayEarnMoneyButtonPressed");
        okayEarnMoneyButton.addActionListener(earnMoneyWindowController);

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
        earnMoneyFrame.setLocationRelativeTo(tamagotchiModelController.getWelcomeWindowView().getWelcomeFrame());
        earnMoneyFrame.setVisible(true);
    }

    public EarnMoneyWindowView(TamagotchiModelController tamagotchiModelController) {
        createEarnMoneyWindow(tamagotchiModelController);
    }
}

