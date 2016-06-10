package techreborn.tiles.teir1;

import reborncore.common.IWrenchable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import reborncore.api.power.EnumPowerTier;
import reborncore.api.recipe.IRecipeCrafterProvider;
import reborncore.api.tile.IInventoryProvider;
import reborncore.common.container.RebornContainer;
import reborncore.common.powerSystem.TilePowerAcceptor;
import reborncore.common.recipes.RecipeCrafter;
import reborncore.common.tile.TileMachineInventory;
import reborncore.common.util.Inventory;
import techreborn.api.Reference;
import techreborn.client.container.ContainerCompressor;
import techreborn.init.ModBlocks;

public class TileCompressor extends TileMachineInventory implements IRecipeCrafterProvider {

	public RecipeCrafter crafter;

	public TileCompressor()
	{
		super(EnumPowerTier.LOW, 1000, 0, 1, "TileCompressor", 6, 64);
		int[] inputs = new int[1];
		inputs[0] = 0;
		int[] outputs = new int[1];
		outputs[0] = 1;
		crafter = new RecipeCrafter(Reference.compressorRecipe, this, 2, 1, getInventory(), inputs, outputs);
	}

	@Override
	public void updateEntity()
	{
		super.updateEntity();
		crafter.machineTick();
		//charge(3);
	}

	@Override
	public void machineFinish() {

	}

	@Override
	public ItemStack getWrenchDrop(EntityPlayer entityPlayer)
	{
		return new ItemStack(ModBlocks.Compressor, 1);
	}

	public boolean isComplete()
	{
		return false;
	}

//	// ISidedInventory
//	@Override
//	public int[] getSlotsForFace(EnumFacing side)
//	{
//		return side == EnumFacing.DOWN ? new int[] { 0, 1, 2 } : new int[] { 0, 1, 2 };
//	}
//
//	@Override
//	public boolean canInsertItem(int slotIndex, ItemStack itemStack, EnumFacing side)
//	{
//		if (slotIndex == 2)
//			return false;
//		return isItemValidForSlot(slotIndex, itemStack);
//	}
//
//	@Override
//	public boolean canExtractItem(int slotIndex, ItemStack itemStack, EnumFacing side)
//	{
//		return slotIndex == 2;
//	}

	public int getProgressScaled(int scale)
	{
		if (crafter.currentTickTime != 0)
		{
			return crafter.currentTickTime * scale / crafter.currentNeededTicks;
		}
		return 0;
	}

	@Override
	public boolean canAcceptEnergy(EnumFacing direction)
	{
		return true;
	}

	@Override
	public boolean canProvideEnergy(EnumFacing direction)
	{
		return false;
	}

	@Override
	public double getMaxOutput()
	{
		return 0;
	}

	@Override
	public double getMaxInput()
	{
		return 32;
	}

	@Override
	public RecipeCrafter getRecipeCrafter() {
		return crafter;
	}

	@Override
	public RebornContainer getContainer() {
		return RebornContainer.getContainerFromClass(ContainerCompressor.class, this);
	}
}
