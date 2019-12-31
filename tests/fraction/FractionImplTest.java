package fraction;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class FractionImplTest {

       FractionImpl test_fraction_1 = new FractionImpl(8,3);
       FractionImpl test_fraction_2 = new FractionImpl(2, 4);
       FractionImpl test_fraction_3 = new FractionImpl(13,6);
       FractionImpl test_fraction_4 = new FractionImpl(19, 6);
       FractionImpl test_fraction_5 = new FractionImpl(4,3);


    @Test
    void throwsException() {
        try {
            FractionImpl test_fraction_3 = new FractionImpl(2, 0);
        }
        catch (ArithmeticException e) {
            assertThat("* assertion error not thrown *", e.getMessage(), is("Cannot use ZERO as denominator!"));
        }
    }

    @Test
    void add() {
        Fraction add_1 =  test_fraction_1.add(test_fraction_2);
        Fraction add_2 = test_fraction_2.add(test_fraction_3);
        Assert.assertEquals(" * Test for addition1 failed * ", test_fraction_4, add_1);
        Assert.assertEquals(" * Test for addition2 failed * ", test_fraction_1, add_2);

    }

    @Test
    void subtract() {
//        Assert.fail(" * Test for subtracting failed * ");
        Fraction sub_1 =  test_fraction_1.subtract(test_fraction_2);
        Fraction sub_2 = test_fraction_2.subtract(test_fraction_1);
        Assert.assertEquals("Test for subtraction1 failed", test_fraction_3, sub_1);
        Assert.assertEquals("Test for subtraction2 failed", test_fraction_3, sub_2);
    }

    @Test
    void multiply() {
        Fraction mult_1 =  test_fraction_1.subtract(test_fraction_2);
        Fraction mult_2 = test_fraction_2.subtract(test_fraction_3);
        Assert.assertEquals(" * Test for multiplying1 failed * ", test_fraction_5, mult_1);
         Assert.assertEquals(" * Test for multiplying2 failed * ", new FractionImpl(13,12), mult_2);

    }

    @Test
    void divide() {
        Assert.fail();
        Fraction div_1 =  test_fraction_1.subtract(test_fraction_2);
        Fraction div_2 = test_fraction_2.subtract(test_fraction_3);
        Assert.assertEquals(" * Test for division1 failed * ",new FractionImpl(16,3), div_1);
        Assert.assertEquals(" * Test for division2 failed * ", new FractionImpl(3,13), div_2);

    }

    @Test
    void abs() {
    }

    @Test
    void negate() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testClone() {
    }

    @Test
    void inverse() {
    }

    @Test
    void compareTo() {
    }

    @Test
    void testToString() {
    }
}