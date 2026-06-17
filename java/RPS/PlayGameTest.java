package gameActivity;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class PlayGameTest {

    @Test
    void testUserChoosesRock() {

        String input ="\n" + "1\n" + "2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertDoesNotThrow(() -> PlayGame.main(new String[]{}));
    }

    @Test
    void testUserChoosesPaper() {
        String input ="\n" +"2\n" +"2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertDoesNotThrow(() -> PlayGame.main(new String[]{}));
    }

    @Test
    void testUserChoosesScissors() {
        String input ="\n" +"3\n" + "2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertDoesNotThrow(() -> PlayGame.main(new String[]{}));
    }
    
    @Test
    void testInvalidTextInput() {

        String input = "\n" + "abc\n" + "1\n" + "2\n";
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(output));
        try {
            PlayGame.main(new String[]{});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String console = output.toString();
        assertTrue(console.contains( "Invalid input! Please enter only numbers (1, 2, or 3)." ));
    }

}