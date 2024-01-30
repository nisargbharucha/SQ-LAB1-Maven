package com.ontariotechu.sofe3980u;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest {
    /**
     * Test The constructor with a valid binary vallue
     */
    @Test
    public void normalConstructor() {
        Binary binary = new Binary("1001001");
        assertTrue(binary.getValue().equals("1001001"));
    }

    /**
     * Test The constructor with an invalid binary value of out-of-range digits
     */
    @Test
    public void constructorWithInvalidDigits() {
        Binary binary = new Binary("1001001211");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The constructor with an invalid binary value of alphabetic characters
     */
    @Test
    public void constructorWithInvalidChars() {
        Binary binary = new Binary("1001001A");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The constructor with an invalid binary value that has a sign
     */
    @Test
    public void constructorWithNegativeSign() {
        Binary binary = new Binary("-1001001");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * T est The constructor with a zero tailing valid binary value
     */
    @Test
    public void constructorWithZeroTailing() {
        Binary binary = new Binary("00001001");
        assertTrue(binary.getValue().equals("1001"));
    }

    /**
     * Test The constructor with an empty string
     */
    @Test
    public void constructorEmptyString() {
        Binary binary = new Binary("");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The add functions with two binary numbers of the same length
     */
    @Test
    public void add() {
        Binary binary1 = new Binary("1000");
        Binary binary2 = new Binary("1111");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("10111"));
    }

    /**
     * Test The add functions with two binary numbers, the length of the first
     * argument is less than the second
     */
    @Test
    public void add2() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("11");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test The add functions with two binary numbers, the length of the first
     * argument is greater than the second
     */
    @Test
    public void add3() {
        Binary binary1 = new Binary("11");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test The add functions with a binary numbers with zero
     */
    @Test
    public void add4() {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1010"));
    }

    /**
     * Test The add functions with two zeros
     */
    @Test
    public void add5() {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("0");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("0"));
    }

    /**
     * Test The or functions with two binary numbers of the same length
     */
    @Test
    public void testOrOperation() {
        Binary binary1 = new Binary("10001000");
        Binary binary2 = new Binary("111000");

        Binary resultOr = Binary.or(binary1, binary2);
        assertEquals("10111000", resultOr.getValue());
    }

    /**
     * Test OR operation with two binary numbers, both being zeros.
     */
    @Test
    public void testOrOperationZeros() {
        Binary binary1 = new Binary("1000100");
        Binary binary2 = new Binary("0");

        Binary resultOr = Binary.or(binary1, binary2);
        assertEquals("1000100", resultOr.getValue());
    }

    /**
     * Test OR operation with two binary numbers having different bits set to 1.
     */
    @Test
    public void testOrOperationDifferentBits() {
        Binary binary1 = new Binary("10101010");
        Binary binary2 = new Binary("01010101");

        Binary resultOr = Binary.or(binary1, binary2);
        assertEquals("11111111", resultOr.getValue());
    }

    /**
     * Test The and functions with two binary numbers of the same length
     */
    @Test
    public void testAndOperation() {
        Binary binary3 = new Binary("10001000");
        Binary binary4 = new Binary("111000");

        Binary resultAnd = Binary.and(binary3, binary4);
        assertEquals("1000", resultAnd.getValue());
    }

    /**
     * Test AND operation with two binary numbers, one having trailing zeros.
     */
    @Test
    public void testAndOperationTrailingZeros() {
        Binary binary1 = new Binary("10001000");
        Binary binary2 = new Binary("11100000");

        Binary resultAnd = Binary.and(binary1, binary2);
        assertEquals("10000000", resultAnd.getValue());
    }

    /**
     * Test AND operation with one binary number having all ones.
     */
    @Test
    public void testAndOperationAllOnes() {
        Binary binary1 = new Binary("10001000");
        Binary binary2 = new Binary("11111111");

        Binary resultAnd = Binary.and(binary1, binary2);
        assertEquals("10001000", resultAnd.getValue());
    }

    /**
     * Test The multiply functions with two binary numbers of the same length
     */
    @Test
    public void testMultiplyOperation() {
        Binary binary5 = new Binary("10001000");
        Binary binary6 = new Binary("111000");

        Binary resultMultiply = Binary.multiply(binary5, binary6);
        assertEquals("1110111000000", resultMultiply.getValue());
    }

    /**
     * Test Multiply with binary number multiplied by zero.
     */
    @Test
    public void testMultiplyByZero() {
        Binary binary1 = new Binary("11011011");
        Binary binary2 = new Binary("0");

        Binary resultMultiply = Binary.multiply(binary1, binary2);
        assertEquals("", resultMultiply.getValue());
    }

    /**
     * Test Multiply with binary numbers of different lengths.
     */
    @Test
    public void testMultiplyDifferentLengths() {
        Binary binary1 = new Binary("101010");
        Binary binary2 = new Binary("111111111");

        Binary resultMultiply = Binary.multiply(binary1, binary2);
        assertEquals("Expected", "101001111010110", resultMultiply.getValue());
    }

}
