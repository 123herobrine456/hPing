package ir.paradoxteam.hPing;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.List;

public class LanguageManager {

    private final Main plugin;
    private final File file;
    private FileConfiguration language;

    public LanguageManager(Main plugin, String fileName) {
        this.plugin = plugin;
        this.file = new File(plugin.getDataFolder(), fileName);

        // make sure the plugin folder exists
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }

        load();
    }

    public void load() {
        this.language = YamlConfiguration.loadConfiguration(file);
        applyDefaults();
        save();
    }

    private void applyDefaults() {
        language.addDefault("self-ping", "&fYour Ping: &a%player_ping%");
        language.addDefault("others-ping", "&f%player_name%'s Ping: &a%player_ping%");
        language.addDefault("player-offline", "&cThis Player Is Offline");
        language.addDefault("reloaded", "&aPlugin Reloaded!");
        language.addDefault("no-permission", "&cYou Dont Have Permission");

        language.options().copyDefaults(true);

        List<String> note = List.of("You can use placeholders that PlaceholderAPI can parse in this line");
        language.setComments("self-ping", note);
        language.setComments("others-ping", note);
    }

    public void save() {
        try {
            language.save(file);
        } catch (Exception e) {
            plugin.getLogger().severe("Error while saving language file! " + e.getMessage());
        }
    }

    public File getFile() {
        return file;
    }

    public FileConfiguration getLanguageConfig() {
        return language;
    }

    public String getMessage(String key) {
        return language.getString(key, "&cMissing language key: " + key);
    }

}
