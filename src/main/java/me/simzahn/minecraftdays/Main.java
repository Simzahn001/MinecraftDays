package me.simzahn.minecraftdays;

import me.simzahn.minecraftdays.bossbar.BasicBossbar;
import me.simzahn.minecraftdays.listeners.ChunkLoadListener;
import me.simzahn.minecraftdays.util.Timer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main plugin;
    private BasicBossbar bar;
    private static Timer timer;

    @Override
    public void onEnable() {
        plugin = this;

        timer = new Timer();
        bar = new BasicBossbar();
        bar.start();

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ChunkLoadListener(), this);
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

}
