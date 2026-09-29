package ir.paradoxteam.hPing;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class ReloadCMD implements CommandExecutor {

    private final Main plugin;

    public ReloadCMD(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("hping.reload")) {
            String prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfigManager().getPrefix());
            String message = ChatColor.translateAlternateColorCodes('&', plugin.getLanguageManager().getMessage("no-permission"));
            sender.sendMessage(prefix + message);
            return true;
        }

        plugin.getConfigManager().load();
        plugin.getLanguageManager().load();

        String prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfigManager().getPrefix());
        String message = ChatColor.translateAlternateColorCodes('&', plugin.getLanguageManager().getMessage("reloaded"));
        sender.sendMessage(prefix + message);
        return true;
    }
}