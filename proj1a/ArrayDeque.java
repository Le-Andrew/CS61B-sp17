/**
 *
 * @author Andrew Le
 */
public class ArrayDeque<Item> {

    private static final int DEFAULT_SIZE = 8;

    private int maxSize = DEFAULT_SIZE;
    private int currentSize = 0;
    private int first = maxSize / 2; /* Floor integer division - start at middle. */
    private Item items[];

    public ArrayDeque() {
        items = (Item[]) new Object[maxSize];
    }

    private int getCircularIndex(int index) {
        return (index < 0) ? (index + maxSize) : index;
    }

    private int getLastIndex() {
        return ( (first + currentSize - 1) % maxSize );
    }

    private boolean isFull() {
        return currentSize == maxSize;
    }

    /**
     * @requires currentSize <= newSize
     * @param newSize
     */
    private void extendArray(int newSize) {
        Item[] newItems = (Item[]) new Object[newSize];

        /* Start placing items from the centre */
        int centreOfQueue = newSize / 2;
        int j = centreOfQueue - (currentSize / 2);
        int newFirst = j;
        for (int i = 0; i < currentSize; i++) {
            int index = getCircularIndex(first + i);
            newItems[j] = items[index];
            j++;
        }

        /* Update pointers */
        first = newFirst;
        items = newItems;
        maxSize = newSize;
    }

    /**
     * Shrinks the items array.
     * @requires newSize < maxSize
     * @param newSize
     */
    private void shrinkArray(int newSize) {
        extendArray(newSize);
    }

    public void addFirst(Item item) {

        /* Need to re-size array and then re-order if necessary */
        if (isFull()) {
            extendArray(maxSize * 2);
        }

        first--;
        currentSize++;
        items[getCircularIndex(first)] = item;


    }

    public void addLast(Item item) {
        if (isFull()) {
            extendArray(maxSize * 2);
        }

        currentSize++;
        items[getLastIndex()] = item;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void printDeque() {
        for (int i = 0; i < currentSize; i++) {
            int index = getCircularIndex(first + i);
            System.out.print(items[index]);
            if (i < currentSize - 1) {
                System.out.print(" ");
            }
        }
    }

    public Item removeFirst() {
        Item result = items[getCircularIndex(first)];
        items[getCircularIndex(first)] = null;
        first += 1;
        currentSize -= 1;

        if (maxSize > 16 && currentSize == maxSize / 4) {
            shrinkArray(maxSize / 2);
        }

        return result;
    }

    public Item removeLast() {
        Item result = items[getLastIndex()];
        items[getLastIndex()] = null;
        currentSize -= 1;
        return result;
    }

    public Item get(int index) {
        if (index < currentSize) {
            return items[getCircularIndex(first + index)];
        }

        return null;
    }

    public int size() {
        return currentSize;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer>  test = new ArrayDeque<Integer>();

        test.addFirst(0);
        test.addFirst(1);
        test.addFirst(2);
        test.addFirst(3);
        test.removeFirst();
        test.removeFirst();
        test.removeLast();
        test.removeLast();
        test.addLast(3);
        test.addLast(2);
        test.addLast(1);
        test.addLast(0);
        test.removeFirst();
        test.removeFirst();
        test.removeLast();
        test.removeLast();

        test.printDeque();

        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }
    }


}
