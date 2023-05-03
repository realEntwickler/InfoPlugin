package de.nilskoeb.infoplugin;

import de.nilskoeb.infoplugin.commands.EnchantCommand;
import de.nilskoeb.infoplugin.commands.FlyCommand;
import de.nilskoeb.infoplugin.commands.GameModeCommand;
import de.nilskoeb.infoplugin.commands.SchinkenCommand;
import de.nilskoeb.infoplugin.launcher.InfoPluginLauncher;
import de.nilskoeb.infoplugin.listener.PlayerJoinListener;
import de.nilskoeb.infoplugin.listener.PlayerQuitListener;
import de.nilskoeb.infoplugin.manager.BackpackManager;
import de.nilskoeb.infoplugin.manager.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;

public class InfoPlugin {

    private static InfoPlugin environment;

    private final InfoPluginLauncher infoPluginLauncher;
    private final ScoreboardManager scoreboardManager;
    private final BackpackManager backpackManager;


    public InfoPlugin (InfoPluginLauncher infoPluginLauncher) {
        environment = this;

        this.infoPluginLauncher = infoPluginLauncher;
        this.scoreboardManager = new ScoreboardManager();
        this.backpackManager = new BackpackManager();

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), infoPluginLauncher);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), infoPluginLauncher);

        infoPluginLauncher.getCommand("fly").setExecutor(new FlyCommand());
        infoPluginLauncher.getCommand("fly").setTabCompleter(new FlyCommand());

        infoPluginLauncher.getCommand("gamemode").setExecutor(new GameModeCommand());
        infoPluginLauncher.getCommand("gamemode").setTabCompleter(new GameModeCommand());

        infoPluginLauncher.getCommand("schinken").setExecutor(new SchinkenCommand());
        infoPluginLauncher.getCommand("enchant").setExecutor(new EnchantCommand());

    }

    public BackpackManager getBackpackManager() {
        return backpackManager;
    }

    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }

    public InfoPluginLauncher getInfoPluginLauncher() {
        return infoPluginLauncher;
    }

    public static InfoPlugin environment() {
        return environment;
    }
}