package ir.paradoxteam.hPing;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class PingCMD implements CommandExecutor {

    private final Main plugin;

    public PingCMD(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfigManager().getPrefix());

        if (args.length == 0) {
            if (sender.hasPermission("hping.self")) {
                String message = plugin.getLanguageManager().getLanguageConfig().getString("self-ping");
                message = PlaceholderAPI.setPlaceholders((Player) sender, message);
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + message));
                return true;
            } else {
                String message = plugin.getLanguageManager().getLanguageConfig().getString("no-permission");
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + message));
                return true;
            }
        } else {
            if (sender.hasPermission("hping.others")) {
                String targetName = args[0];
                if (Bukkit.getPlayer(targetName) != null) {
                    Player target = Bukkit.getPlayer(targetName);
                    String message = plugin.getLanguageManager().getLanguageConfig().getString("others-ping");
                    message = PlaceholderAPI.setPlaceholders(target, message);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + message));
                    return true;
                } else {
                    String message = plugin.getLanguageManager().getLanguageConfig().getString("player-offline");
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + message));
                    return true;
                }
            } else {
                String message = plugin.getLanguageManager().getLanguageConfig().getString("no-permission");
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + message));
                return true;
            }
        }
    }
}