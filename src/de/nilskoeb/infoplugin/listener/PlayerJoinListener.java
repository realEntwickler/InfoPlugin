package de.nilskoeb.infoplugin.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage("§8[§a§l+§8] §7" + (player.isOp() ? "§c" + player.getName() : player.getName()));
    }
}
