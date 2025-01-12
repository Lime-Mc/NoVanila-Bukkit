package me.lime.noVanila.listeners.chat;

import io.papermc.paper.event.player.AsyncChatEvent;
import me.lime.noVanila.NoVanila;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

public class MainChatListener implements Listener {
    private final NoVanila plugin;

    public MainChatListener(NoVanila plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncChatEvent event) {
        if (plugin.getConfig().getBoolean("chat.enabled")) {
            event.renderer((source, sourceDisplayName, message, viewer) ->
                    Component.text()
                            .append(sourceDisplayName.color(TextColor.fromHexString(Objects.requireNonNull(plugin.getConfig().getString("chat.nickname_color")))))
                            .append(Component.text(Objects.requireNonNull(plugin.getConfig().getString("chat.separator")), TextColor.fromHexString(Objects.requireNonNull(plugin.getConfig().getString("chat.separator_color")))))
                            .append(message.color(TextColor.fromHexString(Objects.requireNonNull(plugin.getConfig().getString("chat.message_color")))))
                            .build());
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (plugin.getConfig().getBoolean("join.enabled")) {
            event.joinMessage(Component.text()
                    .append(Component.text("["))
                    .append(Component.text("+", TextColor.fromHexString(Objects.requireNonNull(plugin.getConfig().getString("join.plus_color")))))
                    .append(Component.text("] "))
                    .append(event.getPlayer().displayName())
                    .build());
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if (plugin.getConfig().getBoolean("leave.enabled")) {
            event.quitMessage(Component.text()
                    .append(Component.text("["))
                    .append(Component.text("-", TextColor.fromHexString(Objects.requireNonNull(plugin.getConfig().getString("leave.minus_color")))))
                    .append(Component.text("] "))
                    .append(event.getPlayer().displayName())
                    .build());
        }
    }
}
