package me.launchpad.launchpad;

import me.launchpad.launchpad.$LaunchPad.$LaunchPad;
import me.launchpad.launchpad.fall.$fall;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class LaunchPad extends JavaPlugin {

    public ArrayList<Player>lp = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("[LaunchPad] Loaded!!!");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new $LaunchPad(this), this);
        getServer().getPluginManager().registerEvents(new $fall(this), this);
    }
}
