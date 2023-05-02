package de.nilskoeb.infoplugin.commands;

import de.nilskoeb.infoplugin.Prefix;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameModeCommand implements CommandExecutor, TabCompleter {

    private HashMap<String, GameMode> gameModeAliases;

    public GameModeCommand () {
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

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) {
            commandSender.sendMessage(Prefix.CMD_SEE_USAGE);
        } else if (strings.length == 1) {

        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        ArrayList<String> list = new ArrayList<>();

        if (strings.length == 1) {

        }
        return list;
    }
}
