package de.nilskoeb.infoplugin.listener;

import de.nilskoeb.infoplugin.InfoPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit (PlayerQuitEvent event) {
        Player player = event.getPlayer();


        event.setQuitMessage("§8[§c§l-§8] §7" + (player.isOp() ? "§4" + player.getName() : player.getName()));

        InfoPlugin.environment().getBackpackManager().deletePlayer(player);
    }
}
