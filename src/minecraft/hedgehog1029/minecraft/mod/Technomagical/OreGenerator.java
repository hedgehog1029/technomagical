package hedgehog1029.minecraft.mod.Technomagical;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import hedgehog1029.minecraft.mod.Technomagical.Technomagical;


public class OreGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case -1:
		    generateNether(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 0:
		    generateSurface(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 1:
		    generateEnd(world, random, chunkX * 16, chunkZ * 16);
		    break;
		}
	}

	private void generateEnd(World world, Random random, int i, int j) {
	}

	private void generateSurface(World world, Random random, int i, int j) {
		for(int k = 0; k < 10; k++) {
			int magicOreXCoord = i + random.nextInt(16);
			int magicOreYCoord = random.nextInt(256);
			int magicOreZCoord = j + random.nextInt(16);
			//System.out.println("Generating Ore at x:"+magicOreXCoord+" z:"+magicOreZCoord);
			(new WorldGenMinable(Technomagical.magicOre.blockID, 12)).generate(world, random, magicOreXCoord, magicOreZCoord, magicOreYCoord);
		}
	}

	private void generateNether(World world, Random random, int i, int j) {
	}

}
