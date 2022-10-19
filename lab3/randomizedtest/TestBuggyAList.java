package randomizedtest;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> al = new AListNoResizing<>();
        BuggyAList<Integer> bl = new BuggyAList<>();

        for (int i = 4; i < 7; i++)
        {
            al.addLast(i);
            bl.addLast(i);
        }

        for (int i = 0; i < 3; i++)
        {
            assertEquals(al.removeLast(), bl.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size1 = L.size();
                int size2 = B.size();
                System.out.println("size1: " + size1 + ". size2: " + size2);
                assertEquals(size1, size2);
            } else if (operationNumber == 2) {
                if (L.size() == 0 || B.size() == 0) continue;
                int num1 = L.removeLast();
                int num2 = B.removeLast();
                System.out.println("removeLast1: " + num1 + ". removeLast2: " + num2);
                assertEquals(num1, num2);
            }
        }
    }
}
