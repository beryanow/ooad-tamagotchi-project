package ru.nsu.g.beryanov.shegoleva.tamagotchi.model;

public class Owner {
    private String name;
    private String gender;
    private int coins;

    public Owner(String name, String gender, int coins) {
        this.name = name;
        this.gender = gender;
        this.coins = coins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
