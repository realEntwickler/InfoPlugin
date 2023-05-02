package de.nilskoeb.infoplugin.commands;

import de.nilskoeb.infoplugin.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class FlyCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (strings.length == 0) {
                player.setAllowFlight(!player.getAllowFlight());
                player.setFlying(player.getAllowFlight());

                if (player.getAllowFlight()) {
                    player.sendMessage(Prefix.GENERAL + "Du kannst §anun §7fliegen.");
                } else {
                    player.sendMessage(Prefix.GENERAL + "Du kannst §cnicht §7mehr fliegen.");
                }
            } else if (strings.length == 1) {
                if (player.hasPermission("infoplugin.command.fly.other")) {
                    Player targetPlayer = Bukkit.getPlayer(strings[0]);

                    if (targetPlayer != null && targetPlayer.isOnline()) {
                        if (!targetPlayer.isOp()) {
                            targetPlayer.setAllowFlight(!targetPlayer.getAllowFlight());
                            targetPlayer.setFlying(targetPlayer.getAllowFlight());

                            if (targetPlayer.getAllowFlight()) {
                                player.sendMessage(Prefix.GENERAL + "Der Spieler " + targetPlayer.getDisplayName() + " §7kann §anun §7fliegen.");
                            } else {
                                player.sendMessage(Prefix.GENERAL + "Der Spieler " + targetPlayer.getDisplayName() + " §7kann §cnicht §7mehr fliegen.");
                            }
                        } else {
                            player.sendMessage(Prefix.GENERAL + "Du kannst den §eFlugmodus §7eines §4Administrator §cnicht §7ändern.");
                        }
                    } else {
                        player.sendMessage(Prefix.GENERAL + "Der Spieler §e" + strings[0] + " §7wurde §cnicht §7gefunden.");
                    }
                } else {
                    player.sendMessage(Prefix.CMD_NO_PERMISSION);
                }
            } else {
                player.sendMessage(Prefix.CMD_SEE_USAGE);
            }
        } else {
            commandSender.sendMessage(Prefix.CMD_NOT_PLAYER);
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        ArrayList<String> completements = new ArrayList<>();
        return completements;
    }
}
