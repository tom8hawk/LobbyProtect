package ru.baronessdev.personal.lobbyprotect;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public final class Messages {
    private static final YamlConfiguration configuration = new YamlConfiguration();

    public static void load() {
        File file = new File(LobbyProtect.inst.getDataFolder() + "/messages.yml");

        if (!file.exists())
            LobbyProtect.inst.saveResource("messages.yml", true);

        try {
            configuration.load(file);
        } catch (IOException | org.bukkit.configuration.InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static String getMessage(String path) {
        String result = configuration.getString(path);
        return ChatColor.translateAlternateColorCodes('&', result != null ? result : "");
    }

    public static List<String> getList(String path) {
        return configuration.getStringList(path).stream().map(line -> ChatColor.translateAlternateColorCodes('&', line)).collect(Collectors.toList());
    }
}
