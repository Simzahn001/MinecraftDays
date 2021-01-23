package me.simzahn.minecraftdays.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public enum TeamColor {

    RED(new Location(Bukkit.getWorld("world"), 1.5, 75, 1.5)),
    GREEN(new Location(Bukkit.getWorld("world"), -0.5, 75, -0.5)),
    BLUE(new Location(Bukkit.getWorld("world"), -0.5, 75, 1.5)),
    YELLOW(new Location(Bukkit.getWorld("world"), 1.5, 75, -0.5));



    TeamColor(Location spawn) {
        this.spawn = spawn;
    }

    private Location spawn;

    public Location getSpawn() {
        return spawn;
    }
}
