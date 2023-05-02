package de.nilskoeb.infoplugin.launcher;

import de.nilskoeb.infoplugin.InfoPlugin;
import org.bukkit.plugin.java.JavaPlugin;

public class InfoPluginLauncher extends JavaPlugin {

    @Override
    public void onEnable() {
        new InfoPlugin(this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
