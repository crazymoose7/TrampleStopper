package com.crazymoose7.tramplestopper;

import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TrampleStopper implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public void onInitialize() {
		LOGGER.info("Loading!");
	}

	public static boolean onFarmlandTrample(Entity entity) {
		if (entity instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) entity;
			ItemStack boots = player.getInventory().getArmorStack(0);
			Registry<Enchantment> registry = player.getWorld().getRegistryManager().getOptional(RegistryKeys.ENCHANTMENT).get();

            return EnchantmentHelper.getLevel(registry.getOrThrow(Enchantments.FEATHER_FALLING), boots) >= 1;
		}

		return false;
	}
}
