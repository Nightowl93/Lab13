package co.grandcircus.lab13;

import java.util.Random;

public class RandomPlayer extends Player {
	private static Random random = new Random();
		
	public RandomPlayer(String name) {
			super(name);
		}
		
	public RandomPlayer() {
			super();
		}

	
	public static Random getRandom() {
		return random;
	}

	public static void setRandom(Random random) {
		RandomPlayer.random = random;
	}

	@Override
	public Roshambo generateRoshambo() {
		int index = getRandom().nextInt(Roshambo.values().length);
		return Roshambo.values()[index];
		
		}
}
