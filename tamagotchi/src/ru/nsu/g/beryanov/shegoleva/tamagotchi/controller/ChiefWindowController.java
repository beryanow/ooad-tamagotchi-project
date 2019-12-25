package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.updaters.*;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.*;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class ChiefWindowController {
    private ArrayList<AbstractUpdater> updatersList;
    private AbstractWindowController createPetWindowController;
    private AbstractWindowController earnMoneyWindowController;
    private AbstractWindowController enterOwnerWindowController;
    private AbstractWindowController feedPetWindowController;
    private AbstractWindowController gameWindowController;
    private AbstractWindowController playPetWindowController;
    private AbstractWindowController visitDoctorWindowController;
    private AbstractWindowController visitShopWindowController;
    private AbstractWindowController walkPetWindowController;
    private AbstractWindowController welcomeWindowController;
    private GamePropertyController gamePropertyController;
    private TamagotchiModelController tamagotchiModelController;

    public ChiefWindowController(TamagotchiModelController tamagotchiModelController) {
        createPetWindowController = new CreatePetWindowController();
        earnMoneyWindowController = new EarnMoneyWindowController();
        enterOwnerWindowController = new EnterOwnerWindowController();
        feedPetWindowController = new FeedPetWindowController();
        gameWindowController = new GameWindowController();
        playPetWindowController = new PlayPetWindowController();
        visitDoctorWindowController = new VisitDoctorWindowController();
        visitShopWindowController = new VisitShopWindowController();
        walkPetWindowController = new WalkPetWindowController();
        welcomeWindowController = new WelcomeWindowController();
        gamePropertyController = new GamePropertyController(this);
        this.tamagotchiModelController = tamagotchiModelController;
        updatersList = new ArrayList<>();
    }

    private void boundProperty(TamagotchiModelController tamagotchiModelController) {
        PropertyChangeSupport modelPropertyChange = new PropertyChangeSupport(this);
        modelPropertyChange.addPropertyChangeListener(gamePropertyController);
        tamagotchiModelController.setModelPropertyChange(modelPropertyChange);
        modelPropertyChange.firePropertyChange("OwnerProperty", 0, 1);
        modelPropertyChange.firePropertyChange("PetProperty", 0, 1);

        AbstractUpdater happinessStateInfoUpdater = new HappinessStateInfoUpdater(modelPropertyChange, this);
        AbstractUpdater healthStateInfoUpdater = new HealthStateInfoUpdater(modelPropertyChange, this);
        AbstractUpdater vivacityStateInfoUpdater = new VivacityStateInfoUpdater(modelPropertyChange, this);
        AbstractUpdater satietyStateInfoUpdater = new SatietyStateInfoUpdater(modelPropertyChange, this);

        Timer happinessStateInfoTimer = new Timer();
        Timer satietyStateInfoTimer = new Timer();
        Timer healthStateInfoTimer = new Timer();
        Timer vivacityStateInfoTimer = new Timer();

        happinessStateInfoTimer.scheduleAtFixedRate(new HappinessStateInfoUpdater(tamagotchiModelController.getModelPropertyChange(), this), 0, 1000);
        satietyStateInfoTimer.scheduleAtFixedRate(new SatietyStateInfoUpdater(tamagotchiModelController.getModelPropertyChange(), this), 0, 500);
        vivacityStateInfoTimer.scheduleAtFixedRate(new VivacityStateInfoUpdater(tamagotchiModelController.getModelPropertyChange(), this), 0, 3000);
        healthStateInfoTimer.scheduleAtFixedRate(new HealthStateInfoUpdater(tamagotchiModelController.getModelPropertyChange(), this), 0, 1000);

        updatersList.add(happinessStateInfoUpdater);
        updatersList.add(healthStateInfoUpdater);
        updatersList.add(vivacityStateInfoUpdater);
        updatersList.add(satietyStateInfoUpdater);
    }

    public TamagotchiModelController getTamagotchiModelController() {
        return tamagotchiModelController;
    }

    public VisitDoctorWindowView getVisitDoctorWindow() {
        return (VisitDoctorWindowView) visitDoctorWindowController.getWindow();
    }

    public WelcomeWindowView getWelcomeWindow() {
        return (WelcomeWindowView) welcomeWindowController.getWindow();
    }

    public WalkPetWindowView getWalkPetWindow() {
        return (WalkPetWindowView) walkPetWindowController.getWindow();
    }

    public VisitShopWindowView getVisitShopWindow() {
        return (VisitShopWindowView) visitShopWindowController.getWindow();
    }

    GameWindowView getGameWindow() {
        return (GameWindowView) gameWindowController.getWindow();
    }

    public void startWelcomeWindow() {
        ((WelcomeWindowView) welcomeWindowController.getWindow()).createWelcomeWindow(this);
    }

    public void startWalkPetWindow() {
        ((WalkPetWindowView) walkPetWindowController.getWindow()).createWalkPetWindow(this);
    }

    public EnterOwnerWindowView getEnterOwnerWindow() {
        return (EnterOwnerWindowView) enterOwnerWindowController.getWindow();
    }

    public void startVisitShopWindow() {
        ((VisitShopWindowView) visitShopWindowController.getWindow()).createVisitShopWindow(this);
    }

    public void startVisitDoctorWindow() {
        ((VisitDoctorWindowView) visitDoctorWindowController.getWindow()).createVisitDoctorWindow(this);
    }

    public void startPlayPetWindow() {
        ((PlayPetWindowView) playPetWindowController.getWindow()).createPlayPetWindow(this);
    }

    public PlayPetWindowView getPlayPetWindow() {
        return (PlayPetWindowView) playPetWindowController.getWindow();
    }

    public FeedPetWindowView getFeedPetWindow() {
        return (FeedPetWindowView) feedPetWindowController.getWindow();
    }

    public void startGameWindow() {
        ((GameWindowView) gameWindowController.getWindow()).createGameWindow(this);
        boundProperty(tamagotchiModelController);
    }

    public EarnMoneyWindowView getEarnMoneyWindow() {
        return (EarnMoneyWindowView) earnMoneyWindowController.getWindow();
    }

    public CreatePetWindowView getCrearePetWindow() {
        return (CreatePetWindowView) createPetWindowController.getWindow();
    }

    public void startFeedPetWindow() {
        ((FeedPetWindowView) feedPetWindowController.getWindow()).createWalkPetWindow(this);
    }

    public void startEnterOwnerWindow() {
        ((EnterOwnerWindowView) enterOwnerWindowController.getWindow()).createEnterOwnerWindow(this);
    }

    public void startEarnMoneyWindow() {
        ((EarnMoneyWindowView) earnMoneyWindowController.getWindow()).createEarnMoneyWindow(this);
    }

    public void startCreatePetWindow() {
        ((CreatePetWindowView) createPetWindowController.getWindow()).createSelectPetWindow(this);
    }
}
