import fraction.FractionImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FractionImplTest {

    FractionImpl test_fraction_1 = new FractionImpl(8,3);
    FractionImpl test_fraction_2 = new FractionImpl(2, 4);
    FractionImpl test_fraction_3 = new FractionImpl(13,6);
    FractionImpl test_fraction_3a = new FractionImpl(-13,-6);
    FractionImpl test_fraction_4 = new FractionImpl(19, 6);
    FractionImpl test_fraction_5 = new FractionImpl(4,3);
    FractionImpl test_fraction_1a = new FractionImpl(-8, -3);
    FractionImpl test_fraction_2a = new FractionImpl(-2, -4);
    FractionImpl test_fraction_2b = new FractionImpl(1,2);
    FractionImpl test_fraction_6 = new FractionImpl(12,1);
    FractionImpl test_fraction_7 = new FractionImpl(0,1);
    FractionImpl test_fraction_2c = new FractionImpl(-1,2);
    FractionImpl test_fraction_6a = new FractionImpl(12);
    FractionImpl test_fraction_6b = new FractionImpl("12");
    FractionImpl test_fraction_2d = new FractionImpl("2/4");
    FractionImpl test_fraction_7a = new FractionImpl(0);
    FractionImpl test_fraction_2e = new FractionImpl(" - 2 / -4");
    FractionImpl test_fraction_2f = new FractionImpl(" -2 / 4");
    FractionImpl test_fraction_4a = new FractionImpl(" 1 9 / 6 ");


    @Test
    void throwsException() {
        Exception thrown_1 = assertThrows(
                ArithmeticException.class,
                () -> new FractionImpl(3,0));
        assertEquals("Cannot use ZERO as denominator!", thrown_1.getMessage());

        Exception thrown_2 = assertThrows(
                IllegalArgumentException.class,
                () -> test_fraction_1.equals("13/3"));
        assertEquals("Wrong argument passed to the method", thrown_2.getMessage());

        Exception thrown_3 = assertThrows(
                ArithmeticException.class,
                () -> new FractionImpl(" 13 /- 0 "));
        assertEquals("Cannot use ZERO as denominator!", thrown_3.getMessage());

        Exception thrown_4 = assertThrows(
                IllegalArgumentException.class,
                () -> new FractionImpl(" 13 /2 / 1 "));
        assertEquals("Cannot use this format!", thrown_4.getMessage());

        Exception thrown_5 = assertThrows(
                IllegalArgumentException.class,
                () -> new FractionImpl("-13,2 /1 "));
        assertEquals("Cannot use this format!", thrown_5.getMessage());

        Exception thrown_6 = assertThrows(
                IllegalArgumentException.class,
                () -> new FractionImpl("-132, "));
        assertEquals("Cannot use this format!", thrown_6.getMessage());

        Exception thrown_7 = assertThrows(
                IllegalArgumentException.class,
                () -> new FractionImpl("s132/13 "));
        assertEquals("Cannot use this format!", thrown_7.getMessage());

        Exception thrown_8 = assertThrows(
                NumberFormatException.class,
                () -> new FractionImpl("132-/13 "));
        assertEquals("Wrong format passed for your fraction - unable to continue", thrown_8.getMessage());

    }


    @Test
    void allowsVariousTypes() {
        assertEquals(test_fraction_6, test_fraction_6a,  "Whole number as int not accepted");
        assertEquals(test_fraction_6, test_fraction_6b,  "String single number not accepted");
        assertEquals(test_fraction_2b, test_fraction_2d, "Fraction string not accepted");
        assertEquals(test_fraction_7, test_fraction_7a,  "Whole number ZERO not accepted");
        assertEquals(test_fraction_2c, test_fraction_2e,  "Negative string fraction white spaces not accepted");
        assertEquals(test_fraction_4, test_fraction_4a, "Positive string white spaces not accepted");
    }


    @Test
    void add() {
        FractionImpl add_1 = (FractionImpl) test_fraction_1.add(test_fraction_2);
        FractionImpl add_2 = (FractionImpl) test_fraction_2.add(test_fraction_3);
        FractionImpl add_3 = (FractionImpl) test_fraction_1a.add(test_fraction_1);
        FractionImpl add_4 = (FractionImpl) test_fraction_1.add(test_fraction_2a);
        FractionImpl add_5 = (FractionImpl) test_fraction_2a.add(test_fraction_1a);

        assertEquals(test_fraction_4, add_1, " * Test for addition of positives 1 failed * ");
        assertEquals(test_fraction_1, add_2, " * Test for addition of positives 2 failed * ");
        assertEquals(test_fraction_7, add_3, " * Test for addition negative + positive failed were outcome 0* ");
        assertEquals(new FractionImpl(13,6), add_4, " * Test for addition positive + negative failed * ");
        assertEquals(new FractionImpl(-19,-6), add_5, " * Test for addition negative + negative failed * ");
    }


    @Test
    void subtract() {
        FractionImpl sub_1 = (FractionImpl) test_fraction_1.subtract(test_fraction_2); //
        FractionImpl sub_2 = (FractionImpl) test_fraction_2.subtract(test_fraction_1);
        FractionImpl sub_3 = (FractionImpl) test_fraction_3.subtract(test_fraction_2a);
        FractionImpl sub_4 = (FractionImpl) test_fraction_2a.subtract(test_fraction_1a);
        FractionImpl sub_5 = (FractionImpl) test_fraction_1a.subtract(test_fraction_3);
        FractionImpl sub_6 = (FractionImpl) test_fraction_3a.subtract(test_fraction_2);
        FractionImpl sub_7 = (FractionImpl) test_fraction_2c.subtract(test_fraction_2c);

        assertEquals(test_fraction_3, sub_1, " * Test for subtraction1 failed when result positive * ") ;
        assertEquals(test_fraction_3a, sub_2, " * Test for subtraction2 failed when result negative * ");
        assertEquals(test_fraction_1, sub_3, " * Test for subtraction negative from positive failed * ");
        assertEquals(test_fraction_3, sub_4, " * Test for subtraction negative from negative failed * ");
        assertEquals(new FractionImpl(-29,-6), sub_5, " * Test for subtraction positive from negative failed * ");
        assertEquals(new FractionImpl(-16,6), sub_6," * Test for positive from negative 2 failed * ");
        assertEquals(new FractionImpl(0,1), sub_7," * Test for negative from negative where result equals ZERO failed * ");
    }


    @Test
    void multiply() {
        FractionImpl mult_1 = (FractionImpl) test_fraction_1.multiply(test_fraction_2);
        FractionImpl mult_2 = (FractionImpl) test_fraction_2.multiply(test_fraction_3);
        FractionImpl mult_3 = (FractionImpl) test_fraction_3.multiply(test_fraction_2a);
        FractionImpl mult_4 = (FractionImpl) test_fraction_1a.multiply(test_fraction_2a);
        FractionImpl mult_5 = (FractionImpl) test_fraction_2a.multiply(test_fraction_1);
        FractionImpl mult_6 = (FractionImpl) test_fraction_2c.multiply(test_fraction_2c);

        assertEquals(test_fraction_5, mult_1, " * Test for multiplying positives 1 failed * ");
        assertEquals(new FractionImpl(13,12), mult_2, " * Test for multiplying positives 2 failed * ");
        assertEquals(new FractionImpl(-13,-12), mult_3, " * Test for multiplying positive with negative failed * ");
        assertEquals(test_fraction_5, mult_4, " * Test for multiplying negative with negative failed * ");
        assertEquals(new FractionImpl(-4,-3), mult_5, " * Test for multiplying negative and positive failed * ");
        assertEquals(new FractionImpl(1,4), mult_6, " * Test for multiplying same value negative failed * ");
    }


    @Test
    void divide() {
        FractionImpl div_1 = (FractionImpl) test_fraction_1.divide(test_fraction_2);
        FractionImpl div_2 = (FractionImpl) test_fraction_2.divide(test_fraction_3);
        FractionImpl div_3 = (FractionImpl) test_fraction_1.divide(test_fraction_1a);
        FractionImpl div_4 = (FractionImpl) test_fraction_1a.divide(test_fraction_3);
        FractionImpl div_5 = (FractionImpl) test_fraction_1a.divide(test_fraction_2a);

        assertEquals(new FractionImpl(16,3), div_1, " * Test for division positive/positive 1 failed * ");
        assertEquals( new FractionImpl(3,13), div_2, " * Test for division positive/positive 2 failed * ");
        assertEquals(new FractionImpl(-1,-1), div_3, " * Test for division positive/negative failed * ");
        assertEquals(new FractionImpl(-16,-13), div_4, " * Test for division negative/positive failed * ");
        assertEquals(new FractionImpl(16,3), div_5, " * Test for division negative/negative failed * ");
    }


    @Test
    void abs() {
        FractionImpl abs_1 = (FractionImpl) test_fraction_1a.abs();
        FractionImpl abs_2 = (FractionImpl) test_fraction_2a.abs();
        FractionImpl abs_3 = (FractionImpl) test_fraction_1.abs();

        assertEquals(test_fraction_1, abs_1, " * Test for negative abs1 failed * ");
        assertEquals(test_fraction_2, abs_2, " * Test for negative abs2 failed * ");
        assertEquals(test_fraction_1, abs_3, " * Test for positive abs2 failed * ");
    }


    @Test
    void negate() {
        FractionImpl neg_1 = (FractionImpl) test_fraction_1.negate();
        FractionImpl neg_2 = (FractionImpl) test_fraction_2.negate();
        FractionImpl neg_3 = (FractionImpl) test_fraction_1a.negate();
        FractionImpl neg_4  = (FractionImpl) test_fraction_2a.negate();

        assertEquals(test_fraction_1a , neg_1," * Test for negate positive 1 failed * ");
        assertEquals(test_fraction_2a, neg_2, " * Test for negate positive 2 failed * ");
        assertEquals(test_fraction_1 , neg_3," * Test for negate negative 1 failed * ");
        assertEquals(test_fraction_2, neg_4, " * Test for negate negative 2 failed * ");
    }


    @Test
    void testEquals() {
        boolean eql_1 = test_fraction_1.equals(test_fraction_2) ;
        boolean eql_2 = test_fraction_2.equals(test_fraction_2b);
        boolean eql_3 = test_fraction_1.equals(test_fraction_1a);
        boolean eql_4 = test_fraction_2.equals(test_fraction_2a) ;

        assertFalse(eql_1," * Test for different values (false) failed * ");
        assertTrue(eql_2, "* Test for equals same value different fraction failed * ");
        assertFalse(eql_3, " * Test for equal positive vs negative failed * ");
        assertFalse(eql_4, "* Test for equals for same value positive and negative fraction failed * ");
    }


    @Test
    void inverse() {
        FractionImpl inv_1 = (FractionImpl) test_fraction_1.inverse();
        FractionImpl inv_2 = (FractionImpl) test_fraction_2.inverse();
        FractionImpl inv_3 = (FractionImpl) test_fraction_1a.inverse();
        FractionImpl inv_4 = (FractionImpl) test_fraction_2a.inverse();
        FractionImpl inv_5 = (FractionImpl) test_fraction_2f.inverse();

        assertEquals( new FractionImpl(3,8), inv_1, " * Test for inverse positive 1 failed * ") ;
        assertEquals( new FractionImpl(2,1), inv_2, " * Test for inverse positive 2 failed * ");
        assertEquals( new FractionImpl(-3,-8), inv_3, " * Test for inverse negative 1 failed * ");
        assertEquals( new FractionImpl(-2,-1), inv_4, " * Test for inverse negative both values failed * ");
        assertEquals( new FractionImpl(-2,1), inv_5, " * Test for inverse negative at 1st position failed * ");
    }


    @Test
    void compareTo() {
        int cmpr_1 = test_fraction_1.compareTo(test_fraction_2);
        int cmpr_2 = test_fraction_2.compareTo(test_fraction_3);
        int cmpr_3 = test_fraction_2.compareTo(test_fraction_2b);
        int cmpr_4 = test_fraction_2.compareTo(test_fraction_2e);

        assertEquals(1, cmpr_1, " * Test for comparing higher failed * ");
        assertEquals(-1, cmpr_2, " * Test for comparing lower failed * ");
        assertEquals(0, cmpr_3, " * Test for comparing equal failed * ");
        assertEquals(0, cmpr_4, " * Test for comparing equal string to ints failed * ");
    }


    @Test
    void testToString() {
        String to_str1 = test_fraction_1.toString();
        String to_str2 = test_fraction_1a.toString();
        String str_1 = "8/3";
        String str_2 = "-8/3";

        assertEquals(str_1, to_str1, " * Test for to string positive failed * ");
        assertEquals(str_2, to_str2," * Test to string negative failed * ");
        assertEquals("12", test_fraction_6.toString(), " * Test to string where 1 failed * ");
    }
}