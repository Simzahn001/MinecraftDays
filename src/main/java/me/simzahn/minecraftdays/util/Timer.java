package me.simzahn.minecraftdays.util;

import me.simzahn.minecraftdays.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Barrel;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class Timer {

    private int seconds = 0;
    private boolean isRunning = false;

    public void startWithCountdown() {

        if(isRunning) return;

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
                            isRunning = false;
                            startWithoutCountdown();
                            this.cancel();
                        }


                }

                seconds--;
            }
        }.runTaskTimer(Main.getPlugin(), 20,20);

    }

    public void startWithoutCountdown() {

        if (isRunning) return;

        seconds = 30; //60*60 sec --> an hour

        new BukkitRunnable() {
            @Override
            public void run() {

                if(seconds <= 0) {

                    for(Player player : Bukkit.getOnlinePlayers()) {
                        player.sendTitle("§6§lDie Ergebnisse:", "", 10, 100, 10);
                        player.sendActionBar(ChatColor.RED + "§lDie Zeit ist vorbei!");
                    }

                    switch(Main.getChallange()) {
                        case EMERALD_RACE:
                            for(TeamColor currentColor : TeamColor.values()) {
                                if(Bukkit.getWorld("world").getBlockAt(currentColor.getBarrel()).getState() instanceof Barrel) {
                                    Inventory inv =((Barrel) Bukkit.getWorld("world").getBlockAt(currentColor.getBarrel()).getState()).getInventory();
                                    ((Barrel) Bukkit.getWorld("world").getBlockAt(currentColor.getBarrel()).getState()).getInventory().clear();
                                    for(ItemStack currentItem : inv.getContents()) {
                                        if(currentItem != null) {
                                            if(currentItem.getType() == Material.EMERALD) {
                                                Main.getPoints().put(currentColor, Main.getPoints().get(currentColor) + currentItem.getAmount());
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        case ORE_RACE:
                            for(TeamColor currentColor : TeamColor.values()) {
                                if(Bukkit.getWorld("world").getBlockAt(currentColor.getBarrel()).getState() instanceof Barrel) {
                                    Inventory inv =((Barrel) Bukkit.getWorld("world").getBlockAt(currentColor.getBarrel()).getState()).getInventory();
                                    for(ItemStack currentItem : inv.getContents()) {
                                        if(currentItem != null) {
                                            switch(currentItem.getType()) {
                                                case COAL:
                                                case REDSTONE:
                                                    Main.getPoints().put(currentColor, Main.getPoints().get(currentColor) + currentItem.getAmount());
                                                    break;
                                                case QUARTZ:
                                                    Main.getPoints().put(currentColor, Main.getPoints().get(currentColor) + (currentItem.getAmount()*2));
                                                    break;
                                                case GOLD_INGOT:
                                                case IRON_INGOT:
                                                    Main.getPoints().put(currentColor, Main.getPoints().get(currentColor) + (currentItem.getAmount()*4));
                                                    break;
                                                case LAPIS_LAZULI:
                                                    Main.getPoints().put(currentColor, Main.getPoints().get(currentColor) + (currentItem.getAmount()*8));
                                                    break;
                                                case DIAMOND:
                                                    Main.getPoints().put(currentColor, Main.getPoints().get(currentColor) + (currentItem.getAmount()*64));
                                                    break;
                                                case NETHERITE_INGOT:
                                                    Main.getPoints().put(currentColor, Main.getPoints().get(currentColor) + (currentItem.getAmount()*256));
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                    }

                    new BukkitRunnable() {
                        HashMap<TeamColor, Integer> points = Main.getPoints();
                        @Override
                        public void run() {
                            for(Player player : Bukkit.getOnlinePlayers()) {
                                player.sendTitle("§6§lDie Ergebnisse:", ChatColor.GREEN + points.get(TeamColor.GREEN).toString() + " §r| " + ChatColor.RED + points.get(TeamColor.RED).toString() + " §r| " + ChatColor.YELLOW + points.get(TeamColor.YELLOW).toString() + " §r| " + ChatColor.BLUE + points.get(TeamColor.BLUE).toString(), 0, 200, 40);
                            }
                        }
                    }.runTaskLater(Main.getPlugin(), 60);


                        Main.setChallange(Challenge.NONE);
                        for(TeamColor currentColor : TeamColor.values()) {
                            if(Bukkit.getWorld("world").getBlockAt(currentColor.getBarrel()).getState() instanceof Barrel) {
                                ((Barrel) Bukkit.getWorld("world").getBlockAt(currentColor.getBarrel()).getState()).getInventory().clear();
                            }
                        }
                        TeamColor.spawnTeleport();
                        this.cancel();

                }else {
                    for (Player currentPlayer : Bukkit.getOnlinePlayers()) {
                        currentPlayer.sendActionBar("§6§l" + seconds/60 + ":" + seconds % 60);
                    }
                }
                seconds--;
            }
        }.runTaskTimer(Main.getPlugin(), 20, 20);

    }
}
