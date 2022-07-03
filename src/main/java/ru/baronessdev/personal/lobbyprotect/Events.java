package ru.baronessdev.personal.lobbyprotect;

import com.destroystokyo.paper.event.entity.EntityKnockbackByEntityEvent;
import com.destroystokyo.paper.event.entity.PhantomPreSpawnEvent;
import io.papermc.paper.event.entity.EntityLoadCrossbowEvent;
import io.papermc.paper.event.player.AsyncChatEvent;
import io.papermc.paper.event.player.PlayerChangeBeaconEffectEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.raid.RaidTriggerEvent;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Events implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        LobbyProtect.hidePlayers();

        e.joinMessage(null);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.quitMessage(null);
    }

    @EventHandler
    public void onChat(AsyncChatEvent e) {
        e.setCancelled(true);
        e.getPlayer().sendMessage(Messages.getMessage("no-chat"));
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        String command = e.getMessage().replace("/", "");

        if (Messages.getList("allowed-commands").parallelStream().noneMatch(command::contains)) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(Messages.getMessage("no-command"));
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBurn(BlockBurnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBlockDamage(BlockDamageEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBlockDropItem(BlockDropItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBlockForm(BlockFormEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onMultiPlace(BlockMultiPlaceEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onRetract(BlockPistonRetractEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onExtend(BlockPistonExtendEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onCraftItem(CraftItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onEnchantItem(EnchantItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDoorBreak(EntityBreakDoorEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onChangeBlock(EntityChangeBlockEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onCombust(EntityCombustEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBlockExplode(BlockExplodeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onKnockback(EntityKnockbackByEntityEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onCrossbow(EntityLoadCrossbowEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPickupItem(EntityPickupItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onEntityPlace(EntityPlaceEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onShootBow(EntityShootBowEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onSpawn(CreatureSpawnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onItemSpawn(ItemSpawnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onLeavesDecay(LeavesDecayEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onLightning(LightningStrikeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPhantomSpawn(PhantomPreSpawnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onChangeBeaconEffect(PlayerChangeBeaconEffectEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onEditBook(PlayerEditBookEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPickupArrow(PlayerPickupArrowEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onEntityPortal(EntityPortalEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerPortal(PlayerPortalEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onSplash(PotionSplashEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onRaid(RaidTriggerEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        e.setCancelled(true);
    }
}
