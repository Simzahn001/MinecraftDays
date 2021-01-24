package me.simzahn.minecraftdays.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

public enum TeamColor {

    RED(new Location(Bukkit.getWorld("world"), 1.5, 75, 1.5), "Simzahn", "Bonzida"),
    GREEN(new Location(Bukkit.getWorld("world"), -0.5, 75, -0.5),"", ""),
    BLUE(new Location(Bukkit.getWorld("world"), -0.5, 75, 1.5),"al3Ts","Tailotheke"),
    YELLOW(new Location(Bukkit.getWorld("world"), 1.5, 75, -0.5),"","");



    TeamColor(Location spawn, String player1, String player2) {
        this.spawn = spawn;
        this.player1 = player1;
        this.player2 = player2;
    }

    private Location spawn;
    private String player1;
    private String player2;

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
