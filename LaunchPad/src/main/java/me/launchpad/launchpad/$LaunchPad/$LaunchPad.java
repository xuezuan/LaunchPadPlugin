package me.launchpad.launchpad.$LaunchPad;

import me.launchpad.launchpad.LaunchPad;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class $LaunchPad implements Listener {

    LaunchPad plugin;

    public $LaunchPad(LaunchPad plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerWalk(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Vector v = p.getVelocity().normalize().setY(plugin.getConfig().getInt("Y")).setX(plugin.getConfig().getInt("x")).setZ(plugin.getConfig().getInt("z"));
        if (!plugin.getConfig().getBoolean("enable")) {
            return;
        }

        if (p.getLocation().getBlock().getType().equals(
                Material.valueOf(plugin.getConfig().getString("top-block")))) {
            p.setVelocity(v);
            if (!plugin.lp.contains(e.getPlayer())) {
                if (p.hasPermission("lang.en")) {
                    if (plugin.getConfig().getBoolean("en-chat-enable")) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig()
                                .getString(
                                        "en-message")));
                        plugin.lp.add(p);
                    }
                } else if (plugin.getConfig().getBoolean("chat-enable")) {
                    if (p.hasPermission("lang.zh")) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig()
                                .getString(
                                        "message")));
                        plugin.lp.add(p);
                    }
                }
            }
        }
    }
}
