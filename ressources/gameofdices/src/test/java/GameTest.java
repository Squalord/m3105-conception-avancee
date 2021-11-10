
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.Optional;

public class GameTest {

    Game game;

    @Test
    public void andTheWinnerIs() {

        Player player1 = mock(Player.class);
        when(player1.getLastValue()).thenReturn(Optional.of(new Integer(5)));

        Player player2 = mock(Player.class);
        when(player2.getLastValue()).thenReturn(Optional.of(new Integer(2)));

        game = new Game(player1, player2);
        assertEquals(player1, game.play().get());
    }


    @Test
    public void noWinnerAfter5Attempts() {
        Dice single = mock(Dice.class);
        when(single.roll()).thenReturn(1);

        Player player1 =  spy(new Player("John", single));
        Player player2 =  spy(new Player("Jane", single));

        game = new Game(player1,player2);
        assertFalse(game.play().isPresent());
        verify(player1, times(5)).play();
        verify(player2, times(5)).play();
    }


}

