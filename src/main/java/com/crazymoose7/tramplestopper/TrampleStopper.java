package com.crazymoose7.tramplestopper;

import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
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

			for (ItemStack itemStack : player.getArmorItems()) {
				if (itemStack.getItem() instanceof ArmorItem) {
					ArmorItem armorItem = (ArmorItem) itemStack.getItem();
					if (armorItem.method_7685() == EquipmentSlot.FEET && EnchantmentHelper.getLevel(Enchantments.FEATHER_FALLING, itemStack) >= 1) {
						return true;
					}
				}
			}
		}

		return false;
	}
}
