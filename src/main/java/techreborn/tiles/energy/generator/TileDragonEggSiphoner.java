package techreborn.tiles.energy.generator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import reborncore.api.power.EnumPowerTier;
import reborncore.api.tile.IInventoryProvider;
import reborncore.common.util.inventory.Inventory;
import techreborn.config.ConfigTechReborn;
import techreborn.init.ModBlocks;

public class TileDragonEggSiphoner extends AbstractTileGenerator {

	public static final int euTick = ConfigTechReborn.DragonEggSiphonerOutput;

	public TileDragonEggSiphoner() {
		super(EnumPowerTier.MEDIUM, 1000);
	}

	@Override
	public void updateRequirements() {
		int euPerTick = 0;

		if(getWorld().getBlockState(getPos().add(0, 1, 0)).getBlock() == Blocks.DRAGON_EGG) {
			euPerTick = ConfigTechReborn.DragonEggSiphonerOutput;
		}

		setEuPerTick(euPerTick);
	}

	@Override
	public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
		return new ItemStack(ModBlocks.Dragoneggenergysiphoner, 1);
	}
}
