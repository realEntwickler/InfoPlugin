package de.nilskoeb.infoplugin.commands;

import de.nilskoeb.infoplugin.Prefix;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SchinkenCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            ItemStack itemStack = new ItemStack(Material.BEACON);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName("§d§lSchwarzwälder Schinken");
            itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
            itemStack.setItemMeta(itemMeta);

            player.getInventory().addItem(itemStack);
            player.sendMessage(Prefix.GENERAL + "Viel Spaß mit deinem neuen Stück §dSchinken");
        } else {
            commandSender.sendMessage(Prefix.CMD_NOT_PLAYER);
        }
        return false;
    }
}
