package techreborn.client.container.base;

import net.minecraft.entity.player.EntityPlayer;
import reborncore.api.recipe.IRecipeCrafterProvider;
import reborncore.client.gui.slots.BaseSlot;
import reborncore.common.container.RebornContainer;
import reborncore.common.powerSystem.TileEnergyBase;
import techreborn.api.gui.SlotUpgrade;

/**
 * Created by Lordmau5 on 10.06.2016.
 */
public class ContainerUpgradeable extends RebornContainer {

    private TileEnergyBase tileEntity;
    private EntityPlayer player;

    private int lastSlotIndex;

    public ContainerUpgradeable(TileEnergyBase tileEntity, EntityPlayer player) {
        super();

        this.tileEntity = tileEntity;
        this.player = player;

        /* Initialize Upgrade Slots */
        this.addSlotToContainer(new SlotUpgrade(tileEntity.getInventoryUpgrades(), getNextSlotIndex(), 152, 8));
        this.addSlotToContainer(new SlotUpgrade(tileEntity.getInventoryUpgrades(), getNextSlotIndex(), 152, 26));
        this.addSlotToContainer(new SlotUpgrade(tileEntity.getInventoryUpgrades(), getNextSlotIndex(), 152, 44));
        this.addSlotToContainer(new SlotUpgrade(tileEntity.getInventoryUpgrades(), getNextSlotIndex(), 152, 62));

        /* Add the player inventory */
        for(int i=0; i<3; i++) {
            for (int j=0; j<9; j++) {
                this.addSlotToContainer(new BaseSlot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int i=0; i<9; i++) {
            this.addSlotToContainer(new BaseSlot(player.inventory, i, 8 + i * 18, 142));
        }
    }

    protected int getNextSlotIndex() {
        this.lastSlotIndex += 1;
        return this.lastSlotIndex - 1;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }
}
