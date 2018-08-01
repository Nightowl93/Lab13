package co.grandcircus.lab13;

public abstract class Player {
	private String name;

	public Player(String name) {
		this.name = name;
	}
	
	public Player() {
		
	}
	public abstract Roshambo generateRoshambo();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
