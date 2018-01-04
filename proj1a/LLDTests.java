import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * A series of unit tests for a basic Deque. Source is taken from
 *      https://gist.github.com/reu/c38d6da1b93b1bc7c635
 * someone's unofficial tests for Princeton's algorithms course.
 */
public class LLDTests {
    private LinkedListDeque<String> LinkedListDeque;
    private Iterator<String> iterator;

    private LinkedListDeque<String> build(String... items) {
        LinkedListDeque<String> LinkedListDeque = new LinkedListDeque<String>();
        for (int i = 0; i < items.length; i++) {
            LinkedListDeque.addLast(items[i]);
        }
        return LinkedListDeque;
    }

    @Before
    public void setUp() {
        LinkedListDeque = null;
        iterator = null;
    }

    @Test
    public void emptyLinkedListDequeConstructorTest() {
        LinkedListDeque = new LinkedListDeque<String>();

        assertTrue(LinkedListDeque.isEmpty());
        assertEquals(0, LinkedListDeque.size());
    }

    @Test
    public void isEmptyTest() {
        LinkedListDeque = build();

        assertTrue(LinkedListDeque.isEmpty());

        LinkedListDeque.addFirst("Sasha");
        LinkedListDeque.removeFirst();
        assertTrue(LinkedListDeque.isEmpty());

        LinkedListDeque.addFirst("Sasha");
        LinkedListDeque.removeLast();
        assertTrue(LinkedListDeque.isEmpty());

        LinkedListDeque.addLast("Sasha");
        LinkedListDeque.removeFirst();
        assertTrue(LinkedListDeque.isEmpty());

        LinkedListDeque.addLast("Sasha");
        LinkedListDeque.removeLast();
        assertTrue(LinkedListDeque.isEmpty());

        LinkedListDeque.addFirst("Sasha");
        assertFalse(LinkedListDeque.isEmpty());
        LinkedListDeque.removeFirst();

        LinkedListDeque.addLast("Sasha");
        assertFalse(LinkedListDeque.isEmpty());
        LinkedListDeque.removeLast();
    }

    @Test
    public void sizeTest() {
        LinkedListDeque = build();

        assertEquals(0, LinkedListDeque.size());

        LinkedListDeque.addFirst("Sasha");
        assertEquals(1, LinkedListDeque.size());

        LinkedListDeque.addLast("Tori");
        assertEquals(2, LinkedListDeque.size());

        LinkedListDeque.removeFirst();
        assertEquals(1, LinkedListDeque.size());

        LinkedListDeque.removeLast();
        assertEquals(0, LinkedListDeque.size());
    }

    @Test
    public void addFirstTest() {
        LinkedListDeque = build();

        LinkedListDeque.addFirst("Sasha");
        assertEquals("Sasha", LinkedListDeque.removeFirst());
    }

    @Test
    public void addFirstIncrementSizeTest() {
        LinkedListDeque = build();

        assertEquals(0, LinkedListDeque.size());

        LinkedListDeque.addFirst("Sasha");
        assertEquals(1, LinkedListDeque.size());

        LinkedListDeque.addFirst("Tori");
        assertEquals(2, LinkedListDeque.size());
    }

    @Test
    public void addFirstInANonEmptyQueueTest() {
        LinkedListDeque = build("Sasha", "Lexi");

        LinkedListDeque.addFirst("Tori");
        assertEquals("Tori", LinkedListDeque.removeFirst());
        assertEquals("Sasha", LinkedListDeque.removeFirst());
        assertEquals("Lexi", LinkedListDeque.removeFirst());
    }

    @Test(expected=NullPointerException.class)
    public void addFirstWithNullObjectTest() {
        LinkedListDeque = build();

        LinkedListDeque.addFirst(null);
    }

    @Test
    public void addLastTest() {
        LinkedListDeque = build();

        LinkedListDeque.addLast("Sasha");
        assertEquals(LinkedListDeque.removeFirst(), "Sasha");
    }

    @Test
    public void addLastIncrementSizeTest() {
        LinkedListDeque = build();

        assertEquals(LinkedListDeque.size(), 0);
        LinkedListDeque.addLast("Sasha");
        assertEquals(LinkedListDeque.size(), 1);
        LinkedListDeque.addLast("Tori");
        assertEquals(LinkedListDeque.size(), 2);
    }

    @Test
    public void addLastInANonEmptyQueueTest() {
        LinkedListDeque = build("Sasha", "Lexi");

        LinkedListDeque.addLast("Tori");

        assertEquals(LinkedListDeque.removeFirst(), "Sasha");
        assertEquals(LinkedListDeque.removeFirst(), "Lexi");
        assertEquals(LinkedListDeque.removeFirst(), "Tori");
    }

    @Test(expected=NullPointerException.class)
    public void addLastWithNullObjectTest() {
        LinkedListDeque = build();
        LinkedListDeque.addLast(null);
    }

    @Test
    public void removeFirstTest() {
        LinkedListDeque = build("Sasha", "Tori");

        assertEquals(LinkedListDeque.removeFirst(), "Sasha");
    }

    @Test
    public void removeFirstDecrementSizeTest() {
        LinkedListDeque = build("Sasha", "Tori");

        assertEquals(2, LinkedListDeque.size());

        LinkedListDeque.removeFirst();
        assertEquals(1, LinkedListDeque.size());

        LinkedListDeque.removeFirst();
        assertEquals(0, LinkedListDeque.size());
    }

    @Test(expected=NoSuchElementException.class)
    public void removeFirstFromEmptyQueueTest() {
        LinkedListDeque = build();

        LinkedListDeque.removeFirst();
    }

    @Test
    public void removeLastTest() {
        LinkedListDeque = build("Sasha", "Tori");

        assertEquals(LinkedListDeque.removeLast(), "Tori");
    }

    @Test
    public void removeLastDecrementSizeTest() {
        LinkedListDeque = build("Sasha", "Tori");

        assertEquals(2, LinkedListDeque.size());

        LinkedListDeque.removeLast();
        assertEquals(1, LinkedListDeque.size());

        LinkedListDeque.removeLast();
        assertEquals(0, LinkedListDeque.size());
    }

    @Test(expected=NoSuchElementException.class)
    public void removeLastFromEmptyQueueTest() {
        LinkedListDeque = build();

        LinkedListDeque.removeLast();
    }



}