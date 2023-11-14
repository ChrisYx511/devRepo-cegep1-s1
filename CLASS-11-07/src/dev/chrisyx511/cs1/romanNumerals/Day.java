package dev.chrisyx511.cs1.romanNumerals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day {
    final static ArrayList<WeekDay> daysOfTheWeek = new ArrayList<>();

    public enum WeekDay {
        MONDAY, TUESDAY, WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
    }
    static {
        daysOfTheWeek.add(WeekDay.MONDAY);
        daysOfTheWeek.add(WeekDay.TUESDAY);
        daysOfTheWeek.add(WeekDay.WEDNESDAY);
        daysOfTheWeek.add(WeekDay.THURSDAY);
        daysOfTheWeek.add(WeekDay.FRIDAY);
        daysOfTheWeek.add(WeekDay.SATURDAY);
        daysOfTheWeek.add(WeekDay.SUNDAY);
    }

    public WeekDay currentDay;

    public int getCurrentDayID() {
        return Day.daysOfTheWeek.indexOf(currentDay);
    }

    public WeekDay getDayFromInterval(int interval, boolean removeDays) {
        int id = 0;
        if (!removeDays) {
                id = ((interval + getCurrentDayID()) % 7);
        } else {
            if (getCurrentDayID() - interval < 0) {
                id = (7 - (Math.abs(getCurrentDayID() - interval) % 7));
                System.out.println(id);
            } else {
                id = getCurrentDayID() - interval;
            }
        }
        if (id == 7) {
            id = 0;
        }
        return daysOfTheWeek.get(id);
    }
    public static void main(String[] args) {
        Day test = new Day();
        test.currentDay = WeekDay.MONDAY;
        System.out.println(test.getDayFromInterval(10000, false));

    }
}
