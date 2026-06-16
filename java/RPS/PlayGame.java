package gameActivity;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

import org.apache.commons.io.FileUtils;

public class PlayGame {
	
public static void main(String[] args) throws InterruptedException, IOException {
	Scanner sc=new Scanner(System.in);
	
	Player player=new Player("Team2");
	Computer comp=new Computer();
	Game g1=new Game();
	
	
	System.out.println("==================================");
	System.out.println(" ROCK PAPER SCISSORS GAME ");
	System.out.println("==================================");
	System.out.println("Rules:");
	System.out.println("1. Choose Rock, Paper, or Scissors.");
	System.out.println("2. Rock beats Scissors.");
	System.out.println("3. Scissors beats Paper.");
	System.out.println("4. Paper beats Rock.");
	System.out.println("4. Press any key to start the game.");
	System.out.println();
	sc.nextLine();
	String inputs[]= {"Rock","Paper","Scissors"};
	
	boolean flag=true;
	while(flag) {
	try {
	System.out.println("Choose 1-Rock, 2-Paper, 3-Scissors");
	int input=sc.nextInt();
	
	//Validating Input
	if(input<=0||input>3)
		throw new IncorrectInputException("Exception Occured, Incorrect input.");
	
	player.setChoice(inputs[input-1]);
	comp.generateChoice();
	System.out.println();
	System.out.println("Player Choice: "+player.getChoice());
	System.out.println("Wait... Computer is choosing randomly");
	Thread.sleep(2000);
	//Input validated
	}
	catch(IncorrectInputException e) {
		System.out.println(e.getMessage());
		continue;
	}
	
	g1.playRound(player, comp);
	
	System.out.println("Player Score: "+player.getScore());
	System.out.println("Computer Score: "+comp.getScore());
	
	Thread.sleep(3000);
	
	System.out.println();
	System.out.println("Play another round\n1-YES \nor \n2-NO");
	int ch=sc.nextInt();
	try {
	switch(ch) {
	case 1:continue;
	case 2:flag=false;
			break;
	default: throw new IncorrectInputException("Exception Occured, Incorrect input.\nGame Ended.");
		
	}
	}
	catch(IncorrectInputException e) {
		System.out.println(e.getMessage());
		System.exit(0);
	}

	
	}//end of while loop
	System.out.println();
	String content = "Final Score:\nPlayer Score:\t"+player.getScore()+"\nComputer Score:\t"+comp.getScore();
	System.out.println(content);

	
	   File file = FileUtils.getFile("C:\\Users\\ArjunJagwani\\eclipse-workspace\\gh-fst-java\\fst\\src\\main\\java\\gameActivity\\result.txt");
       
       
      
       FileUtils.writeStringToFile(file, content +'\n',Charset.defaultCharset(),true);
       System.out.println("File Saved at path: "+file.getAbsolutePath());
	
}
}
