package de.nilskoeb.infoplugin;

import de.nilskoeb.infoplugin.launcher.InfoPluginLauncher;
import de.nilskoeb.infoplugin.listener.PlayerJoinListener;
import de.nilskoeb.infoplugin.manager.ScoreboardManager;
import org.bukkit.Bukkit;

public class InfoPlugin {

    private static InfoPlugin environment;

    private final InfoPluginLauncher infoPluginLauncher;
    private final ScoreboardManager scoreboardManager;

    public InfoPlugin (InfoPluginLauncher infoPluginLauncher) {
        environment = this;

        this.infoPluginLauncher = infoPluginLauncher;
        this.scoreboardManager = new ScoreboardManager();

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), infoPluginLauncher);
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
