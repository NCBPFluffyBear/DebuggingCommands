package me.fluffybear.debuggingcommands;

import me.fluffybear.debuggingcommands.commands.CopyMetaCommand;
import me.fluffybear.debuggingcommands.commands.EnchantFinderCommand;
import me.fluffybear.debuggingcommands.commands.PasteMetaCommand;
import me.fluffybear.debuggingcommands.commands.PrintMetaCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class DebuggingCommands extends JavaPlugin {

    @Override
    public void onEnable() {

        this.getCommand("enchantfinder").setExecutor(new EnchantFinderCommand(this));
        this.getCommand("printmeta").setExecutor(new PrintMetaCommand(this));
        this.getCommand("copymeta").setExecutor(new CopyMetaCommand(this));
        this.getCommand("pastemeta").setExecutor(new PasteMetaCommand(this));

        getLogger().info("Debugging Commands has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Debugging Commands has been disabled");
    }
}
