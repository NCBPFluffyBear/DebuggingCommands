package me.fluffybear.debuggingcommands.commands;


import me.fluffybear.debuggingcommands.Utils;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.RayTraceResult;

public class BSAddInfoCommand implements CommandExecutor {

    private final Plugin plugin;

    public BSAddInfoCommand(Plugin plugin) {
        this.plugin = plugin; // Store the plugin in situations where you need it.
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Utils.send(sender, "&7Only players may execute this command");

        } else {
            Player p = (Player) sender;

            if (args.length != 2) {
                Utils.send(p, "&cPlease specify the key and the data");
                return true;

            } else {
                RayTraceResult rayResult = p.rayTraceBlocks(5d);
                if (rayResult != null && rayResult.getHitBlock() != null
                    && BlockStorage.hasBlockInfo(rayResult.getHitBlock())) {

                    BlockStorage.addBlockInfo(rayResult.getHitBlock(), args[0], args[1]);
                    Utils.send(p, "&aInfo has been added. (" + args[0] + ":\"" + args[1] + "\")");

                } else {
                    Utils.send(p, "&cYou must be looking at a Slimefun block");
                }
                return true;
            }
        }
        return true;
    }
}

