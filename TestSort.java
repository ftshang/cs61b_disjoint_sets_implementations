import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {

    @Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};

        Sort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    public void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;

        int actual = Sort.findSmallest(input, 0);

        assertEquals(expected, actual);

        String[] input2 = {"awesome", "cool", "swag", "cereal"};
        int expected2 = 3;

        int actual2 = Sort.findSmallest(input2, 1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String[] expected = {"an", "have", "i", "egg"};

        Sort.swap(input, a, b);

        assertArrayEquals(expected, input);
    }
}
