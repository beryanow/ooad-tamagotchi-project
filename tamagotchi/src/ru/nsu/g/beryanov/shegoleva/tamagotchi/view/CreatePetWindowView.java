package ru.nsu.g.beryanov.shegoleva.tamagotchi.view;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.ChiefWindowController;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.model.Animal;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CreatePetWindowView extends JFrame {
    private JFrame createPetFrame;
    private JTextField petNameInput;
    private JComboBox comboPets;
    private JTextField petAgeInput;
    private JLabel petLabel;

    private JTextField getPetAgeInput() {
        return petAgeInput;
    }

    private JTextField getPetNameInput() {
        return petNameInput;
    }

    private JLabel getPetLabel() {
        return petLabel;
    }

    private JFrame getCreatePetFrame() {
        return createPetFrame;
    }

    private String getPetName() {
        return petNameInput.getText();
    }

    public String getPetType() {
        return (String) comboPets.getSelectedItem();
    }

    private int getPetAge() {
        try {
            return Integer.parseInt(petAgeInput.getText());
        } catch (Exception e) {
            return 1;
        }
    }

    public void createSelectPetWindow(ChiefWindowController chiefWindowController) {
        createPetFrame = new JFrame("Выбор питомца");
        createPetFrame.getContentPane().setBackground(Color.white);

        BufferedImage bufferedPicture = null;
        try {
            bufferedPicture = ImageIO.read(new File("resources/sonic.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        petLabel = new JLabel(new ImageIcon(bufferedPicture));

        JLabel petName = new JLabel("Имя питомца:");
        JLabel petAge = new JLabel("Возраст питомца:");
        JLabel petType = new JLabel("Выберите питомца:");

        petNameInput = new JTextField("Соник");
        petNameInput.setHorizontalAlignment(SwingConstants.CENTER);
        petNameInput.setCaretColor(Color.white);
        petNameInput.setPreferredSize(new Dimension(200, 30));
        petNameInput.setEditable(false);

        petAgeInput = new JTextField("1");
        petAgeInput.setHorizontalAlignment(SwingConstants.CENTER);
        petAgeInput.setCaretColor(Color.white);
        petAgeInput.setPreferredSize(new Dimension(200, 30));
        petAgeInput.setEditable(false);

        String[] pets = new String[]{"Ёж", "Лис", "Заяц"};
        comboPets = new JComboBox(pets);
        comboPets.setSelectedIndex(0);
        comboPets.setPreferredSize(new Dimension(200, 30));
        comboPets.addItemListener(e -> {
            String pet = (String) e.getItem();
            switch (pet) {
                case "Ёж":
                    Animal animal = new Animal("Соник", "Ёж", 1);

                    BufferedImage bufferedPicture1 = null;
                    try {
                        bufferedPicture1 = ImageIO.read(new File("resources/sonic.png"));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }

                    JLabel petLabel = chiefWindowController.getCrearePetWindow().getPetLabel();

                    petLabel.setIcon(new ImageIcon(bufferedPicture1));
                    chiefWindowController.getCrearePetWindow().getPetNameInput().setText(animal.getName());
                    chiefWindowController.getCrearePetWindow().getPetAgeInput().setText(String.valueOf(animal.getAge()));
                    break;
                case "Заяц":
                    bufferedPicture1 = null;

                    animal = new Animal("Пинки", "Заяц", 3);
                    try {
                        bufferedPicture1 = ImageIO.read(new File("resources/pinky.png"));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }

                    petLabel = chiefWindowController.getCrearePetWindow().getPetLabel();
                    petLabel.setIcon(new ImageIcon(bufferedPicture1));
                    chiefWindowController.getCrearePetWindow().getPetNameInput().setText(animal.getName());
                    chiefWindowController.getCrearePetWindow().getPetAgeInput().setText(String.valueOf(animal.getAge()));
                    break;
                case "Лис":
                    bufferedPicture1 = null;
                    animal = new Animal("Паппи", "Лис", 4);

                    try {
                        bufferedPicture1 = ImageIO.read(new File("resources/puppy.png"));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }

                    petLabel = chiefWindowController.getCrearePetWindow().getPetLabel();
                    petLabel.setIcon(new ImageIcon(bufferedPicture1));
                    chiefWindowController.getCrearePetWindow().getPetNameInput().setText(animal.getName());
                    chiefWindowController.getCrearePetWindow().getPetAgeInput().setText(String.valueOf(animal.getAge()));
                    break;
            }
        });

        JButton okaySelectPetButton = new JButton("Ок");
        okaySelectPetButton.setActionCommand("okaySelectPetButtonPressed");
        okaySelectPetButton.addActionListener(e -> {
            chiefWindowController.getWelcomeWindow().setNewPetFlag();
            if (chiefWindowController.getWelcomeWindow().getNewPetFlag() && chiefWindowController.getWelcomeWindow().getEnterOwner()) {
                chiefWindowController.getWelcomeWindow().getStartGameButton().setEnabled(true);
            }

            String petName1 = chiefWindowController.getCrearePetWindow().getPetName();
            String petType1 = chiefWindowController.getCrearePetWindow().getPetType();
            int petAge1 = chiefWindowController.getCrearePetWindow().getPetAge();

            chiefWindowController.getTamagotchiModelController().getTamagotchiModel().setPet(petName1, petType1, petAge1);

            chiefWindowController.getCrearePetWindow().getCreatePetFrame().setVisible(false);
        });

        JPanel selectPetInputPanel = new JPanel();
        selectPetInputPanel.setBackground(Color.white);
        selectPetInputPanel.setLayout(new FlowLayout());
        selectPetInputPanel.setPreferredSize(new Dimension(200, 185));
        selectPetInputPanel.add(petName);
        selectPetInputPanel.add(petNameInput);
        selectPetInputPanel.add(petAge);
        selectPetInputPanel.add(petAgeInput);
        selectPetInputPanel.add(petType);
        selectPetInputPanel.add(comboPets);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.white);
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.add(okaySelectPetButton);

        createPetFrame.setLayout(new FlowLayout());
        createPetFrame.setSize(280, 550);

        createPetFrame.add(petLabel);
        createPetFrame.add(selectPetInputPanel);
        createPetFrame.add(buttonsPanel);
        createPetFrame.setIconImage(new ImageIcon("resources/icon.png").getImage());
        createPetFrame.setLocationRelativeTo(null);
        createPetFrame.setVisible(true);
    }
}

