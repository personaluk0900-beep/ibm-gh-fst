package gameActivity;

import java.util.Random;

class Computer{
	public String choice;
	public static int score=0;
	public Random random = new Random();
	
	
	public void generateChoice() {
		int value=random.nextInt(3)+1;// check
		
		
		switch(value) {
		case 1:
			choice="Rock";
			break;
		case 2:
			choice="Paper";
			break;
		case 3:
			choice="Scissors";
			break;
	
		}
		
	}
	public String getChoice() {
		return choice;
	}
	public void increaseScore() {
        score++;
    }
	public int getScore() {
        return score;
    }
}