package de.nilskoeb.infoplugin.manager;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardManager {

    private Scoreboard scoreboard;
    private Team adminTeam, defaultTeam;

    public ScoreboardManager () {
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        setupTeams();
    }

    private void setupTeams() {
        adminTeam = scoreboard.registerNewTeam("10Admin");
        adminTeam.setPrefix("§4Admin §8» §7");
        adminTeam.setDisplayName("§4");

        defaultTeam = scoreboard.registerNewTeam("00Spieler");
        defaultTeam.setPrefix("§7Spieler §8» §7");
        defaultTeam.setDisplayName("§7");
    }

    public Team getAdminTeam() {
        return adminTeam;
    }

    public Team getDefaultTeam() {
        return defaultTeam;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }
}
