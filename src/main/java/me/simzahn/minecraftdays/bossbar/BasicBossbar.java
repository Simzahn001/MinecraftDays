package me.simzahn.minecraftdays.bossbar;

import me.simzahn.minecraftdays.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class BasicBossbar {

    private int taskID;
    private BossBar bar;
    private int barProgress = 30;
    private String[] titles = new String[]{"§6§lServer hosted by " + ChatColor.DARK_PURPLE + "§lvionity", "§6§lMinecraft Days" };
    private int textCounter = 1;

    public void start() {

        bar = Bukkit.createBossBar("", BarColor.GREEN, BarStyle.SOLID);
        bar.setVisible(true);
        System.out.println(bar.getProgress());

        new BukkitRunnable() {

            @Override
            public void run() {

                if(barProgress>= 30) {
                    bar.setTitle(titles[textCounter]);
                    textCounter = textCounter >= (titles.length-1) ? textCounter = 0 : textCounter+1;
                }

                bar.setProgress((double) barProgress / (double) 30);

                taskID = this.getTaskId();
                for(Player currentPlayer : Bukkit.getOnlinePlayers()) {
                    bar.addPlayer(currentPlayer);
                }
                if(barProgress <=0) {
                    barProgress = 30;
                }else barProgress--;
            }

        }.runTaskTimer(Main.getPlugin(), 20, 20);

    }

    public void stop() {
        Bukkit.getScheduler().cancelTask(taskID);
        bar.removeAll();
    }

    public int getTaskID() {
        return taskID;
    }
}
