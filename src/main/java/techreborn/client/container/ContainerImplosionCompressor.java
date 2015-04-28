package techreborn.client.container;

import techreborn.client.SlotOutput;
import techreborn.tiles.TileAlloySmelter;
import techreborn.tiles.TileGrinder;
import techreborn.tiles.TileImplosionCompressor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;

public class ContainerImplosionCompressor extends TechRebornContainer{
	
	EntityPlayer player;

	TileImplosionCompressor tile;


	public int tickTime;

	public ContainerImplosionCompressor(TileImplosionCompressor tilecompressor,
			EntityPlayer player)
	{
		tile = tilecompressor;
		this.player = player;

		// input
		this.addSlotToContainer(new Slot(tilecompressor.inventory, 0, 34, 16));
		this.addSlotToContainer(new Slot(tilecompressor.inventory, 1, 34, 34));
		// outputs
		this.addSlotToContainer(new Slot(tilecompressor.inventory, 2, 86, 25));
		this.addSlotToContainer(new Slot(tilecompressor.inventory, 3, 104, 25));


		int i;

		for (i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(player.inventory, j + i * 9
						+ 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18,
					142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_)
	{
		return true;
	}

}