package ru.nsu.g.beryanov.shegoleva.tamagotchi.controller;

import ru.nsu.g.beryanov.shegoleva.tamagotchi.model.TamagotchiModel;
import ru.nsu.g.beryanov.shegoleva.tamagotchi.view.*;

public class TamagotchiModelController {
    private TamagotchiModel tamagotchiModel;
    private CreatePetWindowView selectPetWindow;
    private WelcomeWindowView welcomeWindowView;
    private GameWindowView gameWindowView;
    private EnterOwnerWindowView enterOwnerWindow;
    private PlayPetWindowView playPetWindow;
    private VisitDoctorWindowView visitDoctorWindow;
    private VisitShopWindowView visitShopWindow;
    private EarnMoneyWindowView earnMoneyWindow;
    private WalkPetWindowView walkPetWindow;
    private FeedPetWindowView feedPetWindow;
    private ModelPropertyChange modelPropertyChange;

    public void setModelPropertyChange(ModelPropertyChange modelPropertyChange) {
        this.modelPropertyChange = modelPropertyChange;
    }

    ModelPropertyChange getModelPropertyChange() {
        return modelPropertyChange;
    }

    public TamagotchiModelController(WelcomeWindowView welcomeWindowView) {
        this.welcomeWindowView = welcomeWindowView;
        tamagotchiModel = new TamagotchiModel();
    }

    void setFeedPetWindow(FeedPetWindowView feedPetWindow) {
        this.feedPetWindow = feedPetWindow;
    }

    void setWalkPetWindow(WalkPetWindowView walkPetWindow) {
        this.walkPetWindow = walkPetWindow;
    }

    void setEarnMoneyWindow(EarnMoneyWindowView earnMoneyWindow) {
        this.earnMoneyWindow = earnMoneyWindow;
    }

    void setVisitShopWindow(VisitShopWindowView visitShopWindow) {
        this.visitShopWindow = visitShopWindow;
    }

    void setVisitDoctorWindow(VisitDoctorWindowView visitDoctorWindow) {
        this.visitDoctorWindow = visitDoctorWindow;
    }

    void setSelectPetWindow(CreatePetWindowView selectPetWindow) {
        this.selectPetWindow = selectPetWindow;
    }

    void setEnterOwnerWindow(EnterOwnerWindowView enterOwnerWindow) {
        this.enterOwnerWindow = enterOwnerWindow;
    }

    void setGameWindowView(GameWindowView gameWindowView) {
        this.gameWindowView = gameWindowView;
    }

    void setPlayPetWindow(PlayPetWindowView playPetWindow) {
        this.playPetWindow = playPetWindow;
    }

    public TamagotchiModel getTamagotchiModel() {
        return tamagotchiModel;
    }

    public WelcomeWindowView getWelcomeWindowView() {
        return welcomeWindowView;
    }
}
