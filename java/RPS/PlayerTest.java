package gameActivity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        resetScore();
        player = new Player("Arjun");

    }

    private void resetScore() {
        try {
            java.lang.reflect.Field field = Player.class.getDeclaredField("score");
            field.setAccessible(true);
            field.set(null, 0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testConstructor() {
        assertEquals("Arjun", player.getName());
    }

    @Test
    void testSetAndGetChoice() {
        player.setChoice("Rock");
        assertEquals("Rock", player.getChoice());
    }

    @Test
    void testInitialScoreIsZero() {
        assertEquals(0, player.getScore());
    }

    @Test
    void testIncreaseScore() {
        player.increaseScore();
        assertEquals(1, player.getScore());

        player.increaseScore();
        assertEquals(2, player.getScore());
    }
}