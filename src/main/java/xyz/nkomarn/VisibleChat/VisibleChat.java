package xyz.nkomarn.VisibleChat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class VisibleChat extends JavaPlugin implements Listener {

    private ChatColor color;

    public void onEnable() {
        saveDefaultConfig();
        color = ChatColor.valueOf(getConfig().getString("color"));
        getServer().getPluginManager().registerEvents(this, this);
    }

    public void onDisable() {
        
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        e.getRecipients().remove(player);
        player.sendMessage(String.format(e.getFormat(),
                player.getDisplayName(),
                color + e.getMessage()));
    }
}
