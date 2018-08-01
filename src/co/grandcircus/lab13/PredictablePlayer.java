package co.grandcircus.lab13;

public class PredictablePlayer extends Player {
	
	public PredictablePlayer(String name) {
		super(name);
	}
	
	public PredictablePlayer() {
		super();
	}

	public Roshambo generateRoshambo() {
		return Roshambo.ROCK;
	}
	
	

}
