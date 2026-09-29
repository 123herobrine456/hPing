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
prefix: '&8[&aPing&8] '
```

lang.yml:
```
# You can use placeholders that PlaceholderAPI can parse in this line
self-ping: '&cPing: &a%player_ping%---'
# You can use placeholders that PlaceholderAPI can parse in this line
others-ping: '&c%player_name%'' Pin: &a%player_ping%---'
player-offline: '&1This Player Is Offline---'
reloaded: '&cPlugin Reloaded!---'
no-permission: '&aYou Dont Have Permission---'
```

