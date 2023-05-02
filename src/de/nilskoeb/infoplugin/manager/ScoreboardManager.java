package de.nilskoeb.infoplugin.manager;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardManager {

    private Scoreboard scoreboard;

    public ScoreboardManager () {
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }
}
