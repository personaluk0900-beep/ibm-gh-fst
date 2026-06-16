package gameActivity;

class Game{

    public void playRound(Player player, Computer computer) throws InterruptedException{
        String p=player.getChoice();
        String c=computer.getChoice();
        
        System.out.println("Computer choice: "+c);
        System.out.println();
        Thread.sleep(1000);
        if (p.equals(c)){
            System.out.println("Result: Draw");
        }
        else if((p.equals("Rock") && c.equals("Scissors"))||(p.equals("Paper") && c.equals("Rock"))||(p.equals("Scissors") && c.equals("Paper"))){
            System.out.println("Result: Player wins");
            player.increaseScore();
        }
        else{
            System.out.println("Result: Computer wins");
            computer.increaseScore();
        }
    }
}