package me.simzahn.minecraftdays.util;

public enum Challenge {

    NONE(0),
    RECEPIE_RACE(1),
    EMERALD_RACE(2),
    ORE_RACE(3),
    MASTERBREAKERS(4),
    MASTERBUILDERS(5),
    TRAVELLER(6),
    MOB_COLLECT(7),
    ITEM_RACE(8);

    Challenge(int number) {
        this.number = number;
    }

    private int number;

}
