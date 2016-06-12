package techreborn.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.ArrayUtils;
import reborncore.common.tile.TileMachineBase;
import reborncore.common.util.StringUtils;
import techreborn.Core;
import techreborn.blocks.*;
import techreborn.blocks.advanced_machine.BlockBlastFurnace;
import techreborn.blocks.advanced_machine.BlockCentrifuge;
import techreborn.blocks.advanced_machine.BlockDistillationTower;
import techreborn.blocks.advanced_machine.BlockImplosionCompressor;
import techreborn.blocks.advanced_machine.BlockIndustrialElectrolyzer;
import techreborn.blocks.advanced_machine.BlockIndustrialGrinder;
import techreborn.blocks.advanced_machine.BlockIndustrialSawmill;
import techreborn.blocks.generator.BlockDieselGenerator;
import techreborn.blocks.generator.BlockDragonEggSiphoner;
import techreborn.blocks.generator.BlockGasTurbine;
import techreborn.blocks.generator.BlockGenerator;
import techreborn.blocks.generator.BlockLightningRod;
import techreborn.blocks.generator.BlockMagicEnergyAbsorber;
import techreborn.blocks.generator.BlockMagicEnergyConverter;
import techreborn.blocks.generator.BlockPlasmaGenerator;
import techreborn.blocks.generator.BlockSemiFluidGenerator;
import techreborn.blocks.generator.BlockSolarPanel;
import techreborn.blocks.generator.BlockThermalGenerator;
import techreborn.blocks.generator.BlockWaterMill;
import techreborn.blocks.generator.BlockWindMill;
import techreborn.blocks.iron_machines.BlockAlloyFurnace;
import techreborn.blocks.iron_machines.BlockIronFurnace;
import techreborn.blocks.machine.BlockAssemblingMachine;
import techreborn.blocks.machine.BlockChargeBench;
import techreborn.blocks.machine.BlockChemicalReactor;
import techreborn.blocks.machine.BlockChunkLoader;
import techreborn.blocks.machine.BlockMatterFabricator;
import techreborn.blocks.machine.BlockRollingMachine;
import techreborn.blocks.machine.BlockScrapboxinator;
import techreborn.blocks.machine.BlockVacuumFreezer;
import techreborn.blocks.storage.BlockAESU;
import techreborn.blocks.storage.BlockBatBox;
import techreborn.blocks.storage.BlockIDSU;
import techreborn.blocks.storage.BlockLESU;
import techreborn.blocks.storage.BlockLESUStorage;
import techreborn.blocks.storage.BlockMFE;
import techreborn.blocks.storage.BlockMFSU;
import techreborn.blocks.tier1.BlockAlloySmelter;
import techreborn.blocks.tier1.BlockCompressor;
import techreborn.blocks.tier1.BlockElectricFurnace;
import techreborn.blocks.tier1.BlockExtractor;
import techreborn.blocks.tier1.BlockGrinder;
import techreborn.blocks.tier1.BlockRecycler;
import techreborn.blocks.transformers.BlockHVTransformer;
import techreborn.blocks.transformers.BlockLVTransformer;
import techreborn.blocks.transformers.BlockMVTransformer;
import techreborn.itemblocks.ItemBlockAesu;
import techreborn.itemblocks.ItemBlockDigitalChest;
import techreborn.itemblocks.ItemBlockMachineCasing;
import techreborn.itemblocks.ItemBlockMachineFrame;
import techreborn.itemblocks.ItemBlockOre;
import techreborn.itemblocks.ItemBlockOre2;
import techreborn.itemblocks.ItemBlockPlayerDetector;
import techreborn.itemblocks.ItemBlockQuantumChest;
import techreborn.itemblocks.ItemBlockQuantumTank;
import techreborn.itemblocks.ItemBlockRubberSapling;
import techreborn.itemblocks.ItemBlockStorage;
import techreborn.itemblocks.ItemBlockStorage2;
import techreborn.tiles.*;
import techreborn.tiles.fusionReactor.TileEntityFusionController;
import techreborn.tiles.generator.TileDieselGenerator;
import techreborn.tiles.generator.TileDragonEggSiphoner;
import techreborn.tiles.generator.TileGasTurbine;
import techreborn.tiles.generator.TileGenerator;
import techreborn.tiles.generator.TileSemifluidGenerator;
import techreborn.tiles.generator.TileSolarPanel;
import techreborn.tiles.generator.TileThermalGenerator;
import techreborn.tiles.generator.TileWaterMill;
import techreborn.tiles.generator.TileWindMill;
import techreborn.tiles.idsu.TileIDSU;
import techreborn.tiles.lesu.TileLesu;
import techreborn.tiles.lesu.TileLesuStorage;
import techreborn.tiles.storage.TileBatBox;
import techreborn.tiles.storage.TileMFE;
import techreborn.tiles.storage.TileMFSU;
import techreborn.tiles.teir1.TileCompressor;
import techreborn.tiles.teir1.TileElectricFurnace;
import techreborn.tiles.teir1.TileExtractor;
import techreborn.tiles.teir1.TileGrinder;
import techreborn.tiles.teir1.TileRecycler;
import techreborn.tiles.transformers.TileHVTransformer;
import techreborn.tiles.transformers.TileLVTransformer;
import techreborn.tiles.transformers.TileMVTransformer;

import java.lang.reflect.InvocationTargetException;

public class ModBlocks
{

	//Energy
	//LV
	public static Block chargeBench;
	public static Block lvStorage;
	public static Block lvTransformer;
	//MV
	public static Block mvStorage;
	public static Block mvTransformer;
	//HV
	public static Block hvStorage;
	public static Block hvTransformer;
	//EV
	public static Block evAdjustStorage;
	public static Block evMultiStorage;
	public static Block evMultiBlock;
	public static Block evTransmitterStorage;
	////To be removed
	public static Block Supercondensator;

	///Generators
	//Tier 1
	public static Block dieselGenerator;
	public static Block gasTurbine;
	public static Block generator;
	public static Block semiFluidGenerator;
	public static Block thermalGenerator;
	public static Block solarPanel;
	public static Block waterMill;
	public static Block windMill;
	//Tier 2
	//-
	//Tier 3
	public static Block dragonEggEnergySyphon;
	public static Block fusionReactorComputer;
	public static Block magicEnergyAbsorber;
	public static Block magicEnergyConverter;
	public static Block lightningRod;
	public static Block plasmaGenerator;

	///Machines
	//Tier 0
	public static Block ironFurnace;
	public static Block ironAlloyFurnace;
	//Tier 1
	public static Block alloySmelter;
	public static Block assemblyMachine;
	public static Block chemicalReactor;
	public static Block compressor;
	public static Block electricCraftingTable;
	public static Block electricFurnace;
	public static Block extractor;
	public static Block grinder;
	public static Block industrialElectrolyzer;
	public static Block rollingMachine;
	public static Block pump;
	public static Block recycler;
	public static Block scrapboxinator;
	//Tier 2
	public static Block industrialBlastFurnace;
	public static Block computerCube;
	public static Block distillationTower;
	public static Block centrifuge;
	public static Block digitalChest;
	public static Block implosionCompressor;
	public static Block industrialGrinder;
	public static Block industrialSawmill;
	public static Block playerDetector;
	public static Block vacuumFreezer;
	//Tier 3
	public static Block industrialChunkLoader;
	public static Block matterFabricator;
	public static Block quantumChest;
	public static Block quantumTank;

	//Misc
	public static Block reinforcedGlass;
	public static Block rubberLeaves;
	public static Block rubberLog;
	public static Block rubberPlanks;
	public static Block rubberSapling;
	public static Block storage2;
	public static Block storage;
	public static BlockOre ore;
	public static BlockOre2 ore2;
	public static Block nuke;
	public static Block distributor;

	//Structure
	public static Block fusionCoil;
	public static Block machineCasing;
	public static Block ironFence;
	public static Block machineBlock;

	public static void init()
	{

		///Energy
		//LV
		chargeBench = new BlockChargeBench(Material.ROCK);
		registerBlock(chargeBench, "chargebench");
		GameRegistry.registerTileEntity(TileChargeBench.class, "TileChargeBench");

		lvStorage = new BlockBatBox();
		registerBlock(lvStorage, "lvStorage");
		GameRegistry.registerTileEntity(TileBatBox.class, "TileBatBox");
		Core.proxy.registerCustomBlockStateLocation(lvStorage, "machines/energy/lv_storage");

		lvTransformer = new BlockLVTransformer();
		registerBlock(lvTransformer, "lvTransformer");
		GameRegistry.registerTileEntity(TileLVTransformer.class, "TileLVTransformer");
		Core.proxy.registerCustomBlockStateLocation(lvTransformer, "machines/energy/lv_transformer");
		//MV
		mvStorage = new BlockMFE();
		registerBlock(mvStorage, "mvStorage");
		GameRegistry.registerTileEntity(TileMFE.class, "TileMFE");
		Core.proxy.registerCustomBlockStateLocation(mvStorage, "machines/energy/mv_storage");

		mvTransformer = new BlockMVTransformer();
		registerBlock(mvTransformer, "mvTransformer");
		GameRegistry.registerTileEntity(TileMVTransformer.class, "TileMVTransformer");
		Core.proxy.registerCustomBlockStateLocation(mvTransformer, "machines/energy/mv_transformer");
		//HV
		hvStorage = new BlockMFSU();
		registerBlock(hvStorage, "hvStorage");
		GameRegistry.registerTileEntity(TileMFSU.class, "TileMFSU");
		Core.proxy.registerCustomBlockStateLocation(hvStorage, "machines/energy/hv_storage");

		hvTransformer = new BlockHVTransformer();
		registerBlock(hvTransformer, "hvTransformer");
		GameRegistry.registerTileEntity(TileHVTransformer.class, "TileHVTransformer");
		Core.proxy.registerCustomBlockStateLocation(hvTransformer, "machines/energy/hv_transformer");
		//EV
		evAdjustStorage = new BlockAESU();
		registerBlock(evAdjustStorage, ItemBlockAesu.class, "aesu");
		GameRegistry.registerTileEntity(TileAesu.class, "TileAesuTR");
		Core.proxy.registerCustomBlockStateLocation(evAdjustStorage, "machines/energy/ev_storage_adjust");

		evMultiStorage = new BlockLESU();
		registerBlock(evMultiStorage, "lesu");
		GameRegistry.registerTileEntity(TileLesu.class, "TileLesuTR");
		Core.proxy.registerCustomBlockStateLocation(evMultiStorage, "machines/energy/ev_storage_multi");

		evMultiBlock = new BlockLESUStorage(Material.ROCK);
		registerBlock(evMultiBlock, "lesustorage");
		GameRegistry.registerTileEntity(TileLesuStorage.class, "TileLesuStorageTR");
		Core.proxy.registerCustomBlockStateLocation(evMultiStorage, "machines/energy/ev_storage_multi_storage");

		evTransmitterStorage = new BlockIDSU();
		registerBlock(evTransmitterStorage, "idsu");
		GameRegistry.registerTileEntity(TileIDSU.class, "TileIDSUTR");
		Core.proxy.registerCustomBlockStateLocation(evTransmitterStorage, "machines/energy/ev_storage_transmitter");

		Supercondensator = new BlockSupercondensator(Material.ROCK);
		registerBlock(Supercondensator, "supercondensator");

		//Generators
		//Tier 1
		dieselGenerator = new BlockDieselGenerator(Material.ROCK);
		registerBlock(dieselGenerator, "dieselgenerator");
		GameRegistry.registerTileEntity(TileDieselGenerator.class, "TileDieselGeneratorTR");
		Core.proxy.registerCustomBlockStateLocation(dieselGenerator, "machines/generators/diesel_generator");

		gasTurbine = new BlockGasTurbine(Material.ROCK);
		registerBlock(gasTurbine, "gasturbine");
		GameRegistry.registerTileEntity(TileGasTurbine.class, "TileGassTurbineTR");
		Core.proxy.registerCustomBlockStateLocation(gasTurbine, "machines/generators/gas_turbine");

		generator = new BlockGenerator();
		registerBlock(generator, "techreborn.generator");
		GameRegistry.registerTileEntity(TileGenerator.class, "TileGeneratorTR");
		Core.proxy.registerCustomBlockStateLocation(generator, "machines/generators/generator");

		semiFluidGenerator = new BlockSemiFluidGenerator(Material.ROCK);
		registerBlock(semiFluidGenerator, "semifluidgenerator");
		GameRegistry.registerTileEntity(TileSemifluidGenerator.class, "TileSemifluidGeneratorTR");
		Core.proxy.registerCustomBlockStateLocation(semiFluidGenerator, "machines/generators/semi_fluid_generator");

		thermalGenerator = new BlockThermalGenerator();
		registerBlock(thermalGenerator, "techreborn.thermalGenerator");
		GameRegistry.registerTileEntity(TileThermalGenerator.class, "TileThermalGeneratorTR");
		Core.proxy.registerCustomBlockStateLocation(thermalGenerator, "machines/generators/thermal_generator");

		solarPanel = new BlockSolarPanel();
		registerBlock(solarPanel, "techreborn.solarpanel");
		GameRegistry.registerTileEntity(TileSolarPanel.class, "TileSolarPanel");
		Core.proxy.registerCustomBlockStateLocation(solarPanel, "machines/generators/solar_panel");

		waterMill = new BlockWaterMill();
		registerBlock(waterMill, "techreborn.watermill");
		GameRegistry.registerTileEntity(TileWaterMill.class, "TileWaterMill");
		Core.proxy.registerCustomBlockStateLocation(waterMill, "machines/generators/water_mill");

		windMill = new BlockWindMill();
		registerBlock(windMill, "techreborn.windmill");
		GameRegistry.registerTileEntity(TileWindMill.class, "TileWindMill");
		GameRegistry.registerTileEntity(TileMachineBase.class, "TileMachineBaseTR");
		Core.proxy.registerCustomBlockStateLocation(windMill, "machines/generators/wind_mill");
		//Tier 2
		//-
		//Tier 3
		dragonEggEnergySyphon = new BlockDragonEggSiphoner(Material.ROCK);
		registerBlock(dragonEggEnergySyphon, "dragoneggenergsiphon");
		GameRegistry.registerTileEntity(TileDragonEggSiphoner.class, "TileDragonEggSiphonerTR");
		Core.proxy.registerCustomBlockStateLocation(dragonEggEnergySyphon, "machines/generators/dragon_egg_syphon");

		fusionReactorComputer = new BlockFusionControlComputer(Material.ROCK);
		registerBlock(fusionReactorComputer, "fusioncontrolcomputer");
		GameRegistry.registerTileEntity(TileEntityFusionController.class, "TileEntityFustionControllerTR");

		magicEnergyAbsorber = new BlockMagicEnergyAbsorber(Material.ROCK);
		registerBlock(magicEnergyAbsorber, "magicrnergyabsorber");
		Core.proxy.registerCustomBlockStateLocation(magicEnergyAbsorber, "machines/generators/magic_energy_absorber");

		magicEnergyConverter = new BlockMagicEnergyConverter(Material.ROCK);
		registerBlock(magicEnergyConverter, "magicenergyconverter");
		Core.proxy.registerCustomBlockStateLocation(magicEnergyConverter, "machines/generators/magic_energy_converter");

		lightningRod = new BlockLightningRod(Material.ROCK);
		registerBlock(lightningRod, "lightningrod");
		Core.proxy.registerCustomBlockStateLocation(lightningRod, "machines/generators/lightning_rod");

		plasmaGenerator = new BlockPlasmaGenerator(Material.ROCK);
		registerBlock(plasmaGenerator, "plasmagenerator");
		Core.proxy.registerCustomBlockStateLocation(plasmaGenerator, "machines/generators/plasma_generator");

		///Machines
		//Tier 0
		ironAlloyFurnace = new BlockAlloyFurnace(Material.ROCK);
		registerBlock(ironAlloyFurnace, "alloyfurnace");
		GameRegistry.registerTileEntity(TileAlloyFurnace.class, "TileAlloyFurnaceTR");
		Core.proxy.registerCustomBlockStateLocation(ironAlloyFurnace, "machines/tier0_machines/alloy_furnace");

		ironFurnace = new BlockIronFurnace();
		registerBlock(ironFurnace, "ironfurnace");
		GameRegistry.registerTileEntity(TileIronFurnace.class, "TileIronFurnaceTR");
		Core.proxy.registerCustomBlockStateLocation(hvTransformer, "machines/tier0_machines/furnace");
		//Tier 1
		alloySmelter = new BlockAlloySmelter(Material.ROCK);
		registerBlock(alloySmelter, "alloySmelter");
		GameRegistry.registerTileEntity(TileAlloySmelter.class, "TileAlloySmalterTR");
		Core.proxy.registerCustomBlockStateLocation(alloySmelter, "machines/tier1_machines/electric_alloy_smelter");

		assemblyMachine = new BlockAssemblingMachine(Material.ROCK);
		registerBlock(assemblyMachine, "assemblymachine");
		GameRegistry.registerTileEntity(TileAssemblingMachine.class, "TileAssemblyMachineTR");
		Core.proxy.registerCustomBlockStateLocation(assemblyMachine, "machines/tier1_machines/assembly_machine");

		chemicalReactor = new BlockChemicalReactor(Material.ROCK);
		registerBlock(chemicalReactor, "chemicalreactor");
		GameRegistry.registerTileEntity(TileChemicalReactor.class, "TileChemicalReactorTR");
		Core.proxy.registerCustomBlockStateLocation(chemicalReactor, "machines/tier1_machines/chemical_reactor");

		compressor = new BlockCompressor(Material.IRON);
		registerBlock(compressor, "techreborn.compressor");
		GameRegistry.registerTileEntity(TileCompressor.class, "TileCompressorTR");
		Core.proxy.registerCustomBlockStateLocation(compressor, "machines/tier1_machines/compressor");

		electricCraftingTable = new BlockElectricCraftingTable(Material.ROCK);
		registerBlock(electricCraftingTable, "electriccraftingtable");
		Core.proxy.registerCustomBlockStateLocation(electricCraftingTable, "machines/tier1_machines/electric_crafting_table");

		electricFurnace = new BlockElectricFurnace(Material.IRON);
		registerBlock(electricFurnace, "techreborn.electricfurnace");
		GameRegistry.registerTileEntity(TileElectricFurnace.class, "TileElectricFurnaceTR");
		Core.proxy.registerCustomBlockStateLocation(electricFurnace, "machines/tier1_machines/electric_furnace");

		extractor = new BlockExtractor(Material.IRON);
		registerBlock(extractor, "techreborn.extractor");
		GameRegistry.registerTileEntity(TileExtractor.class, "TileExtractorTR");
		Core.proxy.registerCustomBlockStateLocation(extractor, "machines/tier1_machines/extractor");

		grinder = new BlockGrinder(Material.IRON);
		registerBlock(grinder, "techreborn.grinder");
		GameRegistry.registerTileEntity(TileGrinder.class, "TileGrinderTR");
		Core.proxy.registerCustomBlockStateLocation(grinder, "machines/tier1_machines/grinder");

		industrialElectrolyzer = new BlockIndustrialElectrolyzer(Material.ROCK);
		registerBlock(industrialElectrolyzer, "industrialelectrolyzer");
		GameRegistry.registerTileEntity(TileIndustrialElectrolyzer.class, "TileIndustrialElectrolyzerTR");
		Core.proxy.registerCustomBlockStateLocation(industrialElectrolyzer, "machines/tier1_machines/industrial_electrolyzer");

		rollingMachine = new BlockRollingMachine(Material.ROCK);
		registerBlock(rollingMachine, "rollingmachine");
		GameRegistry.registerTileEntity(TileRollingMachine.class, "TileRollingMachineTR");
		Core.proxy.registerCustomBlockStateLocation(rollingMachine, "machines/tier1_machines/rolling_machine");

		pump = new BlockPump();
		registerBlock(pump, "pump");
		GameRegistry.registerTileEntity(TilePump.class, "TilePump");

		recycler = new BlockRecycler(Material.IRON);
		registerBlock(recycler, "recycler");
		GameRegistry.registerTileEntity(TileRecycler.class, "TileRecyclerTR");
		Core.proxy.registerCustomBlockStateLocation(recycler, "machines/tier1_machines/recycler");

		scrapboxinator = new BlockScrapboxinator(Material.IRON);
		registerBlock(scrapboxinator, "scrapboxinator");
		GameRegistry.registerTileEntity(TileScrapboxinator.class, "TileScrapboxinatorTR");
		Core.proxy.registerCustomBlockStateLocation(scrapboxinator, "machines/tier1_machines/scrapboxinator");
		//Tier 2
		computerCube = new BlockComputerCube(Material.ROCK);
		registerBlock(computerCube, "computercube");
		Core.proxy.registerCustomBlockStateLocation(computerCube, "machines/machines/tier2_machines/computer_cube");

		distillationTower = new BlockDistillationTower(Material.ROCK);
		registerBlock(distillationTower, "distillationtower");
		Core.proxy.registerCustomBlockStateLocation(distillationTower, "machines/tier2_machines/distillation_tower");

		centrifuge = new BlockCentrifuge();
		registerBlock(centrifuge, "techreborn.centrifuge");
		GameRegistry.registerTileEntity(TileCentrifuge.class, "TileCentrifugeTR");
		Core.proxy.registerCustomBlockStateLocation(centrifuge, "machines/tier2_machines/centrifuge");

		digitalChest = new BlockDigitalChest();
		registerBlock(digitalChest, ItemBlockDigitalChest.class, "techreborn.digitalChest");
		GameRegistry.registerTileEntity(TileDigitalChest.class, "TileDigitalChestTR");
		Core.proxy.registerCustomBlockStateLocation(digitalChest, "machines/tier2_machines/digital_chest");

		implosionCompressor = new BlockImplosionCompressor(Material.ROCK);
		registerBlock(implosionCompressor, "implosioncompressor");
		GameRegistry.registerTileEntity(TileImplosionCompressor.class, "TileImplosionCompressorTR");
		Core.proxy.registerCustomBlockStateLocation(implosionCompressor, "machines/tier2_machines/implosion_compressor");

		industrialBlastFurnace = new BlockBlastFurnace(Material.ROCK);
		registerBlock(industrialBlastFurnace, "industrialBlastFurnace");
		GameRegistry.registerTileEntity(TileBlastFurnace.class, "TileBlastFurnaceTR");
		Core.proxy.registerCustomBlockStateLocation(industrialBlastFurnace, "machines/tier2_machines/industrial_blast_furnace");

		industrialGrinder = new BlockIndustrialGrinder(Material.ROCK);
		registerBlock(industrialGrinder, "grinder");
		GameRegistry.registerTileEntity(TileIndustrialGrinder.class, "TileIndustrialGrinderTR");
		Core.proxy.registerCustomBlockStateLocation(industrialGrinder, "machines/tier2_machines/industrial_grinder");

		industrialSawmill = new BlockIndustrialSawmill(Material.ROCK);
		registerBlock(industrialSawmill, "industrialSawmill");
		GameRegistry.registerTileEntity(TileIndustrialSawmill.class, "TileIndustrialSawmillTR");
		Core.proxy.registerCustomBlockStateLocation(industrialSawmill, "machines/tier2_machines/industrial_saw_mill");

		playerDetector = new BlockPlayerDetector();
		registerBlock(playerDetector, ItemBlockPlayerDetector.class, "playerDetector");
		GameRegistry.registerTileEntity(TilePlayerDectector.class, "TilePlayerDectectorTR");

		vacuumFreezer = new BlockVacuumFreezer(Material.ROCK);
		registerBlock(vacuumFreezer, "vacuumfreezer");
		GameRegistry.registerTileEntity(TileVacuumFreezer.class, "TileVacuumFreezerTR");
		Core.proxy.registerCustomBlockStateLocation(vacuumFreezer, "machines/tier2_machines/vacuum_freezer");
		//Tier 3
		industrialChunkLoader = new BlockChunkLoader(Material.ROCK);
		registerBlock(industrialChunkLoader, "chunkloader");
		GameRegistry.registerTileEntity(TileChunkLoader.class, "TileChunkLoaderTR");
		Core.proxy.registerCustomBlockStateLocation(industrialChunkLoader, "machines/tier3_machines/industrial_chunk_loader");

		matterFabricator = new BlockMatterFabricator(Material.ROCK);
		registerBlock(matterFabricator, "matterfabricator");
		GameRegistry.registerTileEntity(TileMatterFabricator.class, "TileMatterFabricatorTR");
		Core.proxy.registerCustomBlockStateLocation(matterFabricator, "machines/tier3_machines/matter_fabricator");

		quantumChest = new BlockQuantumChest();
		registerBlock(quantumChest, ItemBlockQuantumChest.class, "techreborn.quantumChest");
		GameRegistry.registerTileEntity(TileQuantumChest.class, "TileQuantumChestTR");
		Core.proxy.registerCustomBlockStateLocation(quantumChest, "machines/tier3_machines/quantum_chest");

		quantumTank = new BlockQuantumTank();
		registerBlock(quantumTank, ItemBlockQuantumTank.class, "techreborn.quantumTank");
		GameRegistry.registerTileEntity(TileQuantumTank.class, "TileQuantumTankTR");
		Core.proxy.registerCustomBlockStateLocation(quantumTank, "machines/tier3_machines/quantum_tank");

		///Misc
		distributor = new BlockDistributor();
		registerBlock(distributor, "distributor");

		ironFence = new BlockIronFence();
		registerBlock(ironFence, "ironFence");

		nuke = new BlockNuke();
		registerBlock(nuke, "nuke");
		Core.proxy.registerCustomBlockStateLocation(nuke, "nuke");

		ore = new BlockOre(Material.ROCK);
		registerBlock(ore, ItemBlockOre.class, "techreborn.ore");
		Core.proxy.registerCustomBlockStateLocation(ore, "storage/ores");
		for (int i = 0; i < BlockOre.ores.length; i++) {
			Core.proxy.registerSubBlockInventoryLocation(ore, i, "storage/ores", BlockOre.ores[i]);
		}

		ore2 = new BlockOre2(Material.ROCK);
		registerBlock(ore2, ItemBlockOre2.class, "techreborn.ore2");
		Core.proxy.registerCustomBlockStateLocation(ore2, "storage/ores");
		for (int i = 0; i < BlockOre2.ores.length; i++) {
			Core.proxy.registerSubBlockInventoryLocation(ore2, i, "storage/ores", BlockOre2.ores[i]);
		}

		storage = new BlockStorage(Material.IRON);
		registerBlock(storage, ItemBlockStorage.class, "techreborn.storage");
		Core.proxy.registerCustomBlockStateLocation(storage, "storage/storage");
		for (int i = 0; i < BlockStorage.types.length; i++) {
			Core.proxy.registerSubBlockInventoryLocation(storage, i, "storage/storage", BlockStorage.types[i]);
		}

		storage2 = new BlockStorage2(Material.IRON);
		registerBlock(storage2, ItemBlockStorage2.class, "techreborn.storage2");
		Core.proxy.registerCustomBlockStateLocation(storage2, "storage/storage");
		for (int i = 0; i < BlockStorage2.types.length; i++) {
			Core.proxy.registerSubBlockInventoryLocation(storage2, i, "storage/storage", BlockStorage2.types[i]);
		}

		rubberLog = new BlockRubberLog();
		registerBlock(rubberLog, "rubberLog");

		rubberPlanks = new BlockRubberPlank();
		registerBlock(rubberPlanks, "rubberPlanks");

		rubberLeaves = new BlockRubberLeaves();
		registerBlock(rubberLeaves, "rubberLeaves");

		rubberSapling = new BlockRubberSapling();
		registerBlock(rubberSapling, ItemBlockRubberSapling.class, "rubberSapling");

		reinforcedGlass = new BlockReinforcedGlass(Material.GLASS);
		registerBlock(reinforcedGlass, "reinforcedglass");

		///Structure
		fusionCoil = new BlockFusionCoil(Material.ROCK);
		registerBlock(fusionCoil, "fusioncoil");

		machineCasing = new BlockMachineCasing(Material.ROCK);
		registerBlock(machineCasing, ItemBlockMachineCasing.class, "machinecasing");
		GameRegistry.registerTileEntity(TileMachineCasing.class, "TileMachineCasingTR");

		machineBlock = new BlockMachineFrame(Material.IRON);
		registerBlock(machineBlock, ItemBlockMachineFrame.class, "techreborn.machineFrame");

		registerOreDict();
		Core.logHelper.info("TechReborns Blocks Loaded");
	}

	public static void registerBlock(Block block, String name){
		block.setRegistryName(name);
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block), block.getRegistryName());
	}

	public static void registerBlock(Block block, Class<? extends ItemBlock> itemclass, String name){
		block.setRegistryName(name);
		GameRegistry.register(block);
		try {
			ItemBlock itemBlock = itemclass.getConstructor(Block.class).newInstance(block);
			itemBlock.setRegistryName(name);
			GameRegistry.register(itemBlock);
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	public static void registerOreDict()
	{
		for(String ore : BlockOre.ores){
			OreDictionary.registerOre("ore" + StringUtils.toFirstCapital(ore), BlockOre.getOreByName(ore));
		}

		for(String ore : BlockOre2.ores){
			OreDictionary.registerOre("ore" + StringUtils.toFirstCapital(ore), BlockOre2.getOreByName(ore));
		}

		for(String name : ArrayUtils.addAll(BlockStorage.types, BlockStorage2.types)){
			OreDictionary.registerOre("block" + StringUtils.toFirstCapital(name), BlockStorage.getStorageBlockByName(name));
		}

		OreDictionary.registerOre("craftingPiston", Blocks.PISTON);
		OreDictionary.registerOre("craftingPiston", Blocks.STICKY_PISTON);
		OreDictionary.registerOre("crafterWood", Blocks.CRAFTING_TABLE);
		OreDictionary.registerOre("machineBasic", new ItemStack(machineBlock, 1));

		OreDictionary.registerOre("treeSapling", rubberSapling);
		OreDictionary.registerOre("saplingRubber", rubberSapling);
		OreDictionary.registerOre("logWood", new ItemStack(rubberLog, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("logRubber", new ItemStack(rubberLog, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("plankWood", new ItemStack(rubberPlanks, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("plankRubber", new ItemStack(rubberPlanks, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("treeLeaves", new ItemStack(rubberLeaves, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("leavesRubber", new ItemStack(rubberLeaves, 1, OreDictionary.WILDCARD_VALUE));

		OreDictionary.registerOre("fenceIron", ironFence);
		
		OreDictionary.registerOre("machineBlockBasic", BlockMachineFrame.getFrameByName("machine", 1));
		OreDictionary.registerOre("machineBlockAdvanced", BlockMachineFrame.getFrameByName("advancedMachine", 1));
		OreDictionary.registerOre("machineBlockHighlyAdvanced", BlockMachineFrame.getFrameByName("highlyAdvancedMachine", 1));
	}

}
