package de.cubeattack.onwayelytra.listeners;

import de.cubeattack.onwayelytra.OnWayElytra;
import de.cubeattack.onwayelytra.utils.WorldUtils;
import de.cubeattack.onwayelytra.utils.ItemHandel;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.PlayerInventory;

import java.util.Objects;

public class PlayerMove implements Listener {

    @EventHandler
    public static void onPlayerMove(PlayerMoveEvent e){
        Player player = e.getPlayer();
        PlayerInventory playerInventory = player.getInventory();
        if(WorldUtils.CheckLocation(e.getPlayer())){
            if(playerInventory.getChestplate() == null){
                playerInventory.setChestplate(ItemHandel.getElytra());
            }else{
                if(Objects.requireNonNull(e.getPlayer().getInventory().getChestplate()).getType() != Material.ELYTRA) {
                    for (int i = 0; i < 36; i++) {
                        if (playerInventory.getItem(i) == null) {
                            playerInventory.setItem(i, playerInventory.getChestplate());
                            playerInventory.setChestplate(ItemHandel.getElytra());
                            return;
                        }
                    }
                    e.getPlayer().sendMessage(OnWayElytra.getPREFIX() + "§4§lDa dein Inventar voll ist wurde deine Chestplate in den Zwischenspeicher gespeichert. Verlassen den Server nicht bis du deine Chestplate wieder hast!");
                    OnWayElytra.getSafeChestPlate().put(e.getPlayer().getUniqueId(), playerInventory.getChestplate());
                    playerInventory.setChestplate(ItemHandel.getElytra());
            }
            }
        }else{
            if(playerInventory.getChestplate() == null){return;}
            if(e.getPlayer().isGliding() || player.getLocation().add(0.0D, -1.0D, 0.0D).getBlock().getType() == Material.AIR){return;}
            if(!Objects.requireNonNull(playerInventory.getChestplate().getItemMeta()).getDisplayName().contains("Einweg Elytra")){return;}
            player.getInventory().setChestplate(null);
            if(OnWayElytra.getSafeChestPlate().containsKey(player.getUniqueId())) {
                player.getInventory().setChestplate(OnWayElytra.getSafeChestPlate().get(player.getUniqueId()));
                OnWayElytra.getSafeChestPlate().remove(player.getUniqueId());
            }
        }
    }
}
