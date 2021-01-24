package me.simzahn.minecraftdays.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class Worldutil {

    private static Location[] spawnBarriers = {new Location(Bukkit.getWorld("world"), 7, 72, 3),
            new Location(Bukkit.getWorld("world"), 7, 72, 4 ),
            new Location(Bukkit.getWorld("world"), 6, 72, 5 ),
            new Location(Bukkit.getWorld("world"), 5, 72,6 ),
            new Location(Bukkit.getWorld("world"), 4, 72,7 ),
            new Location(Bukkit.getWorld("world"), 3, 72,7 ),
            new Location(Bukkit.getWorld("world"),-3, 72,7 ),
            new Location(Bukkit.getWorld("world"), -4, 72,7 ),
            new Location(Bukkit.getWorld("world"), -5, 72,6 ),
            new Location(Bukkit.getWorld("world"),-6 , 72,5 ),
            new Location(Bukkit.getWorld("world"),-7 , 72, 4),
            new Location(Bukkit.getWorld("world"),-3, 72,-7 ),
            new Location(Bukkit.getWorld("world"), -4, 72,-7 ),
            new Location(Bukkit.getWorld("world"), -5, 72,-6 ),
            new Location(Bukkit.getWorld("world"),-6 , 72,-5 ),
            new Location(Bukkit.getWorld("world"),-7 , 72, -4),
            new Location(Bukkit.getWorld("world"), 7, 72, -4 ),
            new Location(Bukkit.getWorld("world"), 6, 72, -5 ),
            new Location(Bukkit.getWorld("world"), 5, 72,-6 ),
            new Location(Bukkit.getWorld("world"), 4, 72,-7 ),
            new Location(Bukkit.getWorld("world"), 3, 72,-7 ),
            new Location(Bukkit.getWorld("world"),-7 , 72, 3),
            new Location(Bukkit.getWorld("world"),-7 , 72, -3),
            new Location(Bukkit.getWorld("world"),7 , 72, -3),};

    public static void setSpawnBarrier(boolean active) {
        if(active) {
            for(Location currentLocation : spawnBarriers) {
                currentLocation.getBlock().setType(Material.BARRIER);
            }
        }else {
            for (Location currentLocation : spawnBarriers) {
                currentLocation.getBlock().setType(Material.SMOOTH_QUARTZ);
            }
        }
    }
}
