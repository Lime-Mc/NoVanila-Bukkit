package me.lime.noVanila;

import me.lime.noVanila.listeners.chat.MainChatListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;

public class NoVanila extends JavaPlugin {

    public static NoVanila instance;
    private final Logger log = this.getLogger();
    protected FileConfiguration config = getConfig();;

    @Override
    public void onEnable() {
        instance = this;
        log.info("&2Plugin is enabled!");
        saveDefaultConfig();
        NoVanilaCommandExecutor commandExecutor = new NoVanilaCommandExecutor(this);
        Objects.requireNonNull(getCommand("nv_reload")).setExecutor(commandExecutor);
        Objects.requireNonNull(getCommand("bc")).setExecutor(commandExecutor);
        Bukkit.getPluginManager().registerEvents(new MainChatListener(instance), this);
    }

    @Override
    public void onDisable() {
        saveConfig();
        log.info("&2Plugin is disabled!");
    }

    public static NoVanila getInstance() {
        return instance;
    }
}
