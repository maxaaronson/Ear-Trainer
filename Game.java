package com.amset.eartrainer;

import java.util.Random;

public class Game {
	
	public int total;
	public int score;
	public String correctAnswer;
	public String guess;
	public String difficulty;
	public int randomInt;
	public Random random = new Random();
	
	
	public Game(){
	
		//total = 0;
		//score = 0;
		
		
	}
	
	public String displayScore(){
		String output = Integer.toString(score)+ "/" + Integer.toString(total);
		return output;
	}
	
	public boolean isCorrect(){
		if (guess == correctAnswer){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void updateScore(boolean correct){
		total += 1;
		if (correct == true){
			score += 1;
		}
	}

}
