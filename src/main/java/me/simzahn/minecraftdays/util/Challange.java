package me.simzahn.minecraftdays.util;

public enum Challange {

    NONE(0),
    ACHIEVEMENT_RACE(1),
    EMERALD_RACE(2),
    ORE_RABE(3),
    MASTERBREAKERS(4),
    MASTERBUILDERS(5),
    TRAVELLER(6),
    MOB_COLLECT(7),
    ITEM_RACE(8);

    Challange(int number) {
        this.number = number;
    }

    private int number;

}
