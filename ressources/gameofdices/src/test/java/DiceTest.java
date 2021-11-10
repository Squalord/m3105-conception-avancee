import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiceTest {

    Dice theDice;

    @Test
    public void rollReturnsAValue() {
        theDice = new Dice(new Random());
        for (int i = 0; i < 100; i++) {
            int result = theDice.roll();
            assertTrue(result >= 1);
            assertTrue(result <= 6);
        }
    }

    @Test(expected = RuntimeException.class)
    public void identifyBadValuesGreaterThanNumberOfFaces() {
        Random badValue = mock(Random.class);
        when(badValue.nextInt(anyInt())).thenReturn(7);
        theDice = new Dice(badValue);
        int result = theDice.roll();
        System.out.println(result);
    }

    @Test(expected = RuntimeException.class)
    public void identifyBadValuesLesserThanOne() {
        Random badValue = mock(Random.class);
        when(badValue.nextInt(anyInt())).thenReturn(-1);
        theDice = new Dice(badValue);
        theDice.roll();
    }


}
