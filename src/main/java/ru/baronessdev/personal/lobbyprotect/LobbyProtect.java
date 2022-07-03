package ru.baronessdev.personal.lobbyprotect;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class LobbyProtect extends JavaPlugin {
    public static LobbyProtect inst;
    private static final ExecutorService executor = Executors.newCachedThreadPool();
    private static ProtocolManager protocolManager;

    public LobbyProtect() {
        inst = this;
    }

    public static void hidePlayers() {
        executor.execute(() -> {
            List<Player> players = List.copyOf(Bukkit.getOnlinePlayers());

            players.parallelStream().forEach(player -> executor.execute(() -> {
                PacketContainer packet = protocolManager.createPacket(PacketType.Play.Server.PLAYER_INFO);
                packet.getPlayerInfoAction().write(0, EnumWrappers.PlayerInfoAction.REMOVE_PLAYER);

                WrappedGameProfile profile = WrappedGameProfile.fromPlayer(player);
                WrappedChatComponent name = WrappedChatComponent.fromText(player.getName());

                packet.getPlayerInfoDataLists().write(0, List.of(
                        new PlayerInfoData(profile, 0, EnumWrappers.NativeGameMode.fromBukkit(player.getGameMode()), name)));

                players.parallelStream().forEach(p -> {
                    if (!p.equals(player)) {
                        try {
                            protocolManager.sendServerPacket(p, packet);
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }

                        p.hidePlayer(LobbyProtect.inst, player);
                    }
                });
            }));
        });
    }

    @Override
    public void onEnable() {
        protocolManager = ProtocolLibrary.getProtocolManager();
        hidePlayers();

        Messages.load();
        Bukkit.getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() { }
}