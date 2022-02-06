package de.cubeattack.onwayelytra.listeners;

import de.cubeattack.onwayelytra.OnWayElytra;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class PlayerChangeWorld implements Listener {

    @EventHandler
    public static void onWorldChange(PlayerChangedWorldEvent e){
        Player p = e.getPlayer();
        if(p.getInventory().getChestplate() == null) return;
        if(p.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Einweg Elytra")){
            p.getInventory().setChestplate(null);
            if(OnWayElytra.getSafeChestPlate().containsKey(p.getUniqueId())){
                p.getInventory().setChestplate(OnWayElytra.getSafeChestPlate().get(p.getUniqueId()));
            }
        }
    }
}

