package me.fluffybear.debuggingcommands.commands;


import me.fluffybear.debuggingcommands.Utils;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.RayTraceResult;

public class FindItemCommand implements CommandExecutor {

    private final Plugin plugin;

    public FindItemCommand(Plugin plugin) {
        this.plugin = plugin; // Store the plugin in situations where you need it.
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (args.length == 0) {
            Utils.send(sender, "&cUsage: /finditem hand|name <name>");
            return true;

        } else {
            if (args[0].equalsIgnoreCase("hand")) {
                if (p == null) {
                    Utils.send(sender, "&c/finditem hand can only be executed in game");
                    return true;
                } else {
                    ItemStack item = p.getInventory().getItemInMainHand();
                    Bukkit.getOnlinePlayers().forEach(pl -> {
                        if (pl.getInventory().containsAtLeast(item, 1)) {
                            Utils.send(sender, "&aFound player: " + pl.getName());
                        }
                    });
                }
            } else if (args[0].equalsIgnoreCase("name")) {

                if (args.length != 2) {
                    Utils.send(sender, "&cUsage: /finditem name <name>");
                    return true;
                }
                String name = args[1].replace("+SPACE", " ");
                Bukkit.getOnlinePlayers().forEach(pl -> pl.getInventory().forEach(plItem -> {
                    if (plItem != null && plItem.getType() != Material.AIR && plItem.getItemMeta().hasDisplayName()
                        && ChatColor.stripColor(plItem.getItemMeta().getDisplayName()).equalsIgnoreCase(name)) {
                        Utils.send(sender, "&aFound player: " + pl.getName());
                    }
                }));
            } else {
                Utils.send(sender, "&cUsage: /finditem hand|name <name>");
                return true;
            }
            return true;
        }
    }
}

