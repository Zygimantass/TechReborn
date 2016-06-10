package techreborn.tiles.storage;

import reborncore.common.IWrenchable;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import reborncore.api.power.EnumPowerTier;
import reborncore.api.power.IEnergyItemInfo;
import reborncore.common.powerSystem.PoweredItem;
import reborncore.common.powerSystem.TileEnergyBase;
import techreborn.blocks.storage.BlockEnergyStorage;

/**
 * Created by Rushmead
 */
public class TileEnergyStorage extends TileEnergyBase implements IWrenchable {

	public String name;
	public Block wrenchDrop;
	public int maxInput;
	public int maxOutput;

	public TileEnergyStorage(String name, Block wrenchDrop, EnumPowerTier tier, int maxInput, int maxOuput, int maxStorage)
	{
		super(tier, maxStorage);
		this.wrenchDrop = wrenchDrop;
		this.name = name;
		this.maxInput = maxInput;
		this.maxOutput = maxOuput;
	}

	public int getEnergyScaled(int scale) {
		return (int) ((getEnergy() * scale / getMaxPower()));
	}

	@Override
	public boolean wrenchCanSetFacing(EntityPlayer entityPlayer, EnumFacing side) {
		return true;
	}

	@Override
	public EnumFacing getFacing() {
		return getFacingEnum();
	}

	@Override
	public boolean wrenchCanRemove(EntityPlayer entityPlayer) {
		return entityPlayer.isSneaking();
	}

	@Override
	public float getWrenchDropRate() {
		return 1.0F;
	}

	@Override
	public void updateEntity() {
		if (getInventoryUpgrades().getStackInSlot(0) != null)
		{
			ItemStack stack = getInventoryUpgrades().getStackInSlot(0);
			if(!(stack.getItem() instanceof IEnergyItemInfo)){
				return;
			}
			IEnergyItemInfo item = (IEnergyItemInfo) getInventoryUpgrades().getStackInSlot(0).getItem();
			if (PoweredItem.getEnergy(stack) != PoweredItem.getMaxPower(stack))
			{
				if (canUseEnergy(item.getMaxTransfer(stack)))
				{
					useEnergy(item.getMaxTransfer(stack));
					PoweredItem.setEnergy(PoweredItem.getEnergy(stack) + item.getMaxTransfer(stack), stack);
				}
			}
		}
		if (getInventoryUpgrades().getStackInSlot(1) != null)
		{
			ItemStack stack = getInventoryUpgrades().getStackInSlot(1);
			if(!(stack.getItem() instanceof IEnergyItemInfo)){
				return;
			}
			IEnergyItemInfo item = (IEnergyItemInfo) stack.getItem();
			if (item.canProvideEnergy(stack))
			{
				if (getEnergy() != getMaxPower())
				{
					addEnergy(item.getMaxTransfer(stack));
					PoweredItem.setEnergy(PoweredItem.getEnergy(stack) - item.getMaxTransfer(stack), stack);
				}
			}
		}
	}

	@Override
	public void setFacing(EnumFacing enumFacing) {
		worldObj.setBlockState(pos, worldObj.getBlockState(pos).withProperty(BlockEnergyStorage.FACING, enumFacing));
	}

	@Override
	public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
		return new ItemStack(wrenchDrop);
	}

	@Override
	public boolean canAcceptEnergy(EnumFacing direction) {
		return getFacingEnum() != direction;
	}

	@Override public EnumFacing getFacingEnum() {
		Block block = worldObj.getBlockState(pos).getBlock();
		if (block instanceof BlockEnergyStorage) {
			return ((BlockEnergyStorage) block).getFacing(worldObj.getBlockState(pos));
		}
		return null;
	}

	@Override
	public boolean canProvideEnergy(EnumFacing direction) {
		return getFacing() == direction;
	}

	@Override
	public double getMaxOutput() {
		return maxOutput;
	}

	@Override
	public double getMaxInput() {
		return maxInput;
	}

}