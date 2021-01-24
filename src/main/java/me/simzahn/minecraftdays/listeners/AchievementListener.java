package me.simzahn.minecraftdays.listeners;

import me.simzahn.minecraftdays.Main;
import me.simzahn.minecraftdays.util.Challange;
import me.simzahn.minecraftdays.util.TeamColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

public class AchievementListener implements Listener {

    @EventHandler
    public void onAchievementGet(PlayerAdvancementDoneEvent event) {

        if(Main.getChallange().equals(Challange.ACHIEVEMENT_RACE)) {
            if(TeamColor.getTeam(event.getPlayer()) != null) {
                Main.getPoints().put(TeamColor.getTeam(event.getPlayer()), Main.getPoints().get(TeamColor.getTeam(event.getPlayer())) + 1);
            }
        }

        System.out.println(Main.getPoints().get(TeamColor.getTeam(event.getPlayer())));

    }

}
