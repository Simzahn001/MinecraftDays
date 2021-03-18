package me.simzahn.minecraftdays.listeners;

import me.simzahn.minecraftdays.Main;
import me.simzahn.minecraftdays.util.Challenge;
import me.simzahn.minecraftdays.util.TeamColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if(Main.getChallange().equals(Challenge.MASTERBREAKERS)) {
            if(TeamColor.getTeam(event.getPlayer()) != null) {
                Main.getPoints().put(TeamColor.getTeam(event.getPlayer()), Main.getPoints().get(TeamColor.getTeam(event.getPlayer())) + 1);
            }
        }
    }
}
