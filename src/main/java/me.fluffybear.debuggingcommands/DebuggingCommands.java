package me.fluffybear.debuggingcommands;

import me.fluffybear.debuggingcommands.commands.APIExecuteCommand;
import me.fluffybear.debuggingcommands.commands.EnchantFinderCommand;
import me.fluffybear.debuggingcommands.commands.PrintMetaCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class DebuggingCommands extends JavaPlugin {

    @Override
    public void onEnable() {

        this.getCommand("finder").setExecutor(new EnchantFinderCommand(this));
        this.getCommand("meta").setExecutor(new PrintMetaCommand(this));
        this.getCommand("APIExecute").setExecutor(new APIExecuteCommand(this));

        getLogger().info("Debugging Commands has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Debugging Commands has been disabled");
    }
}
