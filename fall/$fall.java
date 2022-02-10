package me.launchpad.launchpad.fall;

import me.launchpad.launchpad.LaunchPad;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;


public class $fall implements Listener {

    LaunchPad plugin;

    public $fall(LaunchPad plugin) {
        this.plugin = plugin;
    }

    @EventHandler

    public void ofFallDamage(EntityDamageEvent e) {
        Entity p = e.getEntity();
        if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL) && plugin.getConfig().getBoolean("yea")) {
            e.setCancelled(true);
            if (plugin.lp.contains(e.getEntity())) {
                if (plugin.getConfig().getBoolean("fall")) {
                    if (p.hasPermission("lang.zh")) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("fall-msg")));
                    }
                plugin.lp.remove(e.getEntity());
                }
            }
        }
    }
}
