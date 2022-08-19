package deque;

import org.junit.Test;

import static org.junit.Assert.*;

/* Performs some basic array deque tests. */
public class ArrayDequeTest {

    /** You MUST use the variable below for all of your tests. If you test
     * using a local variable, and not this static variable below, the
     * autograder will not grade that test. If you would like to test
     * ArrayDeques with types other than Integer (and you should),
     * you can define a new local variable. However, the autograder will
     * not grade that test. */

    public static Deque<Integer> ad = new ArrayDeque<Integer>();

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

//        assertTrue("A newly initialized LLDeque should be empty", ad.isEmpty());
        ad.addFirst(0);

//        assertFalse("lld1 should now contain 1 item", ad.isEmpty());

        ad = new LinkedListDeque<Integer>(); //Assigns lld equal to a new, clean LinkedListDeque!

    }

    /** Adds an item, removes an item, and ensures that dll is empty afterwards. */
    @Test
    public void addRemoveTest() {
        ad.addFirst(5);
        int ret = ad.removeFirst();
        assertEquals(5, ret);
//        assertTrue("LLDeque should be empty", ad.isEmpty());

        ad.addLast(10);
        ret = ad.removeLast();
        assertEquals(10, ret);
//        assertTrue("LLDeque should be empty", ad.isEmpty());

        ad = new LinkedListDeque<Integer>(); //Assigns lld equal to a new, clean LinkedListDeque!
    }
    /** Make sure that removing from an empty LinkedListDeque does nothing */
    @Test
    public void removeEmptyTest() {
//        assertTrue("LLDeque should be empty", ad.isEmpty());
        assertEquals(null, ad.removeLast());
        assertEquals(null, ad.removeFirst());

        ad = new LinkedListDeque<Integer>(); //Assigns lld equal to a new, clean LinkedListDeque!
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
//        assertTrue("LLDeque should be empty", ad.isEmpty());
        assertEquals(null, ad.removeFirst());
        assertEquals(null, ad.removeLast());
//        assertTrue("LLDeque should be empty", ad.isEmpty());
    }
    /** TODO: Write tests to ensure that your implementation works for really large
     * numbers of elements, and test any other methods you haven't yet tested!
     */
    @Test
    public void largeNum() {
        for (int i = 1; i <= 10000; i++) {
            ad.addFirst(i);
        }
        assertEquals(10000, ad.size());

        int res = 0;
        for (int i = 10000; i >= 1; i--) {
            res = ad.removeFirst();
            assertEquals(i, res);
        }
//        assertTrue("LLDeque should be empty", ad.isEmpty());
            ad = new LinkedListDeque<Integer>(); //Assigns lld equal to a new, clean LinkedListDeque!
        }


    @Test
    public void testPrintDeque() {
//        assertTrue("LLDeque should be empty", ad.isEmpty()); //make sure lld is empty
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addFirst(3);
        ad.addFirst(4);
        ad.addFirst(5);
        ad.printDeque();
        ad = new LinkedListDeque<Integer>();
    }

//    @Test
//    public void testGet() {
//
//    }

    @Test
    public void testEqual() {
        ArrayDeque<Integer> obj1 = new ArrayDeque<>();
        LinkedListDeque<Integer> obj2 = new LinkedListDeque<>();
        assertTrue("Null ArrayDeque and LinkedListDeque should be equal", obj1.equals(obj2));

        ArrayDeque<Integer> obj3 = new ArrayDeque<>();
        obj1.addFirst(1);
        obj3.addFirst(1);
        assertTrue("Two instances of ArrayDeque should be equal", obj1.equals(obj3));

        obj2.addFirst(1);
        assertFalse("obj1 should not equal to null", obj1.equals(null));
        assertTrue("ArrayDeque and LinkedListDeque should be equal", obj1.equals(obj2));

        ArrayDeque<String> obj4 = new ArrayDeque<>();
        ArrayDeque<String> obj5 = new ArrayDeque<>();
        obj4.addFirst("add");
        obj5.addFirst("add");
        assertTrue("Two instances of ArrayDeque should be equal", obj4.equals(obj5));
        LinkedListDeque<String> obj6 = new LinkedListDeque<>();
        obj6.addFirst("add");
        assertTrue("ArrayDeque and LinkedListDeque should be equal", obj4.equals(obj6));
        obj6.addFirst("false");
        assertFalse("Two instances of ArrayDeque should not be equal", obj4.equals(obj6));
    }

    //public static Deque<Integer> ad = new ArrayDeque<Integer>();


}
