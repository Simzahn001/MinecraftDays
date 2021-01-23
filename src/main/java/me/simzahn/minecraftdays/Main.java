package me.simzahn.minecraftdays;

import me.simzahn.minecraftdays.bossbar.BasicBossbar;
import me.simzahn.minecraftdays.commands.TestCom;
import me.simzahn.minecraftdays.listeners.ChunkLoadListener;
import me.simzahn.minecraftdays.util.Team;
import me.simzahn.minecraftdays.util.TeamColor;
import me.simzahn.minecraftdays.util.Timer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main plugin;
    private BasicBossbar bar;
    private static Timer timer;

    private static Team greenTeam = new Team(TeamColor.GREEN, "", "");
    private static Team yellowTeam = new Team(TeamColor.YELLOW, "", "");
    private static Team blueTeam = new Team(TeamColor.BLUE, "", "");
    private static Team redTeam = new Team(TeamColor.RED, "Bonzida", "Simzahn");

    @Override
    public void onEnable() {
        plugin = this;

        timer = new Timer();
        bar = new BasicBossbar();
        bar.start();

        getCommand("test").setExecutor(new TestCom());

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

    public static Team getGreenTeam() {
        return greenTeam;
    }

    public static Team getYellowTeam() {
        return yellowTeam;
    }

    public static Team getBlueTeam() {
        return blueTeam;
    }

    public static Team getRedTeam() {
        return redTeam;
    }
}
