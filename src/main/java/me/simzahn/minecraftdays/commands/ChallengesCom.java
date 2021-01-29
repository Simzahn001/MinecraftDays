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
                Main.resetPoints();
                switch (Integer.parseInt(args[0])) {
                    case 1:
                        Main.setChallange(Challange.RECEPIE_RACE);
                        Main.getTimer().startWithCountdown();
                        Bukkit.broadcastMessage(ChatColor.BLUE + "------------------------------");
                        Bukkit.broadcastMessage("");
                        Bukkit.broadcastMessage("§8<<<" + ChatColor.GOLD + "§lRecepie Race" + ChatColor.DARK_GRAY +">>> ");
                        Bukkit.broadcastMessage("Sammelt in einer Stunde so viele Recepies wie ihr nur könnt!");
                        Bukkit.broadcastMessage("Recepies werden doppelt gezählt, wenn der 2. Spieler sie auch bekommt!");
                        Bukkit.broadcastMessage("Das Team mit den meisten Recepies gewinnt!");
                        Bukkit.broadcastMessage(ChatColor.RED + "Ihr könnt eure gesammelten Rezepte immer in eurem Buch nachschauen!!!");
                        Bukkit.broadcastMessage("");
                        Bukkit.broadcastMessage(ChatColor.BLUE + "------------------------------");
                        break;
                    case 2:
                        Main.setChallange(Challange.EMERALD_RACE);
                        Main.getTimer().startWithCountdown();
                        Bukkit.broadcastMessage(ChatColor.BLUE + "------------------------------");
                        Bukkit.broadcastMessage("");
                        Bukkit.broadcastMessage("§8<<<" + ChatColor.GOLD + "§lEmerald Race" + ChatColor.DARK_GRAY +">>> ");
                        Bukkit.broadcastMessage("Sammelt so viele Emeralds wie möglich und gebt sie am Spawn ab!");
                        Bukkit.broadcastMessage("Nur abgebebene Emeralds zählen");
                        Bukkit.broadcastMessage("Emeraldblöcke bitte im Emeralds umcraften, sonst zählen sie nicht!");
                        Bukkit.broadcastMessage(ChatColor.RED + "Ihr müsst die Emerald vor Ablauf der Zeit am Spawn abgeben, nicht erst nach dem Spawnteleport!'!!");
                        Bukkit.broadcastMessage("");
                        Bukkit.broadcastMessage(ChatColor.BLUE + "------------------------------");
                        break;
                    case 3:
                        Main.setChallange(Challange.ORE_RACE);
                        Main.getTimer().startWithCountdown();
                        Bukkit.broadcastMessage(ChatColor.BLUE + "------------------------------");
                        Bukkit.broadcastMessage("");
                        Bukkit.broadcastMessage("§8<<<" + ChatColor.GOLD + "§lOre Race" + ChatColor.DARK_GRAY +">>> ");
                        Bukkit.broadcastMessage("Sammelt in dieser Stunde mölichst viele Erze!");
                        Bukkit.broadcastMessage("Dabei bringen unterschiedliche Erze unterschiedlich viele Punkte:");
                        Bukkit.broadcastMessage( ChatColor.BLACK + "Kohle --> 1 Punkt");
                        Bukkit.broadcastMessage(ChatColor.RED + "Redstone --> 1 Punkt");
                        Bukkit.broadcastMessage("Quartz --> 2 Punkte");
                        Bukkit.broadcastMessage(ChatColor.GRAY + "Eisen --> 4 Punkte");
                        Bukkit.broadcastMessage(ChatColor.GOLD + "Gold --> 4 Punkte");
                        Bukkit.broadcastMessage(ChatColor.DARK_BLUE + "Lapislazuli --> 8 Punkte");
                        Bukkit.broadcastMessage(ChatColor.AQUA + "Dias --> 64 Punkte");
                        Bukkit.broadcastMessage(ChatColor.BLACK + "Netherite Ingot --> 265 Punkte");
                        Bukkit.broadcastMessage("Die Erze können nicht als Blökce abgegeben werden");
                        Bukkit.broadcastMessage("d. h. wenn das Fass voll ist passt nicht mehr rein ;^)");
                        Bukkit.broadcastMessage("");
                        Bukkit.broadcastMessage(ChatColor.BLUE + "------------------------------");
                    case 4:
                        Main.setChallange(Challange.MASTERBREAKERS);
                        Main.getTimer().startWithCountdown();
                        Bukkit.broadcastMessage(ChatColor.BLUE + "------------------------------");
                        Bukkit.broadcastMessage("");
                        Bukkit.broadcastMessage("§8<<<" + ChatColor.GOLD + "§lMasterbreakers" + ChatColor.DARK_GRAY +">>> ");
                        Bukkit.broadcastMessage("Bau so viele Blöcke wie mölich ab!");
                        Bukkit.broadcastMessage("TNT funktioniert nicht, es müssen alle Blöcke von Hand abgebaut werden");
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
