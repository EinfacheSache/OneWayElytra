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
        Player p = e.getPlayer();
        PlayerInventory inv = p.getInventory();
        if(WorldUtils.CheckLocation(p)){
           if(inv.getChestplate() == null){
               inv.setChestplate(ItemCreator.getElytra());
           }else{
               if(Objects.requireNonNull(e.getPlayer().getInventory().getChestplate()).getType() != Material.ELYTRA) {
                   for (int i = 0; i < 36; i++) {
                       if (inv.getItem(i) == null) {
                           inv.setItem(i, inv.getChestplate());
                           inv.setChestplate(ItemCreator.getElytra());
                           return;
                       }
                   }
                   e.getPlayer().sendMessage(OnWayElytra.getPREFIX() + "§4§lDa dein Inventar voll ist wurde deine Chestplate in den Zwischenspeicher gespeichert. Verlassen den Server nicht bis du deine Chestplate wieder hast!");
                   OnWayElytra.getSafeChestPlate().put(p.getUniqueId(), inv.getChestplate());
                   inv.setChestplate(ItemCreator.getElytra());
               }
           }
        }
    }
}
