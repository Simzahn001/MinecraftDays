package me.simzahn.minecraftdays.listeners;

import me.simzahn.minecraftdays.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ChunkLoadListener implements Listener {

    @EventHandler
    public void onPolulate(ChunkLoadEvent event) {

        if(event.getChunk().getX() == 0) {

            new BukkitRunnable() {
                @Override
                public void run() {
                    for(int i = 0; i<=15; i++) {
                        event.getWorld().getBlockAt(0, 200, event.getChunk().getZ()*16 + i).setType(Material.BARRIER, false);
                    }
                }
            }.runTaskLater(Main.getPlugin(), 10);

        }else if(event.getChunk().getZ() == 0) {

            new BukkitRunnable() {
                @Override
                public void run() {
                    for (int i = 0; i<=15; i++) {
                        event.getWorld().getBlockAt(event.getChunk().getX()*16 + i, 200,0).setType(Material.BARRIER, false);
                    }
                }
            }.runTaskLater(Main.getPlugin(), 10);

        }
    }
}
