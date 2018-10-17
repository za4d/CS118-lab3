/*
    Programming for Computer Scientists (CS118) - Lab 3
    Conditionals and arrays
*/

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Lab3Test {
    private Lab3 lab = new Lab3();

    @Test
    public void testMin() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        // test 100 random pairs of integers
        for(int i=0; i<100; i++) {
            int x = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            int y = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);

            int r = lab.min(x,y);

            assertTrue("min does not return one of the two numbers", r == x || r == y);
            assertTrue("min does not return the minimum", r <= x && r <= y);
        }
    }

    @Test
    public void testMax() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        // test 100 random pairs of integers
        for(int i=0; i<100; i++) {
            int x = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            int y = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);

            int r = lab.max(x,y);

            assertTrue("max does not return one of the two numbers", r == x || r == y);
            assertTrue("max does not return the minimum", r >= x && r >= y);
        }
    }

    @Test
    public void testMedian() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        // test 100 random triples of integers
        for(int i=0; i<100; i++) {
            int a = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            int b = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            int c = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);

            int r = lab.median(a,b,c);

            int[] xs = new int[] { a, b, c };
            Arrays.sort(xs);

            assertTrue("median does not return one of the three numbers", r == a || r == b || r == c);
            assertTrue("median does not return the the median", r == xs[1]);
        }
    }

    @Test
    public void testTaxToPay() {
        // perform tests for some edge cases
        assertEquals(0.0, lab.taxToPay(0), 0.0);
        assertEquals(0.0, lab.taxToPay(11850), 0.0);
        assertEquals(0.2, lab.taxToPay(11851), 0.01);
        assertEquals(6900.0, lab.taxToPay(46350), 0.01);
        assertEquals(6900.4, lab.taxToPay(46351), 0.01);
        assertEquals(48360.0, lab.taxToPay(150000), 0.01);
        assertEquals(48360.45, lab.taxToPay(150001), 0.01);

        // perform some random tests
        ThreadLocalRandom random = ThreadLocalRandom.current();

        // test 100 random salaries that do not exceed the tax-free allowance
        for(int i=0; i<100; i++) {
            int s = random.nextInt(0, 11850);
            double tax = lab.taxToPay(s);

            assertEquals(0.0, tax, 0.0);
        }

        // test 100 random salaries that are in the 20% tax bracket
        for(int i=0; i<100; i++) {
            int s = random.nextInt(11851, 46350);
            int taxable = s - 11850;
            double tax = lab.taxToPay(s);

            assertEquals(taxable * 0.2f, tax, 0.01);
        }

        // test 100 random salaries that are in the 40% tax bracket
        for(int i=0; i<100; i++) {
            int s = random.nextInt(46351, 150000);
            int taxable = s - 46350;
            double tax = lab.taxToPay(s);

            assertEquals(6900.0 + (taxable * 0.4f), tax, 0.01);
        }

        // test 100 random salaries that are in the 45% tax bracket
        for(int i=0; i<100; i++) {
            int s = random.nextInt(150001, 450000);
            int taxable = s - 150000;
            double tax = lab.taxToPay(s);

            assertEquals(48360.0 + (taxable * 0.45), tax, 0.02);
        }
    }

    @Test
    public void testSegments() {
        boolean[] zero = lab.segments((byte)0);
        boolean[] one = lab.segments((byte)1);
        boolean[] two = lab.segments((byte)2);
        boolean[] three = lab.segments((byte)3);
        boolean[] four = lab.segments((byte)4);
        boolean[] five = lab.segments((byte)5);
        boolean[] six = lab.segments((byte)6);
        boolean[] seven = lab.segments((byte)7);
        boolean[] eight = lab.segments((byte)8);
        boolean[] nine = lab.segments((byte)9);

        assertTrue(
            "segments doesn't return the correct array for zero",
            zero[0] && zero[1] && zero[2] && zero[3] && zero[4] && zero[5] && !zero[6]);
        assertTrue(
            "segments doesn't return the correct array for one",
            !one[0] && one[1] && one[2] && !one[3] && !one[4] && !one[5] && !one[6]);
        assertTrue(
            "segments doesn't return the correct array for two",
            two[0] && two[1] && !two[2] && two[3] && two[4] && !two[5] && two[6]);
        assertTrue(
            "segments doesn't return the correct array for three",
            three[0] && three[1] && three[2] && three[3] && !three[4] && !three[5] && three[6]);
        assertTrue(
            "segments doesn't return the correct array for four",
            !four[0] && four[1] && four[2] && !four[3] && !four[4] && four[5] && four[6]);
        assertTrue(
            "segments doesn't return the correct array for five",
            five[0] && !five[1] && five[2] && five[3] && !five[4] && five[5] && five[6]);
        assertTrue(
            "segments doesn't return the correct array for six",
            six[0] && !six[1] && six[2] && six[3] && six[4] && six[5] && six[6]);
        assertTrue(
            "segments doesn't return the correct array for seven",
            seven[0] && seven[1] && seven[2] && !seven[3] && !seven[4] && !seven[5] && !seven[6]);
        assertTrue(
            "segments doesn't return the correct array for eight",
            eight[0] && eight[1] && eight[2] && eight[3] && eight[4] && eight[5] && eight[6]);
        assertTrue(
            "segments doesn't return the correct array for nine",
            nine[0] && nine[1] && nine[2] && nine[3] && !nine[4] && nine[5] && nine[6]);
    }

    @Test
    public void testSegmentsBytes() {
        byte[] numbers = new byte[] { 63, 6, 91, 79, 102, 109, 125, 7, 127, 111 };

        // perform some random tests
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for(int i=0; i<100; i++) {
            int size = random.nextInt(1,10);
            byte[] array = new byte[size];

            for(int j=0; j<size; j++) {
                array[j] = (byte)random.nextInt(0,10);
            }

            byte[] results = lab.segmentsBytes(array);

            for(int j=0; j<size; j++) {
                assertTrue(
                    "segmentsBytes returned the wrong byte",
                    results[j] == numbers[array[j]]);
            }
        }
    }
}
