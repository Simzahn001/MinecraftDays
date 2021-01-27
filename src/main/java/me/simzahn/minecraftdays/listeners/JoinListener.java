package me.simzahn.minecraftdays.listeners;

import me.simzahn.minecraftdays.util.TeamColor;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if(TeamColor.getTeam(event.getPlayer()) != null) {
            event.getPlayer().setGameMode(GameMode.SURVIVAL);
            event.getPlayer().teleport(TeamColor.getTeam(event.getPlayer()).getSpawn());
        }else  {
            event.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
    }

}
