package me.simzahn.minecraftdays.commands;

import me.simzahn.minecraftdays.Main;
import me.simzahn.minecraftdays.util.TeamColor;
import org.bukkit.Bukkit;
import org.bukkit.block.Barrel;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TestCom implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;


            for(TeamColor currentColor : TeamColor.values()) {
                if(Bukkit.getWorld("world").getBlockAt(currentColor.getBarrel()).getState() instanceof Barrel) {
                    System.out.println("Barrel found");
                    Inventory inv =((Barrel) Bukkit.getWorld("world").getBlockAt(currentColor.getBarrel()).getState()).getInventory();
                    for(ItemStack currentItem : inv.getContents()) {
                        if(currentItem != null) {
                            System.out.println("notnull");
                            switch(currentItem.getType()) {
                                case COAL:
                                case REDSTONE:
                                    System.out.println("redstone/coal");
                                    Main.getPoints().put(currentColor, Main.getPoints().get(currentColor) + currentItem.getAmount());
                                    Main.getPoints().put(currentColor, Main.getPoints().get(currentColor) + currentItem.getAmount());
                                    break;
                                case QUARTZ:
                                    System.out.println("quartz");
                                    Main.getPoints().put(currentColor, Main.getPoints().get(currentColor) + (currentItem.getAmount()*2));
                                    break;
                                case GOLD_INGOT:
                                case IRON_INGOT:
                                    System.out.println("Gold iron");
                                    Main.getPoints().put(currentColor, Main.getPoints().get(currentColor) + (currentItem.getAmount()*4));
                                    break;
                                case LAPIS_LAZULI:
                                    Main.getPoints().put(currentColor, Main.getPoints().get(currentColor) + (currentItem.getAmount()*8));
                                    break;
                                case DIAMOND:
                                    System.out.println("Dia");
                                    Main.getPoints().put(currentColor, Main.getPoints().get(currentColor) + (currentItem.getAmount()*64));
                                    break;
                                case NETHERITE_INGOT:
                                    System.out.println("netherite");
                                    Main.getPoints().put(currentColor, Main.getPoints().get(currentColor) + (currentItem.getAmount()*256));
                                    break;
                            }
                        }
                    }
                }
            }


        }
        return false;
    }
}
