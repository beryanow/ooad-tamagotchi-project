package ru.nsu.g.beryanov.shegoleva.tamagotchi.view;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.TamagotchiModelController;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.VisitShopWindowController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VisitShopWindowView {
    private JFrame visitShopFrame;
    private JLabel petPicture;
    private JButton buyFoodButton;
    private JButton buyDrinkButton;
    private JButton returnHomeVisitShopButton;

    public JLabel getPetPicture() {
        return petPicture;
    }

    public JFrame getVisitShopFrame() {
        return visitShopFrame;
    }

    private void createVisitShopWindow(TamagotchiModelController tamagotchiModelController) {
        visitShopFrame = new JFrame("Поход в магазин");
        visitShopFrame.getContentPane().setBackground(Color.white);

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

        VisitShopWindowController visitShopWindowController = new VisitShopWindowController(this, tamagotchiModelController);

        buyFoodButton = new JButton("Купить еду");
        buyFoodButton.setActionCommand("buyFoodButtonPressed");
        buyFoodButton.addActionListener(visitShopWindowController);

        buyDrinkButton = new JButton("Купить напитки");
        buyDrinkButton.setActionCommand("buyDrinkButtonPressed");
        buyDrinkButton.addActionListener(visitShopWindowController);

        returnHomeVisitShopButton = new JButton("Вернуться домой");
        returnHomeVisitShopButton.setActionCommand("returnHomeVisitShopButtonPressed");
        returnHomeVisitShopButton.addActionListener(visitShopWindowController);

        buyFoodButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buyDrinkButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnHomeVisitShopButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.white);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

        buttonsPanel.add(buyFoodButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(buyDrinkButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(returnHomeVisitShopButton);

        visitShopFrame.setLayout(new FlowLayout());
        visitShopFrame.setSize(430, 260);

        visitShopFrame.add(petPicture);
        visitShopFrame.add(buttonsPanel);
        visitShopFrame.setIconImage(new ImageIcon("resources/icon.png").getImage());
        visitShopFrame.setLocationRelativeTo(tamagotchiModelController.getWelcomeWindowView().getWelcomeFrame());
        visitShopFrame.setVisible(true);
    }

    public VisitShopWindowView(TamagotchiModelController tamagotchiModelController) {
        createVisitShopWindow(tamagotchiModelController);
    }
}

