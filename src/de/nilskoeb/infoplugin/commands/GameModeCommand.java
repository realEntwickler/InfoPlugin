package de.nilskoeb.infoplugin.commands;

import de.nilskoeb.infoplugin.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GameModeCommand implements CommandExecutor, TabCompleter {

    private HashMap<String, GameMode> gameModeAliases;

    public GameModeCommand() {
        this.gameModeAliases = new HashMap<>();
        gameModeAliases.put("0", GameMode.SURVIVAL);
        gameModeAliases.put("s", GameMode.SURVIVAL);
        gameModeAliases.put("survival", GameMode.SURVIVAL);
        gameModeAliases.put("ueberleben", GameMode.SURVIVAL);

        gameModeAliases.put("1", GameMode.CREATIVE);
        gameModeAliases.put("c", GameMode.CREATIVE);
        gameModeAliases.put("creative", GameMode.CREATIVE);
        gameModeAliases.put("kreativ", GameMode.CREATIVE);

        gameModeAliases.put("2", GameMode.ADVENTURE);
        gameModeAliases.put("a", GameMode.ADVENTURE);
        gameModeAliases.put("adventure", GameMode.ADVENTURE);
        gameModeAliases.put("abenteuer", GameMode.ADVENTURE);

        gameModeAliases.put("3", GameMode.SPECTATOR);
        gameModeAliases.put("sp", GameMode.SPECTATOR);
        gameModeAliases.put("spectator", GameMode.SPECTATOR);
        gameModeAliases.put("zuschauer", GameMode.SPECTATOR);
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) {
            commandSender.sendMessage(Prefix.CMD_SEE_USAGE);
        } else if (strings.length == 1) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;

                String finding = gameModeAliases.keySet().stream().filter(filter -> filter.equalsIgnoreCase(strings[0])).findFirst().orElse(null);
                if (finding != null) {
                    player.setGameMode(gameModeAliases.get(finding));
                    player.sendMessage(Prefix.GENERAL + "Dein Spielmodus wurde zu §e" + player.getGameMode().name() + " §7gewechselt.");
                } else {
                    player.sendMessage(Prefix.GENERAL + "Der angegebene Spielmodus wurde §cnicht §7gefunden.");
                }
            } else {
                commandSender.sendMessage(Prefix.CMD_NOT_PLAYER);
            }
        } else if (strings.length == 2) {
            if (commandSender.hasPermission("infoplugin.command.gamemode.other")) {
                String finding = gameModeAliases.keySet().stream().filter(filter -> filter.equalsIgnoreCase(strings[0])).findFirst().orElse(null);

                if (finding != null) {
                    Player targetPlayer = Bukkit.getPlayer(strings[1]);

                    if (targetPlayer != null && targetPlayer.isOnline()) {
                        targetPlayer.setGameMode(gameModeAliases.get(finding));
                        commandSender.sendMessage(Prefix.GENERAL + "Der Spieler " + targetPlayer.getDisplayName() + " §7wurde in §e" + targetPlayer.getGameMode().name() + " §7versetzt.");
                    } else {
                        commandSender.sendMessage(Prefix.GENERAL + "Der Spieler §e" + strings[0] + " §7wurde §cnicht §7gefunden.");
                    }
                } else {
                    commandSender.sendMessage(Prefix.GENERAL + "Der angegebene Spielmodus wurde §cnicht §7gefunden.");
                }
            } else {
                commandSender.sendMessage(Prefix.CMD_NO_PERMISSION);
            }
        } else {
            commandSender.sendMessage(Prefix.CMD_SEE_USAGE);
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> list;

        if (strings.length == 1) {
            list = gameModeAliases.keySet().stream().filter(filter -> filter.startsWith(strings[0])).collect(Collectors.toList());
            return list;
        } else if (strings.length == 2){
            if (commandSender.hasPermission("infoplugin.command.gamemode.other")) {
                list = new ArrayList<>();
                Bukkit.getOnlinePlayers().stream().filter(all -> all.getName().startsWith(strings[1])).forEach(all -> list.add(all.getName()));
                return list;
            } else
                return new ArrayList<>();
        }
        return new ArrayList<>();
    }
}