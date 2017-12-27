public class ArrayDeque<Item> {

    private int maxSize = 6;
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

    // TODO: Rename to extends array
    private void resizeArray(int newSize) {
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

    public void addFirst(Item item) {

        /* Need to re-size array and then re-order if necessary */
        if (isFull()) {
            resizeArray(maxSize * 2);
        }

        first--;
        currentSize++;
        items[getCircularIndex(first)] = item;


    }

    public void addLast(Item item) {
        if (isFull()) {
            resizeArray(maxSize * 2);
        }

        currentSize++;
        items[getLastIndex()] = item;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    void printDeque() {

    }

    Item removeFirst() {
        return null;
    }

    Item removeLast() {
        return null;
    }

    public int size() {
        return currentSize;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer>  test = new ArrayDeque<Integer>();
        test.addFirst(1);
        test.addFirst(2);
        test.addFirst(3);
        test.addFirst(4);
        test.addFirst(5);
        test.addFirst(6);
        test.addFirst(7);
        test.addFirst(8);
        test.addFirst(9);
        test.addLast(2);
        test.addLast(3);
        test.addLast(4);
        test.addLast(5);
    }


}
