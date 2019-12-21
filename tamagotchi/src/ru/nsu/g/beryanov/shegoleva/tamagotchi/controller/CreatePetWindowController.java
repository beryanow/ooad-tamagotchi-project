package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.model.TamagotchiModel;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.CreatePetWindowView;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.WelcomeWindowView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CreatePetWindowController implements ActionListener, ItemListener {
    private WelcomeWindowView welcomeWindow;
    private CreatePetWindowView createPetWindow;
    private TamagotchiModel tamagotchiModel;

    public CreatePetWindowController(WelcomeWindowView welcomeWindow, CreatePetWindowView createPetWindow, TamagotchiModel tamagotchiModel) {
        this.welcomeWindow = welcomeWindow;
        this.createPetWindow = createPetWindow;
        this.tamagotchiModel = tamagotchiModel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "okaySelectPetButtonPressed":
                welcomeWindow.setNewPetFlag();
                if (welcomeWindow.getNewPetFlag() && welcomeWindow.getEnterOwner()) {
                    welcomeWindow.getStartGameButton().setEnabled(true);
                }

                String petName = createPetWindow.getPetName();
                String petType = createPetWindow.getPetType();
                int petAge = createPetWindow.getPetAge();

                tamagotchiModel.setPet(petName, petType, petAge);

                createPetWindow.getCreatePetFrame().setVisible(false);
                break;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String pet = (String) e.getItem();
        switch (pet) {
            case "Ёж":
                BufferedImage bufferedPicture = null;
                try {
                    bufferedPicture = ImageIO.read(new File("resources/sonic.png"));
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

                JLabel petLabel = createPetWindow.getPetLabel();
                petLabel.setIcon(new ImageIcon(bufferedPicture));
                createPetWindow.getPetNameInput().setText("Соник");
                createPetWindow.getPetAgeInput().setText("1");
                break;
            case "Заяц":
                bufferedPicture = null;
                try {
                    bufferedPicture = ImageIO.read(new File("resources/pinky.png"));
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

                petLabel = createPetWindow.getPetLabel();
                petLabel.setIcon(new ImageIcon(bufferedPicture));
                createPetWindow.getPetNameInput().setText("Пинки");
                createPetWindow.getPetAgeInput().setText("3");
                break;
            case "Лис":
                bufferedPicture = null;
                try {
                    bufferedPicture = ImageIO.read(new File("resources/puppy.png"));
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

                petLabel = createPetWindow.getPetLabel();
                petLabel.setIcon(new ImageIcon(bufferedPicture));
                createPetWindow.getPetNameInput().setText("Паппи");
                createPetWindow.getPetAgeInput().setText("4");
                break;
        }
    }
}
