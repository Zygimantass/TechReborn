package techreborn.client.container.energy.tier0;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.SlotFurnaceFuel;
import reborncore.client.gui.slots.SlotInput;
import reborncore.client.gui.slots.SlotOutput;
import techreborn.client.container.base.ContainerBase;
import techreborn.tiles.TileAlloyFurnace;

public class ContainerIronAlloyFurnace extends ContainerBase {

	public int tickTime;
	private int currentItemBurnTime;
	private int burnTime;
	private int cookTime;

	private TileAlloyFurnace tileAlloyFurnace;

	public ContainerIronAlloyFurnace(TileAlloyFurnace tileEntity, EntityPlayer player) {
		super(tileEntity, player);

		this.tileAlloyFurnace = tileEntity;

		// input
		this.addSlotToContainer(new SlotInput(tileEntity.getInventory(), getNextSlotIndex(), 47, 17));
		this.addSlotToContainer(new SlotInput(tileEntity.getInventory(), getNextSlotIndex(), 65, 17));

		// outputs
		this.addSlotToContainer(new SlotOutput(tileEntity.getInventory(), getNextSlotIndex(), 116, 35));

		// Fuel
		this.addSlotToContainer(new SlotFurnaceFuel(tileEntity.getInventory(), getNextSlotIndex(), 56, 53));
	}

	@Override
	public void addListener(IContainerListener crafting) {
		super.addListener(crafting);
		crafting.sendProgressBarUpdate(this, 0, this.tileAlloyFurnace.currentItemBurnTime);
		crafting.sendProgressBarUpdate(this, 1, this.tileAlloyFurnace.burnTime);
		crafting.sendProgressBarUpdate(this, 2, this.tileAlloyFurnace.cookTime);
	}

	@Override
	public void detectAndSendChanges() {
		for(int i=0; i<this.listeners.size(); i++) {
			IContainerListener crafting = this.listeners.get(i);
			if (this.currentItemBurnTime != this.tileAlloyFurnace.currentItemBurnTime) {
				crafting.sendProgressBarUpdate(this, 0, this.tileAlloyFurnace.currentItemBurnTime);
			}
			if (this.burnTime != this.tileAlloyFurnace.burnTime) {
				crafting.sendProgressBarUpdate(this, 1, this.tileAlloyFurnace.burnTime);
			}
			if (this.cookTime != this.tileAlloyFurnace.cookTime) {
				crafting.sendProgressBarUpdate(this, 2, this.tileAlloyFurnace.cookTime);
			}
		}
		super.detectAndSendChanges();
	}

	@Override
	public void updateProgressBar(int id, int value)
	{
		super.updateProgressBar(id, value);
		if (id == 0) {
			this.currentItemBurnTime = value;
		}
		else if (id == 1) {
			this.burnTime = value;
		}
		else if (id == 2) {
			this.cookTime = value;
		}
		this.tileAlloyFurnace.currentItemBurnTime = this.currentItemBurnTime;
		this.tileAlloyFurnace.burnTime = this.burnTime;
		this.tileAlloyFurnace.cookTime = this.cookTime;
	}
}
