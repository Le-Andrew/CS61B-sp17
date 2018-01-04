public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        return  x == y + 1 ||
                y == x + 1 ||
                y == x + 1 ||
                y == x - 1;
    }

    public static void main(String[] args) {
        OffByOne obo = new OffByOne();
        boolean result;
        /* Should return true */
        result = obo.equalChars('a', 'b');
        result = obo.equalChars('r', 'q');

        /* Should return false */

        result = obo.equalChars('a', 'e');
        result = obo.equalChars('z', 'a');
        result = obo.equalChars('a', 'a');
    }
}
