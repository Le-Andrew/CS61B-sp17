/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {


    public static void main(String[] args) {
        boolean offByOne = true;
        int minLength = 4;
        In in = new In("words.txt");

        while (!in.isEmpty()) {
            String word = in.readString();

            if (offByOne) {
                if (word.length() >= minLength && Palindrome.isPalindrome(word, new OffByOne())) {
                    System.out.println(word);
                }
            } else {
                if (word.length() >= minLength && Palindrome.isPalindrome(word)) {
                    System.out.println(word);
                }
            }
        }
    }
} 
