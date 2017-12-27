public class LinkedListDeque<Item> {



    class ListNode<Item> {
        Item item;
        ListNode next;
        ListNode prev;

        public ListNode(Item item) {
            this.item = item;
        }
    }

    private int size;

    public LinkedListDeque() {
        size = 0;
        sentinel = new ListNode<Item>(null); /* Don't care what value inside node */
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    private ListNode sentinel;

    public void addFirst(Item item) {
        ListNode<Item> insertedNode = new ListNode<Item>(item);
        ListNode<Item> oldFirst = sentinel.next;

        insertedNode.prev = sentinel.prev;
        insertedNode.next = sentinel.next;

        /* Make old first's previous point to new first */
        sentinel.next = insertedNode;
        oldFirst.prev = insertedNode;

        size += 1;
    }

    public void addLast(Item item) {
        ListNode<Item> insertedNode = new ListNode<Item>(item);
        ListNode<Item> oldLast = sentinel.prev;

        insertedNode.next = sentinel;
        insertedNode.prev = oldLast.prev;

        /* Update pointers: the last element is sentinel node's previous, due to circular topology. */
        oldLast.next = insertedNode;
        sentinel.prev = insertedNode;

        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        ListNode<Item> currentNode = sentinel.next;

        while (currentNode != sentinel) {
            System.out.print(currentNode.item);
            if (currentNode.next != sentinel) {
                System.out.print(" ");
            }
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public Item removeFirst() {
        ListNode<Item> first = sentinel.next;
        Item result = first.item;

        /* Update pointers */
        first.next.prev = sentinel;
        sentinel.next = first.next;

        size -= 1;

        return result;
    }

    public Item removeLast() {
        ListNode<Item> last = sentinel.prev;
        Item result = last.item;

        /* Update pointers */
        last.prev = sentinel;
        sentinel.prev = last.prev;

        size -= 1;

        return result;
    }

    public Item get(int index) {
        ListNode<Item> currentNode = sentinel.next;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.item;
    }

    private ListNode<Item> getRecursive(int index, ListNode<Item> node) {
        if (index == 0) {
            return node;
        }
        return getRecursive(index - 1, node.next);
    }

    // TODO: Find out why I cannot just do getRecursive(index, sentinel).item;
    public Item getRecursive(int index) {
        ListNode<Item> result = getRecursive(index, sentinel.next);
        return result.item;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer>  test = new LinkedListDeque<Integer>();

        test.addFirst(9);
        test.addLast(2);
        test.addLast(3);
        test.addLast(4);
        test.addFirst(4);
        test.addLast(5);

        test.printDeque();

        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.getRecursive(i));

        }
    }

}
