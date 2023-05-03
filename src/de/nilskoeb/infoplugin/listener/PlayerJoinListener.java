package de.nilskoeb.infoplugin.listener;

import de.nilskoeb.infoplugin.InfoPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage("§8[§a§l+§8] §7" + (player.isOp() ? "§4" + player.getName() : player.getName()));

        player.setScoreboard(InfoPlugin.environment().getScoreboardManager().getScoreboard());

        if (player.isOp()) {
            InfoPlugin.environment().getScoreboardManager().getAdminTeam().addEntry(player.getName());
        } else {
            InfoPlugin.environment().getScoreboardManager().getDefaultTeam().addEntry(player.getName());
        }

        InfoPlugin.environment().getBackpackManager().registerPlayer(player);
    }
}
