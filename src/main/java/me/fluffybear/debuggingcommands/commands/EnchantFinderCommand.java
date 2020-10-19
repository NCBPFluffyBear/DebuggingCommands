package me.fluffybear.debuggingcommands.commands;

import me.fluffybear.debuggingcommands.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.Plugin;

public class EnchantFinderCommand implements CommandExecutor {

    private final Plugin plugin;

    public EnchantFinderCommand(Plugin plugin) {
        this.plugin = plugin; // Store the plugin in situations where you need it.
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Utils.send(sender, "&7" + ((Enchantment.values()).length + " different enchantments found and pasted into " +
            "console."));
        byte b;
        int i;
        Enchantment[] arrayOfEnchantment;
        for (i = (arrayOfEnchantment = Enchantment.values()).length, b = 0; b < i; ) {
            Enchantment en = arrayOfEnchantment[b];
            if (args.length == 0 || en.getKey().toString().contains(args[0])) {
                System.out.println(en.getKey().toString());
                System.out.println("  Max Level: " + en.getMaxLevel());
                System.out.println("  Item Target: " + en.getItemTarget().toString());
            }
            b++;
        }
        return true;
    }
}

