package ir.paradoxteam.hPing;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private ConfigManager configManager;
    private LanguageManager languageManager;

    @Override
    public void onEnable() {
        configManager = new ConfigManager(this);
        languageManager = new LanguageManager(this, "lang.yml");

        getCommand("ping").setExecutor(new PingCMD(this));
        getCommand("pingreload").setExecutor(new ReloadCMD(this));

        getLogger().info("Plugin Enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin Disabled");
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public LanguageManager getLanguageManager() {
        return languageManager;
    }
}
