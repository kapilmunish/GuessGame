package com.collegeboard.interview.guessgame;

import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

/**
 * Guess Game class Initialized lower, upper and median values to start with
 * 
 * @author kmunish
 *
 */
public class GuessGame implements Game {
	Random generator = new Random();
	int guessLower = 0;
	int guessUpper = 1000;
	int myGuess = (guessLower + guessUpper) / 2;

	/**
	 * The main method to invoke the Guess Game program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GuessGame gg = new GuessGame();
		gg.guessUserNumber();
	}

	/**
	 * Guess Number method for handling various scenarios
	 */
	public void guessUserNumber() {
		Scanner scan = new Scanner(System.in);
		int answer = myGuess;
		String guess;
		String another = "y";
		boolean flag = false;
		boolean anotherFlag = true;
		
		System.out
		.println("Welcome to the guess game, kindly provide input to start: ");
		
		guess = scan.next();

		if (StringUtils.equalsIgnoreCase(guess, "ready")) {
			while (anotherFlag) {

				System.out.println("Is the number # " + answer);
				flag = false;
				while (!flag) {

					if(guessLower == guessUpper){
						System.out.println("I guess the number is " + myGuess + "but you're trying to fool us :)");
					}
					
					guess = scan.next();
					if (StringUtils.equalsIgnoreCase(guess, "yes")
							|| StringUtils.equalsIgnoreCase(guess, "end")) {
						System.out.println("you guessed correctly!!");
						flag = true;
					} else if (StringUtils.equalsIgnoreCase(guess, "higher")) {
						answer = higher();
						System.out.println("Is the number " + answer);
						flag = false;
					} else if (StringUtils.equalsIgnoreCase(guess, "lower")) {
						answer = lower();
						System.out.println("Is the number " + answer);
						flag = false;
					} else {
						System.out.println("Incorrect input " + guess
								+ " kindly enter lower/higher/yes/end");
					}
				}// end inner while

				System.out.println();
				System.out.println("would you like to play again?(y/n)");
				another = scan.next();
				if (another.equalsIgnoreCase("y")) {
					answer = startover();
					anotherFlag = true;
				} else {
					anotherFlag = false;
				}
			}// end outer while
		} else {
			System.out.println("Invalid input, re-run program to start over again");
		}
	}

	/**
	 * @return starting over again once the number is guessed successfully
	 */
	public int startover() {
		guessLower = 0;
		guessUpper = 1000;
		// myGuess=(generator.nextInt(10) + 1) * 10;
		myGuess = (guessLower + guessUpper) / 2;
		return myGuess;
	}

	/**
	 * @return lower number to guess
	 */
	public int lower() {
		guessUpper = myGuess;
		myGuess = (myGuess + guessLower) / 2;
		return myGuess;
	}

	/**
	 * @return hugher number to guess
	 */
	public int higher() {
		guessLower = myGuess;
		myGuess = (myGuess + guessUpper) / 2;
		return myGuess;
	}

	public int getGuessLower() {
		return guessLower;
	}

	public void setGuessLower(int guessLower) {
		this.guessLower = guessLower;
	}

	public int getGuessUpper() {
		return guessUpper;
	}

	public void setGuessUpper(int guessUpper) {
		this.guessUpper = guessUpper;
	}

	public int getMyGuess() {
		return myGuess;
	}

	public void setMyGuess(int myGuess) {
		this.myGuess = myGuess;
	}

}