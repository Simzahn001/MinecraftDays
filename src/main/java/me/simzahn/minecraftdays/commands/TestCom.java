package me.simzahn.minecraftdays.commands;

import me.simzahn.minecraftdays.util.Worldutil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCom implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 0) {
                Worldutil.setSpawnBarrier(true);
            }else {
                Worldutil.setSpawnBarrier(false);
            }

        }

        return false;
    }
}
