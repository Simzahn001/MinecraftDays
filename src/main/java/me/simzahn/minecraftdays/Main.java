package me.simzahn.minecraftdays;

import me.simzahn.minecraftdays.bossbar.BasicBossbar;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main plugin;
    private BasicBossbar bar;

    @Override
    public void onEnable() {
        plugin = this;

        bar = new BasicBossbar();
        bar.start();
    }

    @Override
    public void onDisable() {
        bar.stop();
    }

    public static Main getPlugin(){
        return plugin;
    }

}
