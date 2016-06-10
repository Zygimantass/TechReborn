package techreborn.tiles.teir1;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import reborncore.api.power.EnumPowerTier;
import reborncore.api.recipe.IRecipeCrafterProvider;
import reborncore.common.container.RebornContainer;
import reborncore.common.recipes.RecipeCrafter;
import reborncore.common.tile.TileMachineInventory;
import techreborn.api.Reference;
import techreborn.client.container.ContainerExtractor;
import techreborn.init.ModBlocks;

public class TileExtractor extends TileMachineInventory implements IRecipeCrafterProvider
{

	public RecipeCrafter crafter;

	public TileExtractor()
	{
		super(EnumPowerTier.LOW, 1000, 0, 1, "TileExtractor", 6, 64);
		int[] inputs = new int[1];
		inputs[0] = 0;
		int[] outputs = new int[1];
		outputs[0] = 1;
		crafter = new RecipeCrafter(Reference.extractorRecipe, this, 2, 1, getInventory(), inputs, outputs);
	}

	@Override
	public void machineTick() {
		if(!crafter.machineTick())
			return;

		super.machineTick();
	}

	@Override
	public void machineFinish() {
		crafter.machineFinish();
	}

	@Override
	public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
		return new ItemStack(ModBlocks.Extractor, 1);
	}

	public boolean isComplete() {
		return false;
	}

//	// ISidedInventory
//	@Override
//	public int[] getSlotsForFace(EnumFacing side) {
//		return side == EnumFacing.DOWN ? new int[] { 0, 1, 2 } : new int[] { 0, 1, 2 };
//	}
//
//	@Override
//	public boolean canInsertItem(int slotIndex, ItemStack itemStack, EnumFacing side) {
//		return slotIndex != 2 && isItemValidForSlot(slotIndex, itemStack);
//	}
//
//	@Override
//	public boolean canExtractItem(int slotIndex, ItemStack itemStack, EnumFacing side) {
//		return slotIndex == 2;
//	}

	@Override
	public double getMaxOutput() {
		return 0;
	}

	@Override
	public double getMaxInput() {
		return 32;
	}

	@Override
	public RecipeCrafter getRecipeCrafter() {
		return crafter;
	}

	@Override
	public void updateInventory() {
		crafter.updateInventory();
	}

	@Override
	public RebornContainer getContainer() {
		return RebornContainer.getContainerFromClass(ContainerExtractor.class, this);
	}
}
