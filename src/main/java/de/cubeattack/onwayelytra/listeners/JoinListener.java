package de.cubeattack.onwayelytra.listeners;

import de.cubeattack.onwayelytra.utils.WorldUtils;
import de.cubeattack.onwayelytra.utils.ItemCreator;
import de.cubeattack.onwayelytra.OnWayElytra;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.PlayerInventory;

import java.util.Objects;

public class JoinListener implements Listener {

    @EventHandler
    public static void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        PlayerInventory playerInventory = player.getInventory();
        if(WorldUtils.CheckLocation(player)){
           if(playerInventory.getChestplate() == null){
               playerInventory.setChestplate(ItemCreator.getElytra());
           }else{
               if(Objects.requireNonNull(e.getPlayer().getInventory().getChestplate()).getType() != Material.ELYTRA) {
                   for (int i = 0; i < 36; i++) {
                       if (playerInventory.getItem(i) == null) {
                           playerInventory.setItem(i, playerInventory.getChestplate());
                           playerInventory.setChestplate(ItemCreator.getElytra());
                           return;
                       }
                   }
                   e.getPlayer().sendMessage(OnWayElytra.getPREFIX() + "§4§lDa dein Inventar voll ist wurde deine Chestplate in den Zwischenspeicher gespeichert. Verlassen den Server nicht bis du deine Chestplate wieder hast!");
                   OnWayElytra.getSafeChestPlate().put(player.getUniqueId(), playerInventory.getChestplate());
                   playerInventory.setChestplate(ItemCreator.getElytra());
               }
           }
        }
    }
}
