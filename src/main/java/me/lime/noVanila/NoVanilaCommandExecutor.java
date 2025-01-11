package me.lime.noVanila;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class NoVanilaCommandExecutor implements CommandExecutor {

    private final NoVanila plugin;

    public NoVanilaCommandExecutor(NoVanila plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("nv") && sender.hasPermission("nv.admin")) {
            if (args[0].equals("reload")) {
                plugin.reloadConfig();
            }
            return false;
        }
        if (cmd.getName().equalsIgnoreCase("bc") && sender.hasPermission("nv.bc")) {
                if (args.length != 0) {
                    String message = "";
                    for (String arg : args) {
                        message = String.valueOf(message) + arg + " ";
                    }
                    message = ChatColor.translateAlternateColorCodes('&', message);
                    Bukkit.broadcastMessage(sender.getName() + "говорит:" + message);
                    return true;
                }
                return false;
        }
        return false;
    }
}