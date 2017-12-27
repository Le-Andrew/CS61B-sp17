public class ArrayDeque<Item> {

    private int maxSize = 6;
    private int currentSize = 0;
    private int first = maxSize / 2; /* Floor integer division - start at middle. */
    private Item items[];

    public ArrayDeque() {
        items = (Item[]) new Object[maxSize];
    }

    private int getModdedIndex() {
        return (first < 0) ? (first + maxSize) : first;
    }

    private int getLastIndex() {
        return ( (first + currentSize) % maxSize ) - 1;
    }

    public void addFirst(Item item) {
        first--;
        currentSize++;
        items[getModdedIndex()] = item;
    }

    public void addLast(Item item) {
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
        test.addFirst(5);
        test.addFirst(10);
        test.addFirst(3);
        test.addFirst(5);
        test.addFirst(6);
    }


}
