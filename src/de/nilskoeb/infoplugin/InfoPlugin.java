package de.nilskoeb.infoplugin;

import de.nilskoeb.infoplugin.launcher.InfoPluginLauncher;
import de.nilskoeb.infoplugin.listener.PlayerJoinListener;
import org.bukkit.Bukkit;

public class InfoPlugin {

    private static InfoPlugin environment;

    private InfoPluginLauncher infoPluginLauncher;

    public InfoPlugin (InfoPluginLauncher infoPluginLauncher) {
        environment = this;

        this.infoPluginLauncher = infoPluginLauncher;

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), infoPluginLauncher);
    }

    public InfoPluginLauncher getInfoPluginLauncher() {
        return infoPluginLauncher;
    }

    public static InfoPlugin environment() {
        return environment;
    }
}
