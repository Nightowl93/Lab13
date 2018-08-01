package co.grandcircus.lab13;

import java.util.Scanner;

public class HumanPlayer extends Player {
	Scanner scnr = new Scanner(System.in);
	
	public HumanPlayer(String name) {
		super(name);
	}
	
	@Override
	public Roshambo generateRoshambo() {
		String prompt = "Rock, paper, or scissors (R/P/S)?";
		String choice = Validator.getStringMatchingRegex(scnr, prompt, "^rock$|^paper$|^scissors$|^r$|^p$|^s$", false);
		
		switch(choice.toLowerCase()) {
		case "rock":
		case "r":
			return Roshambo.ROCK;
		case "paper":
		case "p":
			return Roshambo.PAPER;
		case "scissors":
		case "s":
			return Roshambo.SCISSORS;
		default:
			return null;
		}
	}
	
	
	}


