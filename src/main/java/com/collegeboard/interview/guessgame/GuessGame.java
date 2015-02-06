package com.collegeboard.interview.guessgame;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;


public class GuessGame implements Game{
	 Random generator = new Random();
	 int guessLower=0;
	 int guessUpper=1000;
	 //int myGuess=(generator.nextInt(10) + 1) * 10;
	 int myGuess=(guessLower + guessUpper)/2;

	public static void main(String[] args) {
		GuessGame gg = new GuessGame();
		gg.guessUserNumber();
	}

	/**
	 * 
	 */
	public void guessUserNumber() {
		Scanner scan = new Scanner(System.in);
		int answer = myGuess;
		String guess;
		String another = "y";
		boolean flag = false;
		boolean anotherFlag = true;

		guess = scan.next();

		if(StringUtils.equalsIgnoreCase(guess, "ready")){
			while(anotherFlag){
				
				System.out.println("Is the number # "+answer);
				flag = false;
				while(!flag){
					
					guess = scan.next();
					if(StringUtils.equalsIgnoreCase(guess, "yes") || StringUtils.equalsIgnoreCase(guess, "end")){
						System.out.println("you guessed correctly!!");
						flag = true;
					}else if(StringUtils.equalsIgnoreCase(guess, "h")){
						answer = higher();
						System.out.println("Is the number "+answer);
						flag = false;
					}else if(StringUtils.equalsIgnoreCase(guess, "l")){
						answer = lower();
						System.out.println("Is the number "+answer);
						flag = false;
					}else{
						System.out.println("Incorrect input "+ guess + " kindly enter l/h/yes/end");
					}
				}//end inner while
				
				System.out.println();
				System.out.println("would you like to play again?(y/n)");
				another = scan.next();
				if(another.equalsIgnoreCase("y")){
					answer = start();
					anotherFlag = true;
				}else{
					anotherFlag = false;
				}
			}//end outer while			
		}
	}

	/**
	 * @return
	 */
	public int start() {
		guessLower=0;
		guessUpper=1000;
		//myGuess=(generator.nextInt(10) + 1) * 10;
		myGuess=(guessLower + guessUpper)/2;
		return myGuess;
	}

	/**
	 * @return
	 */
	public int lower() {
		guessUpper = myGuess;
		myGuess = (myGuess + guessLower)/2;
		return myGuess;
	}

	/**
	 * @return
	 */
	public int higher() {
		guessLower = myGuess;
		myGuess = (myGuess + guessUpper)/2;
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