package me.simzahn.minecraftdays.commands;

import me.simzahn.minecraftdays.util.Challange;
import me.simzahn.minecraftdays.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChallengesCom implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 1) {
                switch (Integer.parseInt(args[0])) {
                    case 1:
                        Main.setChallange(Challange.ACHIEVEMENT_RACE);
                        Main.getTimer().startWithCountdown();
                        Bukkit.broadcastMessage(ChatColor.BLUE + "------------------------------");
                        Bukkit.broadcastMessage("");
                        Bukkit.broadcastMessage("§8<<<" + ChatColor.GOLD + "§lAchievement Race" + ChatColor.DARK_GRAY +">>> ");
                        Bukkit.broadcastMessage("Sammelt in einer Stunde so viele Achievement wie ihr nur könnt!");
                        Bukkit.broadcastMessage("Achievements werden doppelt gezählt, wenn der 2. Spieler sie auch erreicht!");
                        Bukkit.broadcastMessage("Das Team mit den meisten Achievements gewinnt!");
                        Bukkit.broadcastMessage(ChatColor.RED + "Das obtainen von neuen Rezepten zählt hier auch dazu!!!");
                        Bukkit.broadcastMessage("");
                        Bukkit.broadcastMessage(ChatColor.BLUE + "------------------------------");
                }
            }else {
                player.sendMessage("§8Bitte Benutze /challenge <int>");
            }
        }
        return false;
    }
}
