import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDeque1B {

    @Test
    public void someTest() {
        StudentArrayDeque<Integer> actual = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> expected = new ArrayDequeSolution<Integer>();
        Integer randomVal, actualVal, expectedVal;
        OperationSequence methodHistory = new OperationSequence();

        long cycles = 0;

        while (true) {
            randomVal = StdRandom.uniform(0, 6);

            switch (randomVal) {
                case 0: /* Remove: first */
                    if (!actual.isEmpty()) {
                        actualVal =  actual.removeFirst();
                        expectedVal = expected.removeFirst();
                        methodHistory.addOperation(new DequeOperation(getMethodNameFromCase(randomVal)));
                        assertEquals(methodHistory.toString(), expectedVal, actualVal);

                    }
                    break;
                case 1: /* Remove: last */
                    if (!actual.isEmpty()) {
                        actualVal = actual.removeLast();
                        expectedVal = expected.removeLast();
                        methodHistory.addOperation(new DequeOperation(getMethodNameFromCase(randomVal)));
                        assertEquals(methodHistory.toString(), expectedVal, actualVal);
                    }
                    break;
                case 2: /* Add: first*/
                    methodHistory.addOperation(new DequeOperation(getMethodNameFromCase(randomVal), randomVal));
                    randomVal = StdRandom.uniform(0, 9);
                    actual.addFirst(randomVal);
                    expected.addFirst(randomVal);

                    break;
                case 3: /* Add: last */
                    methodHistory.addOperation(new DequeOperation(getMethodNameFromCase(randomVal), randomVal));
                    randomVal = StdRandom.uniform(0, 9);
                    actual.addLast(randomVal);
                    expected.addLast(randomVal);

                    break;
                case 4: /* size */
                    methodHistory.addOperation(new DequeOperation("size"));
                    actualVal = actual.size();
                    expectedVal = expected.size();
                    assertEquals(methodHistory.toString(), expectedVal, actualVal);
                    break;
                case 5: /* is empty */
                    methodHistory.addOperation(new DequeOperation("isEmpty"));
                    actualVal = actual.isEmpty() ? 1 : 0;
                    expectedVal = expected.isEmpty() ? 1 : 0;
                    assertEquals(methodHistory.toString(), expectedVal, actualVal);
            }
        }
    }

    private String getMethodNameFromCase(Integer randomVal) {
        switch (randomVal) {
            case 0:
                return "removeFirst";
            case 1:
                return "removeLast";
            case 2:
                return "addFirst";
            case 3:
                return "addLast";
            case 4:
                return "size";
        }
        return "unknown method";
    }
}
