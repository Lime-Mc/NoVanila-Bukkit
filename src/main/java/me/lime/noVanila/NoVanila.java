package me.lime.noVanila;

import me.lime.noVanila.listeners.chat.MainChatListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;

public class NoVanila extends JavaPlugin {

    private static NoVanila instance;
    private final Logger log = this.getLogger();
    protected FileConfiguration config;

    @Override
    public void onEnable() {
        log.info("Plugin is enabled!");
        config = getConfig();
        NoVanilaCommandExecutor commandExecutor = new NoVanilaCommandExecutor(this);
        Objects.requireNonNull(getCommand("nv")).setExecutor(commandExecutor);
        Bukkit.getPluginManager().registerEvents(new MainChatListener(), this);
    }

    @Override
    public void onDisable() {
        log.info("Plugin is disabled!");
    }
}
