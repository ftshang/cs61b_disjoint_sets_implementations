import org.junit.Test;
import static org.junit.Assert.*;

public class QuickFindTest {

    @Test
    public void testInstantiation() {
        QuickFind quickFind = new QuickFind(25);
        for (int i = 0; i < quickFind.id.length; i += 1) {
            int actual = quickFind.id[i];
            assertEquals(i, actual);
        }

        quickFind = new QuickFind(100);
        for (int i = 0; i < quickFind.id.length; i += 1) {
            int actual = quickFind.id[i];
            assertEquals(i, actual);
        }
    }

    @Test
    public void testConnect() {
        QuickFind quickFind = new QuickFind(10);

        quickFind.connect(0, 1);
        int[] expected = {0, 0, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, quickFind.id);

        quickFind.connect(5, 0);
        expected = new int[]{5, 5, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, quickFind.id);

        quickFind.connect(9, 1);
        expected = new int[]{9, 9, 2, 3, 4, 9, 6, 7, 8, 9};
        assertArrayEquals(expected, quickFind.id);

        quickFind.connect(0, 3);
        expected = new int[]{9, 9, 2, 9, 4, 9, 6, 7, 8, 9};
        assertArrayEquals(expected, quickFind.id);
    }

    @Test
    public void testIsConnected() {
        QuickFind quickFind = new QuickFind(15);

        boolean result = quickFind.isConnected(0, 1);
        assertFalse(result);

        quickFind.connect(0, 1);
        result = quickFind.isConnected(0, 1);
        assertTrue(result);

        result = quickFind.isConnected(3, 0);
        assertFalse(result);

        quickFind.connect(0, 3);
        result = quickFind.isConnected(0, 3);
        assertTrue(result);

        result = quickFind.isConnected(9, 3);
        assertFalse(result);

        quickFind.connect(3, 9);
        result = quickFind.isConnected(3, 9);
        assertTrue(result);

        result = quickFind.isConnected(4, 5);
        assertFalse(result);
        quickFind.connect(4, 5);
        result = quickFind.isConnected(4, 5);
        assertTrue(result);

        result = quickFind.isConnected(9, 4);
        assertFalse(result);

        quickFind.connect(4, 9);

        result = quickFind.isConnected(0, 5);
        assertTrue(result);
    }
}
