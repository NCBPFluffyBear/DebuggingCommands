package me.fluffybear.debuggingcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static Map<String, ItemMeta> copiedItemMeta = new HashMap<>();

    public static void send(CommandSender s, String message) {
        s.sendMessage(ChatColor.GRAY + "[DebuggingCommands] " + ChatColor.translateAlternateColorCodes('&', message));
    }
}
