import org.junit.Test;
import static org.junit.Assert.*;

public class QuickUnionTest {

    @Test
    public void testFind() {
        int[] input = {-1, 0, 1, 0, 0, 3, -1};
        QuickUnion q = new QuickUnion(input);

        int expected = 0;
        int actual = q.find(0);

        assertEquals(expected, actual);
        assertEquals(expected, actual);
        actual = q.find(1);
        assertEquals(expected, actual);
        actual = q.find(2);
        assertEquals(expected, actual);
        actual = q.find(3);
        assertEquals(expected, actual);
        actual = q.find(4);
        assertEquals(expected, actual);
        actual = q.find(5);
        assertEquals(expected, actual);

        expected = 6;
        actual = q.find(6);
        assertEquals(expected, actual);
    }

    @Test
    public void testConnect() {
        QuickUnion q = new QuickUnion(7);
        q.connect(0, 1);
        int[] expected = {1, -1, -1, -1, -1, -1, -1};
        int[] actual = q.getParents();
        assertArrayEquals(expected, actual);

        q.connect(1, 0);
        actual = q.getParents();
        assertArrayEquals(expected, actual);

        q.connect(1, 2);
        expected = new int[] {1, 2, -1, -1, -1, -1, -1};
        actual = q.getParents();
        assertArrayEquals(expected, actual);

        q.connect(3, 1);
        expected = new int[] {1, 2, -1, 2, -1, -1, -1};
        actual = q.getParents();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void testIsConnected() {
        QuickUnion q = new QuickUnion(10);
        assertFalse(q.isConnected(0, 5));

        q.connect(0, 5);
        q.connect(0, 3);
        q.connect(5, 3);
        assertTrue(q.isConnected(0, 5));
        assertTrue(q.isConnected(3, 0));
        assertTrue(q.isConnected(3, 5));
        assertFalse(q.isConnected(9, 0));
        q.connect(9, 5);
        assertTrue(q.isConnected(3, 9));
        assertTrue(q.isConnected(5, 9));
        assertTrue(q.isConnected(0, 9));
        q.connect(7, 8);
        assertTrue(q.isConnected(7, 8));
        assertFalse(q.isConnected(8, 9));
        assertFalse(q.isConnected(8, 0));
        q.connect(7, 3);
        assertTrue(q.isConnected(7, 9));
        assertTrue(q.isConnected(7, 0));
        assertTrue(q.isConnected(7, 3));
    }
}
