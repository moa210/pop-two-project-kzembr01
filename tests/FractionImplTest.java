import fraction.Fraction;
import fraction.FractionImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FractionImplTest {


    @Test
    void throwsException() {
        String wrongFormat = "Wrong format passed for your fraction - unable to continue!";
        String zeroDivisionStr = "Cannot use ZERO as denominator!";
        String wrongArg = "Wrong argument passed to the method";

        Exception thrown_1 = assertThrows(ArithmeticException.class, () -> new FractionImpl(3, 0));
        assertEquals(zeroDivisionStr, thrown_1.getMessage());

        Exception thrown_2 = assertThrows(IllegalArgumentException.class, () -> new FractionImpl(1, 2).equals("13/3"));
        assertEquals(wrongArg, thrown_2.getMessage());

        Exception thrown_3 = assertThrows(ArithmeticException.class, () -> new FractionImpl(" 13 /- 0 "));
        assertEquals(zeroDivisionStr, thrown_3.getMessage());

        Exception thrown_4 = assertThrows(IllegalArgumentException.class, () -> new FractionImpl(" 13 /2 / 1 "));
        assertEquals(wrongFormat, thrown_4.getMessage());

        Exception thrown_5 = assertThrows(IllegalArgumentException.class, () -> new FractionImpl("-13,2 /1 "));
        assertEquals(wrongFormat, thrown_5.getMessage());

        Exception thrown_6 = assertThrows(IllegalArgumentException.class, () -> new FractionImpl("-132, "));
        assertEquals(wrongFormat, thrown_6.getMessage());

        Exception thrown_7 = assertThrows(IllegalArgumentException.class, () -> new FractionImpl("s132/13 "));
        assertEquals(wrongFormat, thrown_7.getMessage());

        Exception thrown_8 = assertThrows(NumberFormatException.class, () -> new FractionImpl("132-/13 "));
        assertEquals(wrongFormat, thrown_8.getMessage());

    }


    @Test
    void allowsVariousTypes() {
        assertEquals(new FractionImpl(12, 1), new FractionImpl(12), "Whole number as int not accepted");
        assertEquals(new FractionImpl(12, 1), new FractionImpl("12"), "String single number not accepted");
        assertEquals(new FractionImpl(1, 2), new FractionImpl("2/4"), "Fraction string not accepted");
        assertEquals(new FractionImpl(0, 1), new FractionImpl(0), "Whole number ZERO not accepted");
        assertEquals(new FractionImpl(-1, 2), new FractionImpl(" - 2 /-4"), "Negative string fraction white spaces not accepted");
        assertEquals(new FractionImpl(19, 6), new FractionImpl(" 1 9 / 6 "), "Positive string white spaces not accepted");
    }

    @Test
    void gcdMethod() {
        assertEquals(new FractionImpl("2/4"), new FractionImpl(1, 2), "test for 2/4 failed");
        assertEquals(new FractionImpl(-2, -4), new FractionImpl(-1, 2), "test for -2/4 failed");
    }


    @Test
    void add() {
        Fraction add_1 = new FractionImpl(8, 3).add(new FractionImpl(2, 4));
        Fraction add_2 = new FractionImpl(2, 4).add(new FractionImpl(13, 6));
        Fraction add_3 = new FractionImpl(-8, -3).add(new FractionImpl(8, 3));
        Fraction add_4 = new FractionImpl("8/3").add(new FractionImpl(-2, -4));
        Fraction add_5 = new FractionImpl("-1/2").add(new FractionImpl(-8, -3));

        assertEquals(new FractionImpl(19, 6), add_1, " * Test for addition of positives 1 failed * ");
        assertEquals(new FractionImpl(8, 3), add_2, " * Test for addition of positives 2 failed * ");
        assertEquals(new FractionImpl(0, 1), add_3, " * Test for addition negative + positive failed were outcome 0* ");
        assertEquals(new FractionImpl(13, 6), add_4, " * Test for addition positive + negative failed * ");
        assertEquals(new FractionImpl(-19, -6), add_5, " * Test for addition negative + negative failed * ");
    }


    @Test
    void subtractAndLcmMethod() {
        Fraction sub_1 = new FractionImpl(8, 3).subtract(new FractionImpl(2, 4)); //
        Fraction sub_2 = new FractionImpl(2, 4).subtract(new FractionImpl(8, 3));
        Fraction sub_3 = new FractionImpl(13, 6).subtract(new FractionImpl(-2, -4));
        Fraction sub_4 = new FractionImpl(-2, -4).subtract(new FractionImpl(-8, -3));
        Fraction sub_5 = new FractionImpl(-8, -3).subtract(new FractionImpl(13, 6));
        Fraction sub_6 = new FractionImpl("-13/6").subtract(new FractionImpl(2, 4));
        Fraction sub_7 = new FractionImpl("-1/2").subtract(new FractionImpl(-1, 2));

        assertEquals(new FractionImpl(13, 6), sub_1, " * Test for subtraction1 failed when result positive * ");
        assertEquals(new FractionImpl(-13, -6), sub_2, " * Test for subtraction2 failed when result negative * ");
        assertEquals(new FractionImpl(8, 3), sub_3, " * Test for subtraction negative from positive failed * ");
        assertEquals(new FractionImpl(13, 6), sub_4, " * Test for subtraction negative from negative failed * ");
        assertEquals(new FractionImpl(-29, -6), sub_5, " * Test for subtraction positive from negative failed * ");
        assertEquals(new FractionImpl(-16, 6), sub_6, " * Test for positive from negative 2 failed * ");
        assertEquals(new FractionImpl(0, 1), sub_7, " * Test for negative from negative where result equals ZERO failed * ");
    }


    @Test
    void multiply() {
        Fraction mult_1 = new FractionImpl(8, 3).multiply(new FractionImpl(2, 4));
        Fraction mult_2 = new FractionImpl(2, 4).multiply(new FractionImpl(13, 6));
        Fraction mult_3 = new FractionImpl(13, 6).multiply(new FractionImpl(-2, -4));
        Fraction mult_4 = new FractionImpl(-8, -3).multiply(new FractionImpl(-2, -4));
        Fraction mult_5 = new FractionImpl("-2/4").multiply(new FractionImpl(8, 3));
        Fraction mult_6 = new FractionImpl("-1/2").multiply(new FractionImpl(-1, 2));

        assertEquals(new FractionImpl(4, 3), mult_1, " * Test for multiplying positives 1 failed * ");
        assertEquals(new FractionImpl(13, 12), mult_2, " * Test for multiplying positives 2 failed * ");
        assertEquals(new FractionImpl(-13, -12), mult_3, " * Test for multiplying positive with negative failed * ");
        assertEquals(new FractionImpl(4, 3), mult_4, " * Test for multiplying negative with negative failed * ");
        assertEquals(new FractionImpl(-4, -3), mult_5, " * Test for multiplying negative and positive failed * ");
        assertEquals(new FractionImpl(1, 4), mult_6, " * Test for multiplying same value negative failed * ");
    }


    @Test
    void divide() {
        Fraction div_1 = new FractionImpl(8, 3).divide(new FractionImpl(2, 4));
        Fraction div_2 = new FractionImpl(2, 4).divide(new FractionImpl(13, 6));
        Fraction div_3 = new FractionImpl("8/3").divide(new FractionImpl(-8, -3));
        Fraction div_4 = new FractionImpl(-8, -3).divide(new FractionImpl(13, 6));
        Fraction div_5 = new FractionImpl("-8/3").divide(new FractionImpl(-2, -4));

        assertEquals(new FractionImpl(16, 3), div_1, " * Test for division positive/positive 1 failed * ");
        assertEquals(new FractionImpl(3, 13), div_2, " * Test for division positive/positive 2 failed * ");
        assertEquals(new FractionImpl(-1, -1), div_3, " * Test for division positive/negative failed * ");
        assertEquals(new FractionImpl(-16, -13), div_4, " * Test for division negative/positive failed * ");
        assertEquals(new FractionImpl(16, 3), div_5, " * Test for division negative/negative failed * ");
    }


    @Test
    void abs() {
        Fraction abs_1 = new FractionImpl(-8, -3).abs();
        Fraction abs_2 = new FractionImpl(-2, -4).abs();
        Fraction abs_3 = new FractionImpl("8/3").abs();

        assertEquals(new FractionImpl(8, 3), abs_1, " * Test for negative abs1 failed * ");
        assertEquals(new FractionImpl(2, 4), abs_2, " * Test for negative abs2 failed * ");
        assertEquals(new FractionImpl(8, 3), abs_3, " * Test for positive abs2 failed * ");
    }


    @Test
    void negate() {
        Fraction neg_1 = new FractionImpl(8, 3).negate();
        Fraction neg_2 = new FractionImpl(2, 4).negate();
        Fraction neg_3 = new FractionImpl("-8/3").negate();
        Fraction neg_4 = new FractionImpl("-2/4").negate();

        assertEquals(new FractionImpl(-8, 3), neg_1, " * Test for negate positive 1 failed * ");
        assertEquals(new FractionImpl(-1, 2), neg_2, " * Test for negate positive 2 failed * ");
        assertEquals(new FractionImpl(8, 3), neg_3, " * Test for negate negative 1 failed * ");
        assertEquals(new FractionImpl(1, 2), neg_4, " * Test for negate negative 2 failed * ");
    }


    @Test
    void testEquals() {
        boolean eql_1 = new FractionImpl(8, 3).equals(new FractionImpl(2, 4));
        boolean eql_2 = new FractionImpl(2, 4).equals(new FractionImpl(1, 2));
        boolean eql_3 = new FractionImpl("8/3").equals(new FractionImpl(-8, -3));
        boolean eql_4 = new FractionImpl("2/4").equals(new FractionImpl(-2, -4));

        assertFalse(eql_1, " * Test for different values (false) failed * ");
        assertTrue(eql_2, "* Test for equals same value different fraction failed * ");
        assertFalse(eql_3, " * Test for equal positive vs negative failed * ");
        assertFalse(eql_4, "* Test for equals for same value positive and negative fraction failed * ");
    }


    @Test
    void inverse() {
        Fraction inv_1 = new FractionImpl(8, 3).inverse();
        Fraction inv_2 = new FractionImpl(2, 4).inverse();
        Fraction inv_3 = new FractionImpl(-8, -3).inverse();
        Fraction inv_4 = new FractionImpl(-2, -4).inverse();
        Fraction inv_5 = new FractionImpl(" -2 / 4").inverse();

        assertEquals(new FractionImpl(3, 8), inv_1, " * Test for inverse positive 1 failed * ");
        assertEquals(new FractionImpl(2, 1), inv_2, " * Test for inverse positive 2 failed * ");
        assertEquals(new FractionImpl(-3, -8), inv_3, " * Test for inverse negative 1 failed * ");
        assertEquals(new FractionImpl(-2, -1), inv_4, " * Test for inverse negative both values failed * ");
        assertEquals(new FractionImpl(-2, 1), inv_5, " * Test for inverse negative at 1st position failed * ");
    }


    @Test
    void compareTo() {
        int cmpr_1 = new FractionImpl(8, 3).compareTo(new FractionImpl(2, 4));
        int cmpr_2 = new FractionImpl(1, 2).compareTo(new FractionImpl(13, 6));
        int cmpr_3 = new FractionImpl(2, 4).compareTo(new FractionImpl(1, 2));
        int cmpr_4 = new FractionImpl("1/2").compareTo(new FractionImpl(" - 2 / -4"));

        assertEquals(1, cmpr_1, " * Test for comparing higher failed * ");
        assertEquals(-1, cmpr_2, " * Test for comparing lower failed * ");
        assertEquals(0, cmpr_3, " * Test for comparing equal failed * ");
        assertEquals(0, cmpr_4, " * Test for comparing equal string to ints failed * ");
    }


    @Test
    void testToString() {
        String to_str1 = new FractionImpl(8, 3).toString();
        String to_str2 = new FractionImpl(-8, -3).toString();


        assertEquals("8/3", to_str1, " * Test for to string positive failed * ");
        assertEquals("-8/3", to_str2, " * Test to string negative failed * ");
        assertEquals("12", new FractionImpl(12, 1).toString(), " * Test to string where 1 value passed failed * ");
    }
}