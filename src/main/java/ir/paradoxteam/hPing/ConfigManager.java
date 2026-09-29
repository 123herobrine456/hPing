package ir.paradoxteam.hPing;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class ConfigManager {

    private final Main plugin;
    private String prefix;

    public  ConfigManager(Main plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
        load();
    }

    public void load() {
        plugin.reloadConfig();
        FileConfiguration config = plugin.getConfig();
        prefix = config.getString("prefix");
    }

    public String getPrefix() { return prefix; }

}
