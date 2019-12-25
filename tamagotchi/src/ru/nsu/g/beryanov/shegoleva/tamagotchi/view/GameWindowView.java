package ru.nsu.g.beryanov.shegoleva.tamagotchi.view;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.ChiefWindowController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindowView extends JFrame {
    private JFrame gameFrame;
    private JLabel ownerName;
    private JLabel coinsAmount;
    private JLabel ownerAge;
    private JLabel foodAmount;
    private JLabel waterAmount;

    private JLabel petName;
    private JLabel petType;
    private JLabel petAge;

    private JProgressBar happinessBar;
    private JProgressBar satietyBar;
    private JProgressBar vivacityBar;
    private JProgressBar healthBar;

    public JProgressBar getHappinessBar() {
        return happinessBar;
    }

    public JProgressBar getSatietyBar() {
        return satietyBar;
    }

    public JProgressBar getVivacityBar() {
        return vivacityBar;
    }

    public JProgressBar getHealthBar() {
        return healthBar;
    }

    public JLabel getOwnerName() {
        return ownerName;
    }

    public JLabel getCoinsAmount() {
        return coinsAmount;
    }

    public JLabel getOwnerAge() {
        return ownerAge;
    }

    public JLabel getFoodAmount() {
        return foodAmount;
    }

    public JLabel getWaterAmount() {
        return waterAmount;
    }

    public void createGameWindow(ChiefWindowController chiefWindowController) {
        gameFrame = new JFrame("Тамагочи");
        gameFrame.getContentPane().setBackground(Color.white);

        Font font = new Font(new JLabel("").getFont().getName(), Font.PLAIN, 14);

        JLabel ownerNameLabel = new JLabel("Имя игрока:");
        ownerNameLabel.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        ownerName = new JLabel("");
        JLabel coinsAmountLabel = new JLabel("Количество монет:");
        coinsAmountLabel.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        coinsAmount = new JLabel("");
        JLabel ownerAgeLabel = new JLabel("Пол игрока:");
        ownerAgeLabel.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        ownerAge = new JLabel("");
        JLabel foodAmountLabel = new JLabel("Количество еды:");
        foodAmountLabel.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        foodAmount = new JLabel("");
        JLabel waterAmountLabel = new JLabel("Количество напитков:");
        waterAmountLabel.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        waterAmount = new JLabel("");

        JLabel petNameLabel = new JLabel("Имя питомца:");
        petNameLabel.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        petName = new JLabel("");
        JLabel petTypeLabel = new JLabel("Вид питомца:");
        petTypeLabel.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        petType = new JLabel("");
        JLabel petAgeLabel = new JLabel("Возраст питомца:");
        petAgeLabel.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        petAge = new JLabel("");

        JLabel petLabel = new JLabel("Питомец: ");
        petLabel.setFont(font.deriveFont(font.getStyle() | Font.BOLD));

        JPanel gameInfoPanel = new JPanel();
        gameInfoPanel.setBackground(Color.white);
        gameInfoPanel.setLayout(new BoxLayout(gameInfoPanel, BoxLayout.Y_AXIS));
        gameInfoPanel.setPreferredSize(new Dimension(250, 690));

        gameInfoPanel.setBorder(BorderFactory.createTitledBorder("ИГРОВЫЕ ДАННЫЕ"));
        gameInfoPanel.add(Box.createRigidArea(new Dimension(20, 10)));

        ownerNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        ownerAgeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        coinsAmountLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        ownerName.setAlignmentX(Component.LEFT_ALIGNMENT);
        ownerAge.setAlignmentX(Component.LEFT_ALIGNMENT);
        coinsAmount.setAlignmentX(Component.LEFT_ALIGNMENT);
        petNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        petAgeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        petTypeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        petName.setAlignmentX(Component.LEFT_ALIGNMENT);
        petAge.setAlignmentX(Component.LEFT_ALIGNMENT);
        petType.setAlignmentX(Component.LEFT_ALIGNMENT);
        petLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        BufferedImage bufferedPicture = null;
        try {
            switch (chiefWindowController.getTamagotchiModelController().getTamagotchiModel().getPetType()) {
                case "Ёж":
                    bufferedPicture = ImageIO.read(new File("resources/sonic_main.png"));
                    break;
                case "Заяц":
                    bufferedPicture = ImageIO.read(new File("resources/pinky_main.png"));
                    break;
                case "Лис":
                    bufferedPicture = ImageIO.read(new File("resources/puppy_main.png"));
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel petPicture = new JLabel(new ImageIcon(bufferedPicture));

        gameInfoPanel.add(ownerNameLabel);
        gameInfoPanel.add(ownerName);
        gameInfoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        gameInfoPanel.add(ownerAgeLabel);
        gameInfoPanel.add(ownerAge);
        gameInfoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        gameInfoPanel.add(coinsAmountLabel);
        gameInfoPanel.add(coinsAmount);
        gameInfoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        gameInfoPanel.add(foodAmountLabel);
        gameInfoPanel.add(foodAmount);
        gameInfoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        gameInfoPanel.add(waterAmountLabel);
        gameInfoPanel.add(waterAmount);
        gameInfoPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        gameInfoPanel.add(petNameLabel);
        gameInfoPanel.add(petName);
        gameInfoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        gameInfoPanel.add(petTypeLabel);
        gameInfoPanel.add(petType);
        gameInfoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        gameInfoPanel.add(petAgeLabel);
        gameInfoPanel.add(petAge);
        gameInfoPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        gameInfoPanel.add(petLabel);
        gameInfoPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        gameInfoPanel.add(petPicture);

        JButton playPetButton = new JButton("Играть с питомцем");
        playPetButton.addActionListener(e -> {
            chiefWindowController.startPlayPetWindow();
        });

        JButton visitDoctorButton = new JButton("Посетить ветеринара");
        visitDoctorButton.addActionListener(e -> {
            chiefWindowController.startVisitDoctorWindow();
        });

        JButton visitShopButton = new JButton("Сходить в магазин");
        visitShopButton.addActionListener(e -> {
            chiefWindowController.startVisitShopWindow();
        });

        JButton earnMoneyButton = new JButton("Заработать деньги");
        earnMoneyButton.addActionListener(e -> {
            chiefWindowController.startEarnMoneyWindow();
        });

        JButton walkPetButton = new JButton("Погулять с питомцем");
        walkPetButton.addActionListener(e -> {
            chiefWindowController.startWalkPetWindow();
        });

        JButton feedPetButton = new JButton("Покормить питомца");
        feedPetButton.addActionListener(e -> {
            chiefWindowController.startFeedPetWindow();
        });

        JButton sleepPetButton = new JButton("Уложить спать питомца");
        sleepPetButton.addActionListener(e -> {
            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setVivacityState(100);
            chiefWindowController.getTamagotchiModelController().getModelPropertyChange().firePropertyChange("VivacityStateProperty", 0, 1);
        });

        playPetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        visitDoctorButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        visitShopButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        earnMoneyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        walkPetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        feedPetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        sleepPetButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel gameActionsButtonsPanel = new JPanel();
        gameActionsButtonsPanel.setBackground(Color.white);
        gameActionsButtonsPanel.setLayout(new BoxLayout(gameActionsButtonsPanel, BoxLayout.Y_AXIS));
        gameActionsButtonsPanel.setPreferredSize(new Dimension(250, 690));
        gameActionsButtonsPanel.setBorder(BorderFactory.createTitledBorder("ИГРОВЫЕ ДЕЙСТВИЯ"));

        gameActionsButtonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        gameActionsButtonsPanel.add(playPetButton);
        gameActionsButtonsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        gameActionsButtonsPanel.add(visitDoctorButton);
        gameActionsButtonsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        gameActionsButtonsPanel.add(visitShopButton);
        gameActionsButtonsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        gameActionsButtonsPanel.add(earnMoneyButton);
        gameActionsButtonsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        gameActionsButtonsPanel.add(walkPetButton);
        gameActionsButtonsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        gameActionsButtonsPanel.add(feedPetButton);
        gameActionsButtonsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        gameActionsButtonsPanel.add(sleepPetButton);

        JLabel happinessLabel = new JLabel("Счастье питомца:");
        JLabel satietyLabel = new JLabel("Сытость питомца:");
        JLabel vivacityLabel = new JLabel("Бодрость питомца");
        JLabel healthLabel = new JLabel("Здоровье питомца");

        happinessLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        satietyLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        vivacityLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        healthLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        happinessBar = new JProgressBar();
        happinessBar.setMaximum(100);
        happinessBar.setMinimum(0);
        happinessBar.setValue(90);

        satietyBar = new JProgressBar();
        satietyBar.setMaximum(100);
        satietyBar.setMinimum(0);
        satietyBar.setValue(50);

        vivacityBar = new JProgressBar();
        vivacityBar.setMaximum(100);
        vivacityBar.setMinimum(0);
        vivacityBar.setValue(20);

        healthBar = new JProgressBar();
        healthBar.setMaximum(100);
        healthBar.setMinimum(0);
        healthBar.setValue(20);

        JPanel petStatePanel = new JPanel();
        petStatePanel.setBackground(Color.white);
        petStatePanel.setLayout(new BoxLayout(petStatePanel, BoxLayout.Y_AXIS));
        petStatePanel.setPreferredSize(new Dimension(250, 690));
        petStatePanel.setBorder(BorderFactory.createTitledBorder("СОСТОЯНИЕ ПИТОМЦА"));

        petStatePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        petStatePanel.add(happinessLabel);
        petStatePanel.add(happinessBar);
        petStatePanel.add(Box.createRigidArea(new Dimension(0, 20)));
        petStatePanel.add(satietyLabel);
        petStatePanel.add(satietyBar);
        petStatePanel.add(Box.createRigidArea(new Dimension(0, 20)));
        petStatePanel.add(vivacityLabel);
        petStatePanel.add(vivacityBar);
        petStatePanel.add(Box.createRigidArea(new Dimension(0, 20)));
        petStatePanel.add(healthLabel);
        petStatePanel.add(healthBar);

        gameFrame.setLayout(new FlowLayout());
        gameFrame.setSize(780, 730);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameFrame.add(gameInfoPanel);
        gameFrame.add(gameActionsButtonsPanel);
        gameFrame.add(petStatePanel);
        gameFrame.setIconImage(new ImageIcon("resources/icon.png").getImage());
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }

    public JLabel getPetName() {
        return petName;
    }

    public JLabel getPetType() {
        return petType;
    }

    public JLabel getPetAge() {
        return petAge;
    }

}

