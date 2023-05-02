package de.nilskoeb.infoplugin;

import de.nilskoeb.infoplugin.launcher.InfoPluginLauncher;

public class InfoPlugin {

    private static InfoPlugin environment;

    private InfoPluginLauncher infoPluginLauncher;

    public InfoPlugin (InfoPluginLauncher infoPluginLauncher) {
        environment = this;

        this.infoPluginLauncher = infoPluginLauncher;
    }

    public InfoPluginLauncher getInfoPluginLauncher() {
        return infoPluginLauncher;
    }

    public static InfoPlugin environment() {
        return environment;
    }
}
