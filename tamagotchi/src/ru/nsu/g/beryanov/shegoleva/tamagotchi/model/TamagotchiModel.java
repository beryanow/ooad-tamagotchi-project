package ru.nsu.g.beryanov.shegoleva.tamagotchi.model;

public class TamagotchiModel {
    private String petName;
    private String petType;
    private int petAge;

    private String ownerName;
    private int coinsAmount;
    private String ownerGender;
    private int foodAmount;
    private int drinkAmount;

    private int happinessState;
    private int satietyState;
    private int vivacityState;
    private int healthState;

    public TamagotchiModel() {
        happinessState = 100;
        satietyState = 100;
        vivacityState = 100;
        healthState = 100;
        foodAmount = 0;
        drinkAmount = 0;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public int getDrinkAmount() {
        return drinkAmount;
    }

    public void setDrinkAmount(int drinkAmount) {
        this.drinkAmount = drinkAmount;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public void setPet(String petName, String petType, int petAge) {
        this.petName = petName;
        this.petType = petType;
        this.petAge = petAge;
    }

    public void setOwner(String ownerName, int coinsAmount, String ownerGender) {
        this.ownerName = ownerName;
        this.coinsAmount = coinsAmount;
        this.ownerGender = ownerGender;
    }

    public String getPetName() {
        return petName;
    }

    public String getPetType() {
        return petType;
    }

    public int getPetAge() {
        return petAge;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public synchronized int getCoinsAmount() {
        return coinsAmount;
    }

    public String getOwnerGender() {
        return ownerGender;
    }

    public synchronized int getHappinessState() {
        return happinessState;
    }

    public synchronized int getSatietyState() {
        return satietyState;
    }

    public synchronized int getVivacityState() {
        return vivacityState;
    }

    public synchronized int getHealthState() {
        return healthState;
    }

    public synchronized void setHappinessState(int happinessState) {
        this.happinessState = happinessState;
    }

    public synchronized void setHealthState(int healthState) {
        this.healthState = healthState;
    }

    public synchronized void setVivacityState(int vivacityState) {
        this.vivacityState = vivacityState;
    }

    public synchronized void setSatietyState(int satietyState) {
        this.satietyState = satietyState;
    }

    public synchronized void setCoinsAmount(int coinsAmount) {
        this.coinsAmount = coinsAmount;
    }
}
