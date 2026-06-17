package gameActivity;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

class GameTest {
    private Game game;
    private Player player;
    private Computer computer;

    @BeforeEach
    void setUp() {
        game = new Game();
        player = new Player("TestPlayer");
        computer = new Computer();
        resetScores();
    }

    private void resetScores() {
        try {
            Field playerScore = Player.class.getDeclaredField("score");
            playerScore.setAccessible(true);
            playerScore.set(null, 0);

            Field computerScore = Computer.class.getDeclaredField("score");
            computerScore.setAccessible(true);
            computerScore.set(null, 0);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Test
    void testDraw_RockVsRock() throws InterruptedException{
        player.setChoice("Rock");
        computer.choice = "Rock";
        game.playRound(player, computer);
        assertEquals(0, player.getScore());
        assertEquals(0, computer.getScore());
    }

    @Test
    void testDraw_PaperVsPaper() throws InterruptedException{
        player.setChoice("Paper");
        computer.choice = "Paper";
        game.playRound(player, computer);
        assertEquals(0, player.getScore());
        assertEquals(0, computer.getScore());
    }

    @Test
    void testDraw_ScissorsVsScissors() throws InterruptedException{
        player.setChoice("Scissors");
        computer.choice = "Scissors";
        game.playRound(player, computer);
        assertEquals(0, player.getScore());
        assertEquals(0, computer.getScore());
    }
    
    @Test
    void testPlayerWins_RockVsScissors() throws InterruptedException {
        player.setChoice("Rock");
        computer.choice = "Scissors";
        game.playRound(player, computer);
        assertEquals(1, player.getScore());
        assertEquals(0, computer.getScore());
    }

    @Test
    void testPlayerWins_PaperVsRock() throws InterruptedException{
        player.setChoice("Paper");
        computer.choice = "Rock";
        game.playRound(player, computer);
        assertEquals(1, player.getScore());
        assertEquals(0, computer.getScore());
    }

    @Test
    void testPlayerWins_ScissorsVsPaper() throws InterruptedException{
        player.setChoice("Scissors");
        computer.choice = "Paper";
        game.playRound(player, computer);
        assertEquals(1, player.getScore());
        assertEquals(0, computer.getScore());
    }

    @Test
    void testComputerWins_RockVsPaper() throws InterruptedException{
        player.setChoice("Rock");
        computer.choice = "Paper";
        game.playRound(player, computer);
        assertEquals(0, player.getScore());
        assertEquals(1, computer.getScore());
    }

    @Test
    void testComputerWins_PaperVsScissors() throws InterruptedException{
        player.setChoice("Paper");
        computer.choice = "Scissors";
        game.playRound(player, computer);
        assertEquals(0, player.getScore());
        assertEquals(1, computer.getScore());
    }

    @Test
    void testComputerWins_ScissorsVsRock() throws InterruptedException{
        player.setChoice("Scissors");
        computer.choice = "Rock";
        game.playRound(player, computer);
        assertEquals(0, player.getScore());
        assertEquals(1, computer.getScore());
    }
}