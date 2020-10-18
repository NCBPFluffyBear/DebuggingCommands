package me.fluffybear.debuggingcommands.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class APIExecuteCommand implements CommandExecutor {

    private final Plugin plugin;

    public APIExecuteCommand(Plugin plugin) {
        this.plugin = plugin; // Store the plugin in situations where you need it.
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length != 1) {
                p.sendMessage("You need to have one argument");
            } else {
                p.sendMessage(args[0]);
            }
        } else if (sender instanceof ConsoleCommandSender){
            if (args.length != 1) {
                System.out.println("You need to have one argument");
            } else {
                System.out.println(args[0]);
            }
        }
        return false;
    }
}
