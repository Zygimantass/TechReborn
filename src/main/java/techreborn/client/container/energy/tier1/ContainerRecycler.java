package techreborn.client.container.energy.tier1;

import net.minecraft.entity.player.EntityPlayer;
import reborncore.client.gui.slots.BaseSlot;
import reborncore.client.gui.slots.SlotOutput;
import techreborn.client.container.base.ContainerUpgradeable;
import techreborn.tiles.energy.tier1.TileRecycler;

public class ContainerRecycler extends ContainerUpgradeable {

	public ContainerRecycler(TileRecycler tileEntity, EntityPlayer player) {
		super(tileEntity, player);

		this.addSlotToContainer(new BaseSlot(tileEntity.getInventory(), getNextSlotIndex(), 56, 34));
		this.addSlotToContainer(new SlotOutput(tileEntity.getInventory(), getNextSlotIndex(), 116, 34));
	}
}
