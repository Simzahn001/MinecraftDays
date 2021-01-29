package me.simzahn.minecraftdays.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

public enum TeamColor {

    RED(new Location(Bukkit.getWorld("world"), 1.5, 75, 1.5),new Location(Bukkit.getWorld("world"), 3, 74, 3), "Simzahn", "Bonzida"),
    GREEN(new Location(Bukkit.getWorld("world"), -0.5, 75, -0.5),new Location(Bukkit.getWorld("world"), -3, 74, -3),"", ""),
    BLUE(new Location(Bukkit.getWorld("world"), -0.5, 75, 1.5),new Location(Bukkit.getWorld("world"), -3, 74, 3),"al3Ts","Tailotheke"),
    YELLOW(new Location(Bukkit.getWorld("world"), 1.5, 75, -0.5),new Location(Bukkit.getWorld("world"), 3, 74, -3),"Time_Skip","Danyfighter");



    TeamColor(Location spawn,Location barrel, String player1, String player2) {
        this.spawn = spawn;
        this.barrel = barrel;
        this.player1 = player1;
        this.player2 = player2;
    }

    private Location spawn;
    private String player1;
    private String player2;
    private Location barrel;

    public Location getSpawn() {
        return spawn;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public static void spawnTeleport() {
        for(TeamColor currentColor : TeamColor.values()) {
            if(Bukkit.getPlayerExact(currentColor.getPlayer1()) != null) {
                Bukkit.getPlayerExact(currentColor.getPlayer1()).teleport(currentColor.getSpawn());
            }
            if(Bukkit.getPlayerExact(currentColor.getPlayer2())!= null) {
                Bukkit.getPlayerExact(currentColor.getPlayer2()).teleport(currentColor.getSpawn());
            }
        }
    }

    public Location getBarrel() {
        return barrel;
    }

    @Nullable
    public static TeamColor getTeam(Player player) {
        for(TeamColor currentColor : TeamColor.values()) {
            if(currentColor.player1.equals(player.getName())) {
                return currentColor;
            }else if(currentColor.player2.equals(player.getName())) {
                return currentColor;
            }
        }
        return null;
    }
}
