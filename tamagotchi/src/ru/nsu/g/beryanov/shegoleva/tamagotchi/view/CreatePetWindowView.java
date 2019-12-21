package ru.nsu.g.beryanov.shegoleva.tamagotchi.view;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.TamagotchiModelController;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.controller.CreatePetWindowController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CreatePetWindowView {
    private JLabel petName;
    private JLabel petType;
    private JLabel petAge;
    private JButton okaySelectPetButton;
    private JFrame createPetFrame;
    private JTextField petNameInput;
    private JComboBox comboPets;
    private JTextField petAgeInput;
    private JLabel petLabel;

    public JTextField getPetAgeInput() {
        return petAgeInput;
    }

    public JTextField getPetNameInput() {
        return petNameInput;
    }

    public JLabel getPetLabel() {
        return petLabel;
    }

    public JFrame getCreatePetFrame() {
        return createPetFrame;
    }

    public String getPetName() {
        return petNameInput.getText();
    }

    public String getPetType() {
        return (String) comboPets.getSelectedItem();
    }

    public int getPetAge() {
        try {
            return Integer.parseInt(petAgeInput.getText());
        } catch (Exception e) {
            return 1;
        }
    }

    private void createSelectPetWindow(TamagotchiModelController tamagotchiModelController) throws IOException {
        createPetFrame = new JFrame("Выбор питомца");
        createPetFrame.getContentPane().setBackground(Color.white);

        BufferedImage bufferedPicture = ImageIO.read(new File("resources/sonic.png"));
        petLabel = new JLabel(new ImageIcon(bufferedPicture));

        petName = new JLabel("Имя питомца:");
        petAge = new JLabel("Возраст питомца:");
        petType = new JLabel("Выберите питомца:");

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

        CreatePetWindowController createPetWindowController = new CreatePetWindowController(tamagotchiModelController.getWelcomeWindowView(), this, tamagotchiModelController.getTamagotchiModel());

        comboPets.addItemListener(createPetWindowController);
        okaySelectPetButton = new JButton("Ок");
        okaySelectPetButton.setActionCommand("okaySelectPetButtonPressed");
        okaySelectPetButton.addActionListener(createPetWindowController);

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
        createPetFrame.setLocationRelativeTo(tamagotchiModelController.getWelcomeWindowView().getWelcomeFrame());
        createPetFrame.setVisible(true);
    }

    public CreatePetWindowView(TamagotchiModelController tamagotchiModelController) throws IOException {
        createSelectPetWindow(tamagotchiModelController);
    }
}

