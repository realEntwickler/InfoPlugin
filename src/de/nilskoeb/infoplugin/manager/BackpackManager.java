package de.nilskoeb.infoplugin.manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.UUID;

public class BackpackManager {

    private HashMap<UUID, Inventory> backpacks;

    public BackpackManager () {
        backpacks = new HashMap<>();
    }

    public Inventory getBackpack (Player player) {
        return backpacks.get(player.getUniqueId());
    }

    public void registerPlayer (Player player) {
        backpacks.put(player.getUniqueId(), Bukkit.createInventory(null, 27, player.getDisplayName() + "§7s Backpack"));
    }

    public void deletePlayer (Player player) {
        backpacks.remove(player.getUniqueId());
    }
}
