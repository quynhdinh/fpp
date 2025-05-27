import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Prog2_8Test {
    @Test
    public void testMin() {
        int[] input = {2, -21, 3, 45, 0, 12, 18, 6, 3, 1, 0, -22};
        int expectedMin = -22;
        int actualMin = Prog8.min(input);
        assertEquals(expectedMin, actualMin);
    }
}