package techreborn.world;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by Mark on 19/02/2016.
 */
public class TreeGenerator implements IWorldGenerator {

    RubberTreeGenerator treeGenerator = new RubberTreeGenerator(false, 6, Blocks.log.getDefaultState(), Blocks.leaves.getDefaultState(), false);


    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        int chance = 0;
        BiomeGenBase biomeGenBase = world.getBiomeGenForCoords( new BlockPos(chunkX * 16 + 16, 72, chunkZ * 16 + 16));
        if(BiomeDictionary.isBiomeOfType(biomeGenBase, BiomeDictionary.Type.SWAMP)){
            chance += random.nextInt(10) + 5;
        }
        if(BiomeDictionary.isBiomeOfType(biomeGenBase, BiomeDictionary.Type.FOREST) || BiomeDictionary.isBiomeOfType(biomeGenBase, BiomeDictionary.Type.JUNGLE)){
            chance += random.nextInt(5) + 1;
        }
        if(world.provider.isSurfaceWorld()){
            if(random.nextInt(100) + 1 <= chance * 2){


                treeGenerator.generate(world, random, new BlockPos(chunkX * 16 + random.nextInt(16), 72, chunkZ * 16 + random.nextInt(16)));
            }

        }
    }
}
