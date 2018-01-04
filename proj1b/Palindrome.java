public class Palindrome {
    public static Deque<Character> wordToDeque(String word ){
        Deque<Character> result = new LinkedListDeque<>();
        for (Character c : word.toCharArray()) {
            result.addLast(c);
        }

        return result;
    }

    private static boolean isPalindrome(String word, Deque<Character> d) {
        if (d.isEmpty() || d.size() == 1) {
            return true;
        }
        boolean result = d.removeFirst() == d.removeLast();

        return result && isPalindrome(word, d);
    }

    public static boolean isPalindrome(String word) {
        return isPalindrome(word, wordToDeque(word));
    }

    public static void main(String[] args) {
        StdOut.print(isPalindrome("racecar"));
        Deque<Character> test = wordToDeque("1234");
        test.printDeque();
        StdOut.println(test.removeFirst());
        StdOut.println(test.removeLast());
        StdOut.println(test.removeFirst());
        StdOut.println(test.removeLast());

    }
}
