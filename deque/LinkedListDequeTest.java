package deque;

import org.junit.Test;
<<<<<<< HEAD

import java.util.Optional;


import static org.junit.Assert.*;


/** Performs some basic linked list deque tests. */
public class LinkedListDequeTest {

    /** You MUST use the variable below for all of your tests. If you test
     * using a local variable, and not this static variable below, the
     * autograder will not grade that test. If you would like to test
     * LinkedListDeques with types other than Integer (and you should),
     * you can define a new local variable. However, the autograder will
     * not grade that test. Please do not import java.util.Deque here!*/

    public static Deque<Integer> lld = new LinkedListDeque<Integer>();

    @Test
    /** Adds a few things to the list, checks that isEmpty() is correct.
     * This is one simple test to remind you how junit tests work. You
     * should write more tests of your own.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {


        /*
        System.out.println("Make sure to uncomment the lines below (and delete this print statement)." +
                " The code you submit to the AG shouldn't have any print statements!");
         */

//		assertTrue("A newly initialized LLDeque should be empty", lld.isEmpty());
		lld.addFirst(0);

//        assertFalse("lld1 should now contain 1 item", lld.isEmpty());

        lld = new LinkedListDeque<Integer>(); //Assigns lld equal to a new, clean LinkedListDeque!

        System.out.println("Make sure to uncomment the lines below (and delete this print statement)." +
                " The code you submit to the AG shouldn't have any print statements!");
        /*
		assertTrue("A newly initialized LLDeque should be empty", lld.isEmpty());
		lld.addFirst(0);

        assertFalse("lld1 should now contain 1 item", lld.isEmpty());

        lld = new LinkedListDeque<Integer>(); //Assigns lld equal to a new, clean LinkedListDeque!
		*/


    }

    /** Adds an item, removes an item, and ensures that dll is empty afterwards. */
    @Test
    public void addRemoveTest() {

        lld.addFirst(5);
        int ret = lld.removeFirst();
        assertEquals(5, ret);
//        assertTrue("LLDeque should be empty", lld.isEmpty());

        lld.addLast(10);
        ret = lld.removeLast();
        assertEquals(10, ret);
//        assertTrue("LLDeque should be empty", lld.isEmpty());

        lld = new LinkedListDeque<Integer>(); //Assigns lld equal to a new, clean LinkedListDeque!

    }
    /** Make sure that removing from an empty LinkedListDeque does nothing */
    @Test
    public void removeEmptyTest() {

//        assertTrue("LLDeque should be empty", lld.isEmpty());
        assertEquals(null, lld.removeLast());
        assertEquals(null, lld.removeFirst());

        lld = new LinkedListDeque<Integer>(); //Assigns lld equal to a new, clean LinkedListDeque!

    }
    /** Make sure your LinkedListDeque also works on non-Integer types */
    @Test
    public void multipleParamsTest() {

        Deque<Float> floatLld = new LinkedListDeque<Float>();
        floatLld.addFirst(2.5F);
        floatLld.removeFirst();
//        assertTrue("LLDeque should be empty", floatLld.isEmpty());

        floatLld.addLast(2.5F);
        floatLld.removeLast();
//        assertTrue("LLDeque should be empty", floatLld.isEmpty());

    }
    /** Make sure that removing from an empty LinkedListDeque returns null */
    @Test
    public void emptyNullReturn() {
<<<<<<< HEAD
//        assertTrue("LLDeque should be empty", lld.isEmpty());
        assertEquals(null, lld.removeFirst());
        assertEquals(null, lld.removeLast());
//        assertTrue("LLDeque should be empty", lld.isEmpty());
        lld = new LinkedListDeque<Integer>(); //Assigns lld equal to a new, clean LinkedListDeque!
    }
    /** TODO: Write tests to ensure that your implementation works for really large
     * numbers of elements, and test any other methods you haven't yet tested!
     */

    @Test
    public void largeNum() {
        for (int i = 1; i <= 10000; i++) {
            lld.addFirst(i);
        }
        assertEquals(10000, lld.size());

        int res = 0;
        for (int i = 10000; i >= 1; i--) {
            res = lld.removeFirst();
            assertEquals(i, res);
        }
//        assertTrue("LLDeque should be empty", lld.isEmpty());
        lld = new LinkedListDeque<Integer>(); //Assigns lld equal to a new, clean LinkedListDeque!
    }

    @Test
    public void testPrintDeque() {
//        assertTrue("LLDeque should be empty", lld.isEmpty()); //make sure lld is empty
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addFirst(3);
        lld.addFirst(4);
        lld.addFirst(5);
        lld.printDeque();
        lld = new LinkedListDeque<Integer>(); //Assigns lld equal to a new, clean LinkedListDeque!
    }


    @Test
    public void testEqual() {
        ArrayDeque<Integer> obj1 = new ArrayDeque<>();
        LinkedListDeque<Integer> obj2 = new LinkedListDeque<>();
        assertTrue("Null ArrayDeque and LinkedListDeque should be equal", obj2.equals(obj1));

        LinkedListDeque<Integer> obj3 = new LinkedListDeque<>();
        obj2.addFirst(1);
        obj3.addFirst(1);

        assertTrue("Two instances of ArrayDeque should be equal", obj2.equals(obj3));
        obj1.addFirst(1);
        obj1.addLast(1);
        obj2.addFirst(1);

        assertTrue("ArrayDeque and LinkedListDeque should be equal", obj2.equals(obj1));
        assertFalse("obj2 should not equal to null", obj2.equals(null));


        LinkedListDeque<String> obj4 = new LinkedListDeque<>();
        LinkedListDeque<String> obj5 = new LinkedListDeque<>();
        obj4.addFirst("add");
        obj5.addFirst("add");
        assertTrue("Two instances of ArrayDeque should be equal", obj4.equals(obj5));
        ArrayDeque<String> obj6 = new ArrayDeque<>();
        obj6.addFirst("add");
        assertTrue("ArrayDeque and LinkedListDeque should be equal", obj4.equals(obj6));
    }
=======
>>>>>>> d6bf419c090d9b517a8ec271e6c4075d6802356a

}
