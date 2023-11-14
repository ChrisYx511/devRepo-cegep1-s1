package dev.chrisyx511.cs1.romanNumerals;

public class Season {
    static double temperature;

    public static void displayTemp() {
        System.out.println(Season.temperature);
    }

    String seasonName;

    public void displaySeasonName() {
        System.out.println(seasonName);
    }

    public static void main(String[] args) {
        Season summer = new Season();
        summer.seasonName = "Summer";
        summer.displaySeasonName();

        Season.temperature = 20.5;
        Season.displayTemp();
    }
}
