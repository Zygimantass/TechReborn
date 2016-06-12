package techreborn.client.container.energy.storage;

import net.minecraft.entity.player.EntityPlayer;
//import reborncore.client.gui.slots.BaseSlot;
import reborncore.client.gui.slots.SlotChargeItem;
import techreborn.client.container.base.ContainerEnergyEquipment;
import techreborn.tiles.energy.storage.TileChargeBench;

public class ContainerChargeBench extends ContainerEnergyEquipment {

	public ContainerChargeBench(TileChargeBench tileEntity, EntityPlayer player) {
		super(tileEntity, player);

		this.addSlotToContainer(new SlotChargeItem(tileEntity.getInventory(), getNextSlotIndex(), 62, 21));
		this.addSlotToContainer(new SlotChargeItem(tileEntity.getInventory(), getNextSlotIndex(), 80, 21));
		this.addSlotToContainer(new SlotChargeItem(tileEntity.getInventory(), getNextSlotIndex(), 98, 21));
		this.addSlotToContainer(new SlotChargeItem(tileEntity.getInventory(), getNextSlotIndex(), 62, 39));
		this.addSlotToContainer(new SlotChargeItem(tileEntity.getInventory(), getNextSlotIndex(), 80, 39));
		this.addSlotToContainer(new SlotChargeItem(tileEntity.getInventory(), getNextSlotIndex(), 98, 39));
	}

}
