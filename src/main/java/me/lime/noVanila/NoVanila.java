package me.lime.noVanila;

import me.lime.noVanila.listeners.chat.MainChatListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class NoVanila extends JavaPlugin {

    private static NoVanila instance;
    private final Logger log = this.getLogger();

    @Override
    public void onEnable() {
        log.info("Plugin is enabled!");
        Bukkit.getPluginManager().registerEvents(new MainChatListener(), this);
    }

    @Override
    public void onDisable() {
        log.info("Plugin is disabled!");
    }
}
