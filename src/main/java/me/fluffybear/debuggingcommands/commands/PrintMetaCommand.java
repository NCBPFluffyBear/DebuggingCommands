package me.fluffybear.debuggingcommands.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PrintMetaCommand implements CommandExecutor {

    private final Plugin plugin;

    public PrintMetaCommand(Plugin plugin) {
        this.plugin = plugin; // Store the plugin in situations where you need it.
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (p.getInventory().getItemInMainHand().getType() != Material.AIR) {

                p.sendMessage("Printing item meta");
                p.sendMessage(String.valueOf(p.getInventory().getItemInMainHand().getItemMeta()));
                return true;

            } else {
                p.sendMessage("You need to be holding an item in your main hand.");
                return true;
            }
        }
        return false;
    }
}
