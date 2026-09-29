hPing is a lightweight and efficient plugin designed to ping checks for players.

## ✨ Key Features
- Fast & Simple: A clean /ping command to instantly check ping.
- Fully Customizable: All messages, including the prefix and ping formats, are easily configurable through lang.yml.
- Permission-Based: Fine-tuned control with specific permissions for self-ping, checking others, and reloading the plugin.

## 🛠 Requirements
PlaceholderAPI (Required for ping placeholder parsing)

## 📜 Commands & Permissions
- /ping - hping.self - Check your own ping.
- /ping <player> - hping.others - Check another player’s ping.
- /pingreload	- hping.reload - Reload the plugin configuration.

## ⚙️ Configuration
The plugin uses two files for easy management:
config.yml:
```
prefix: '&8[&chPing&8] '
```

lang.yml:
```
# You can use placeholders that PlaceholderAPI can parse in this line
self-ping: '&fYour Ping: &a%player_ping%'
# You can use placeholders that PlaceholderAPI can parse in this line
others-ping: '&f%player_name%''s Ping: &a%player_ping%'
player-offline: '&cThis Player Is Offline'
reloaded: '&aPlugin Reloaded!'
no-permission: '&cYou Dont Have Permission'
```

