package me.simzahn.minecraftdays.util;

import me.simzahn.minecraftdays.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {

    private int seconds = 0;
    private boolean isRunning = false;

    public void startWithCountdown() {

        isRunning = true;
        seconds = 61;

        new BukkitRunnable() {

            @Override
            public void run() {
                switch (seconds) {
                    case 60:
                        for(Player currentPlayer : Bukkit.getOnlinePlayers()) {
                            currentPlayer.sendTitle("§6§lDie Challange beginnt in 60 Sekunden!", "§8Macht euch bereit!", 20, 60, 20);
                        }
                        break;
                    case 30:
                    case 15:
                    case 10:
                        for(Player currentPlayer : Bukkit.getOnlinePlayers()) {
                            currentPlayer.sendTitle("§6§lNoch " + seconds + " Sekunden!", "", 20, 60 ,20);
                        }
                        break;

                    case 5:
                    case 4:
                    case 3:
                    case 2:
                    case 1:
                        for(Player currentPlayer : Bukkit.getOnlinePlayers()) {
                            currentPlayer.sendTitle("§6§l" + seconds, "", 5, 10, 5);
                        }
                        break;
                    case 0:
                        for(Player currentPlayer : Bukkit.getOnlinePlayers()) {
                            currentPlayer.sendTitle("§a§lEs geht los!","",  10, 60, 10);
                            startWithoutCountdown();
                            isRunning = false;
                            this.cancel();
                        }


                }

                seconds--;
            }
        }.runTaskTimer(Main.getPlugin(), 20,20);

    }

    public void startWithoutCountdown() {

    }
}
