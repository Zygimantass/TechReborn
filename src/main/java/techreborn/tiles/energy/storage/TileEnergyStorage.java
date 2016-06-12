package techreborn.tiles.energy.storage;

import net.minecraft.nbt.NBTTagCompound;
import reborncore.common.IWrenchable;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import reborncore.api.power.EnumPowerTier;
import reborncore.api.power.IEnergyItemInfo;
import reborncore.common.powerSystem.PoweredItem;
import reborncore.common.powerSystem.TileEnergyBase;
import reborncore.common.util.inventory.Inventory;
import techreborn.blocks.storage.BlockEnergyStorage;

import java.util.List;

/**
 * Created by Rushmead
 */
public abstract class TileEnergyStorage extends TileEnergyBase implements IWrenchable {

	public String name;
	public Block wrenchDrop;
	public int maxInput;
	public int maxOutput;

	private Inventory inventoryCharging;

	public TileEnergyStorage(String name, Block wrenchDrop, EnumPowerTier tier, int maxInput, int maxOuput, int maxStorage)
	{
		super(tier, maxStorage);
		this.wrenchDrop = wrenchDrop;
		this.name = name;
		this.maxInput = maxInput;
		this.maxOutput = maxOuput;

		this.inventoryCharging = new Inventory("Charging", 2, 1, this);
	}

	public int getEnergyScaled(int scale) {
		return (int) ((getEnergy() * scale / getMaxPower()));
	}

	public Inventory getInventoryCharging() {
		return this.inventoryCharging;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		this.inventoryCharging.readFromNBT(compound);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		this.inventoryCharging.writeToNBT(compound);

		return super.writeToNBT(compound);
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
        super.updateEntity();

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

	@Override
	public EnumFacing getFacingEnum() {
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

	public void setMaxOutput(int maxOutput) {
		this.maxOutput = maxOutput;
	}

	@Override
	public double getMaxInput() {
		return maxInput;
	}

	@Override
	public void addInfo(List<String> info, boolean isRealTile) {
		info.add(this.name);
	}

}