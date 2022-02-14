package de.cubeattack.onwayelytra.listeners;

import de.cubeattack.onwayelytra.OnWayElytra;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import java.util.Objects;

public class PlayerChangeWorld implements Listener {

    @EventHandler
    public static void onWorldChange(PlayerChangedWorldEvent e){
        Player player = e.getPlayer();
        if(player.getInventory().getChestplate() == null) return;
        if(Objects.requireNonNull(player.getInventory().getChestplate().getItemMeta()).getDisplayName().contains("Einweg Elytra")){
            player.getInventory().setChestplate(null);
            if(OnWayElytra.getSafeChestPlate().containsKey(player.getUniqueId())){
                player.getInventory().setChestplate(OnWayElytra.getSafeChestPlate().get(player.getUniqueId()));
                OnWayElytra.getSafeChestPlate().remove(player.getUniqueId());
            }
        }
    }
}

