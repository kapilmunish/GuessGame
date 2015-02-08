package com.collegeboard.interview.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.collegeboard.interview.guessgame.GuessGame;


public class GameTest {
	
	private Random r = new Random();
	private GuessGame game;
	
    @Before
    public void setup() {
    	game = new GuessGame();
    	
    }
    
//    
//    public void testGuess(int numToGuess){
//    	int log2OfMax = 10;    	
//    	boolean found = false;
//		int guess = game.start();
//    	for(int i=0; i < log2OfMax; i++){
//    		
//    	}
//    	if(!found){
//    		fail("Shoudn't take more than "+  log2OfMax +" iterations");
//    	}
//    }

	
	/**
	 * Test to check if the guess is 142
	 */
	//@Test
	public void testHigher(){
		//game.start();
		//assertEquals(game.start(), 50);
		game.setMyGuess(10);
		assertEquals(game.higher(), 505);
		assertEquals(game.lower(), 257);
		assertEquals(game.lower(), 133);
		assertEquals(game.higher(), 195);
		assertEquals(game.lower(), 164);
		assertEquals(game.lower(), 148);
		assertEquals(game.lower(), 140);
		assertEquals(game.higher(), 144);
		assertEquals(game.lower(), 142);
	}

	/**
	 * Test to check if guess was 111
	 */
	@Test
	public void testLiar(){
		assertEquals(game.start(), 500);
		assertEquals(game.lower(), 250);
		assertEquals(game.lower(), 125);
		assertEquals(game.lower(), 62);
		assertEquals(game.higher(), 93);
		assertEquals(game.higher(), 109);
		assertEquals(game.higher(), 117);
		assertEquals(game.lower(), 113);
		assertEquals(game.lower(), 111);
		game.higher();
	}


}
