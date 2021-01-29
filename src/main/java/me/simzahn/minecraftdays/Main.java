package me.simzahn.minecraftdays;

import me.simzahn.minecraftdays.bossbar.BasicBossbar;
import me.simzahn.minecraftdays.commands.ChallengesCom;
import me.simzahn.minecraftdays.commands.TestCom;
import me.simzahn.minecraftdays.listeners.AchievementListener;
import me.simzahn.minecraftdays.listeners.BlockBreakListener;
import me.simzahn.minecraftdays.listeners.ChunkLoadListener;
import me.simzahn.minecraftdays.listeners.JoinListener;
import me.simzahn.minecraftdays.util.Challange;
import me.simzahn.minecraftdays.util.TeamColor;
import me.simzahn.minecraftdays.util.Timer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Main extends JavaPlugin {

    private static Main plugin;
    private BasicBossbar bar;
    private static Timer timer;
    private static Challange challange = Challange.NONE;
    private static HashMap<TeamColor, Integer> points;

    @Override
    public void onEnable() {
        plugin = this;

        points = new HashMap<>();
        resetPoints();

        timer = new Timer();
        bar = new BasicBossbar();
        bar.start();

        getCommand("test").setExecutor(new TestCom());
        getCommand("challenge").setExecutor(new ChallengesCom());

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ChunkLoadListener(), this);
        pluginManager.registerEvents(new AchievementListener(), this);
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new BlockBreakListener(), this);
    }

    @Override
    public void onDisable() {
        bar.stop();
    }

    public static Main getPlugin(){
        return plugin;
    }

    public static Timer getTimer() {
        return timer;
    }

    public static Challange getChallange() {
        return challange;
    }

    public static void setChallange(Challange challange) {
        Main.challange = challange;
    }

    public static HashMap<TeamColor, Integer> getPoints() {
        return points;
    }

    public static void resetPoints() {
        for(TeamColor currentColor : TeamColor.values()) {
            points.put(currentColor, 0);
        }
    }
}
