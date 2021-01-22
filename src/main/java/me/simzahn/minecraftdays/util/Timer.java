package me.simzahn.minecraftdays.util;

import me.simzahn.minecraftdays.Main;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {

    private int seconds = 0;

    public void start() {

        seconds = 60;

        new BukkitRunnable() {

            @Override
            public void run() {
                switch (seconds) {

                }
            }
        }.runTaskTimer(Main.getPlugin(), 20,20);

    }

}
