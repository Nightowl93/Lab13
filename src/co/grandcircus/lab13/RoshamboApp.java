/*Shontinique Uqdah
 * July 31, 2018
 */
package co.grandcircus.lab13;

import java.util.Scanner;

public class RoshamboApp {

	public static void main(String[] args) {
		
		//Declares variables
		Scanner scnr = new Scanner(System.in);
		
		String userName;
		String challengePrompt;
		String userChoice;
		String opponent;
		
		String goAgain;
		boolean rematch;
		int matchNum;
		
		Roshambo userPlay;
		Roshambo challengePlay;
		Player computer;
		
		String winner;
		int wins;
		int losses;
		
		String restart;
		boolean newTournament;
		
		//Greet player and get name
		userName = greetPlayer(scnr);
		
		//Create and name Players
		PredictablePlayer computer1 = new PredictablePlayer("TheJoker");
		RandomPlayer computer2 = new RandomPlayer("TheGamble");
		Player human = new HumanPlayer(userName);
		
		do {
			// sets or resets all my starting values for new tournament
			matchNum = 1;
			rematch = true;
			newTournament = true;
			wins = 0;
			losses = 0;
			
			
		//Decide who user wants to challenge
		challengePrompt = "Would you like to play against " + computer1.getName() + " or " + computer2.getName() + "? (J/G): ";
		userChoice = Validator.getStringMatchingRegex(scnr, challengePrompt, "^J$|^G$", false);
		System.out.println();
		
		//Identify opponent 
		if (userChoice.equalsIgnoreCase("J")) {
			opponent = computer1.getName();
			computer = computer1;
			}
		else {
			opponent = computer2.getName();
			computer = computer2;
		}
		
		//Start rounds
		do {
			//Generate roshambo for opponent
			if (computer == computer1) {
				challengePlay = computer1.generateRoshambo();
			}
			else {
				challengePlay = computer2.generateRoshambo();
			}
			System.out.println("Round " + matchNum + ": ");
			
			//Generate Roshambo for human player
			userPlay = human.generateRoshambo();
			System.out.println();
			
			//Show player choices
			System.out.println(opponent + ": " + challengePlay);
			System.out.println(userName + ": " + userPlay);
			
			//Print winner
			winner = getWinner(challengePlay, userPlay, opponent, userName);
			System.out.println(winner);
			System.out.println();
			
			//Increment match count
			matchNum++;
			
			//Tally and Print results of battle (wins and losses)
			if (winner.contains("LOSE")) {
				losses++;
			}
			else if (!winner.contains("tie")) {
				wins++;
			}
			
			printStats(wins, losses);
			System.out.println();
			
			//Prompt user to play again
			goAgain = Validator.getStringMatchingRegex(scnr, "Would you like a rematch? (y/n)", "^y$|^n$|^yes$|^no$", false);
			System.out.println();
			
			//If user wishes to continue, continues with the same opponent and score stats
			if (goAgain.toLowerCase().startsWith("y")) {
				rematch = true;
			}
			
			//If user wishes to stop, says goodbye and exits this battle
			else {
				rematch = false;
				
				if (wins > losses) {
					System.out.println("Thanks for playing " + userName + "! You are the ULTIMATE CHAMPION!!");
				}
				
				else if (wins == losses) {
					System.out.println("Thanks for playing " + userName + "! Wow, tough tournament! You tied!");
				}
				else {
					System.out.println("Thanks for playing " + userName + "! Better luck next time!");
				}
			}

		}
		//continue rounds until user wishes to quit
		while (rematch);
		
		
		System.out.println();
		
		//Prompts user to start a new tournament
		restart = Validator.getStringMatchingRegex(scnr, "Would you like to challenge an opponent to a new tournament? (y/n)", "^y$|^n$|^yes$|^no$", false);
		
		if (restart.toLowerCase().startsWith("y")) {
			newTournament = true;
			System.out.println("AWESOME!");
		}
		
		else {
			newTournament = false;
			System.out.println("Goodbye " + userName + "! Thank you for playing!");
		}
		}
		while (newTournament);
		
		
	}
	



	public static void printStats(int wins, int losses) {
		String format = "%-15s %-15s";
		System.out.printf(format, "WINS", "LOSSES");
		System.out.println();
		System.out.printf(format, wins, losses);
		System.out.println();
	}


	public static String greetPlayer(Scanner scnr) {
		String userName;
		String namePrompt = "Please enter your name: ";
		
		System.out.println("Welcome to the ULTIMATE Rock, Paper, Scissors Tournament!");
		userName = Validator.getString(scnr, namePrompt);
		
		return userName;
	}

	public static String getWinner(Roshambo challengePlay, Roshambo userPlay, String opponent, String userName) {
		switch (userPlay) {
		case ROCK:
			if (challengePlay == Roshambo.ROCK) {
				return "It's a tie!";
			}
			else if (challengePlay == Roshambo.PAPER) {
				return opponent + " WINS! Sorry " + userName + ", you LOSE.";
			}
			else {
				return userName + " WINS! Gooooo " + userName + "!";
			}
		case PAPER:
			if (challengePlay == Roshambo.PAPER) {
				return "It's a tie!";
			}
			else if (challengePlay == Roshambo.SCISSORS) {
				return opponent + " WINS! Sorry " + userName + ", you LOSE.";
			}
			else {
				return userName + " WINS! Good job " + userName + "!";
			}
		case SCISSORS:
			if (challengePlay == Roshambo.SCISSORS) {
				return "It's a tie!";
			}
			else if (challengePlay == Roshambo.ROCK) {
				return opponent + " WINS! Sorry " + userName + ", you LOSE.";
			}
			else {
				return userName + " WINS! Good job " + userName + "!";
			}
		default:
			return null;
		}
	}
}
