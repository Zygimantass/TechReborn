package techreborn.client.container.base;

import net.minecraft.entity.player.EntityPlayer;
import reborncore.common.container.RebornContainer;
import reborncore.common.powerSystem.TileEnergyBase;

/**
 * Created by Lordmau5 on 11.06.2016.
 */
public abstract class ContainerBase extends RebornContainer {

    protected TileEnergyBase tileEntity;
    protected EntityPlayer player;

    private int lastSlotIndex;

    public ContainerBase(TileEnergyBase tileEntity, EntityPlayer player) {
        super();

        this.tileEntity = tileEntity;
        this.player = player;

        /* Add the player inventory */
        addPlayersHotbar(player);
        addPlayersInventory(player);
    }

    protected int getNextSlotIndex() {
        this.lastSlotIndex += 1;
        return this.lastSlotIndex - 1;
    }

    public int getEnergy() {
        return (int) tileEntity.getEnergy();
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

}
