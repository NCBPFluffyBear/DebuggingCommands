package me.fluffybear.debuggingcommands.commands;


import me.fluffybear.debuggingcommands.Utils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class CopyMetaCommand implements CommandExecutor {

    private final Plugin plugin;

    public CopyMetaCommand(Plugin plugin) {
        this.plugin = plugin; // Store the plugin in situations where you need it.
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Utils.send(sender, "&7Only players may execute this command");

        } else {
            Player p = (Player) sender;
            ItemStack item = p.getInventory().getItemInMainHand();

            if (item.getType() == Material.AIR) {
                Utils.send(p, "&7Please hold an item in your main hand");

            } else {
                ItemMeta meta = item.getItemMeta();
                Utils.copiedItemMeta.put(p.getName(), meta);
                Utils.send(p, "&7ItemMeta has been copied. Use /pastemeta to paste it.");
            }
        }
        return true;
    }
}

