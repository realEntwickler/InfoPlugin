package de.nilskoeb.infoplugin.commands;

import de.nilskoeb.infoplugin.utils.Prefix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class EnchantCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (strings.length == 0) {
                player.sendMessage(Prefix.GENERAL + "Benutzung: §e/enchant <Enchantment> [Level]");
            } else if (strings.length == 1) {
                Enchantment enchantment = Enchantment.getByName(strings[0]);
                if (enchantment != null) {
                    if (player.getItemInHand() != null) {
                        player.getItemInHand().getItemMeta().addEnchant(enchantment, 1, true);
                        player.sendMessage(Prefix.GENERAL + "Die Verzauberung §e" + enchantment.getName() + " §7wurde auf dein Item angewendet");
                    } else {
                        player.sendMessage(Prefix.GENERAL + "Du hältst §ckein §7Item in der Hand");
                    }
                } else {
                    player.sendMessage(Prefix.GENERAL + "Die angegebene Verzauberung wurde §cnicht §7gefunden");
                }
            } else if (strings.length == 2) {
                Enchantment enchantment = Enchantment.getByName(strings[0]);
                if (enchantment != null) {
                    if (player.getItemInHand() != null) {
                        int level = 0;

                        try {
                            level = Integer.parseInt(strings[1]);
                        } catch (NumberFormatException exception) {
                            player.sendMessage(Prefix.GENERAL + "Du hast §ckeine §7Zahl angegeben");
                            return false;
                        }

                        player.getItemInHand().getItemMeta().addEnchant(enchantment, level, true);
                        player.sendMessage(Prefix.GENERAL + "Die Verzauberung §e" + enchantment.getName() + " §8(§e" + level + "§8) §7wurde auf dein Item angewendet");
                    } else {
                        player.sendMessage(Prefix.GENERAL + "Du hältst §ckein §7Item in der Hand");
                    }
                } else {
                    player.sendMessage(Prefix.GENERAL + "Die angegebene Verzauberung wurde §cnicht §7gefunden");
                }
            } else {
                player.sendMessage(Prefix.CMD_SEE_USAGE);
            }
        } else {
            commandSender.sendMessage(Prefix.CMD_NOT_PLAYER);
        }
        return false;
    }
}
