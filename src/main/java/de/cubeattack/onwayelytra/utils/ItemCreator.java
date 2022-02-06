package de.cubeattack.onwayelytra.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class ItemCreator {
    public static ItemStack getElytra(){
        ItemStack elytra = new ItemStack(Material.ELYTRA);
        ItemMeta elytraMeta = elytra.getItemMeta();
        elytra.addUnsafeEnchantment(Enchantment.BINDING_CURSE, 1);
        elytra.addUnsafeEnchantment(Enchantment.VANISHING_CURSE, 1);

        Objects.requireNonNull(elytraMeta).setUnbreakable(true);
        elytraMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        elytraMeta.setDisplayName("Einweg Elytra");

        elytra.setItemMeta(elytraMeta);

        return elytra;
    }
}
