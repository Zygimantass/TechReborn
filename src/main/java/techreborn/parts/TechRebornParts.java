package techreborn.parts;

import java.util.HashMap;

import javax.annotation.Nullable;

import mcmultipart.multipart.MultipartRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import techreborn.compat.ICompatModule;
import techreborn.parts.fluidPipes.ItemFluidPipe;
import techreborn.parts.fluidPipes.MultipartFluidPipe;
import techreborn.parts.powerCables.CableMultipart;
import techreborn.parts.powerCables.EnumCableType;
import techreborn.parts.powerCables.ItemCables;

/**
 * Created by modmuss50 on 02/03/2016.
 */
public class TechRebornParts implements ICompatModule
{

	@Nullable
	public static Item cables;

	@Nullable
	public static Item fluidPipe;

	public static HashMap<EnumCableType, Class<? extends CableMultipart>> multipartHashMap = new HashMap<>();

	@Override
	public void preInit(FMLPreInitializationEvent event)
	{

	}

	@Override
	public void init(FMLInitializationEvent event)
	{
		for (EnumCableType cableType : EnumCableType.values())
		{
			multipartHashMap.put(cableType, cableType.cableClass);
			MultipartRegistry.registerPart(cableType.cableClass, "techreborn:cable." + cableType.name());
		}
		cables = new ItemCables();
		cables.setRegistryName("cables");
		GameRegistry.register(cables);

		MultipartRegistry.registerPart(MultipartFluidPipe.class, "techreborn:fluidpipe");
		fluidPipe = new ItemFluidPipe();
		fluidPipe.setRegistryName("fluidPipe");
		GameRegistry.register(fluidPipe);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event)
	{

	}

	@Override
	public void serverStarting(FMLServerStartingEvent event)
	{

	}
}
