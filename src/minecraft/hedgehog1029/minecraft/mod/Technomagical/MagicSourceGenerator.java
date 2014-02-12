package hedgehog1029.minecraft.mod.Technomagical;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenShrub;
import cpw.mods.fml.common.IWorldGenerator;

public class MagicSourceGenerator implements IWorldGenerator {

	public MagicSourceGenerator() {
		//STUB
	}

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
		// TODO Auto-generated method stub
		
	}

	private void generateSurface(World world, Random random, int i, int j) {
		int randPosY = 0;
		for (int randY = 0; randY < 70; randY++) {
			if (world.getBlockId(i,randY,j) == Block.grass.blockID) {
				randPosY = randY + 1;
				break;
			}
		}
		
		world.setBlock(i + random.nextInt(16), randPosY, j + random.nextInt(16), Technomagical.blockMagicSource.blockID);
	}

	private void generateNether(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub
		
	}

}
