package me.fluffybear.debuggingcommands.commands;


import me.fluffybear.debuggingcommands.Utils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class PasteMetaCommand implements CommandExecutor {

    private final Plugin plugin;

    public PasteMetaCommand(Plugin plugin) {
        this.plugin = plugin; // Store the plugin in situations where you need it.
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Utils.send(sender, "&7Only players may execute this command");

        } else {
            Player p = (Player) sender;

            if (Utils.copiedItemMeta.isEmpty()) {
                Utils.send(p, "&7Use /copymeta first to copy an item's ItemMeta");

            } else {
                ItemStack item = p.getInventory().getItemInMainHand();

                if (item.getType() == Material.AIR) {
                    Utils.send(p, "&7Please hold an item in your main hand");
                } else {
                    ItemMeta metaData = Utils.copiedItemMeta.get(p.getName());
                    item.setItemMeta(metaData);
                    Utils.send(p, "&7ItemMeta has been pasted.");
                }
            }
        }
        return true;
    }
}

