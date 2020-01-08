package fraction;

public class FractionImpl implements Fraction {


    /**
     * Parameters are the numerator and the denominator
     * fraction is normalised
     * For instance, if the parameters are (8, -12) , create a Fraction  with numerator
     * -2 and denominator 3 .
     *
     * The constructor should throw an ArithmeticException  if the denominator is zero.
     *
     * */

    private int numerator;
    private int denominator;
    private int wholeNumber;
    String fraction;
//    private Object Fraction;

    public FractionImpl(int numerator, int denominator) {
        if (denominator == 0) throwException(1);
        else {
            int gcd = findGCD(numerator, denominator);
            if (denominator < 0 && numerator < 0) {
                this.numerator = numerator / gcd;
                this.denominator = (denominator * -1) / gcd;
            }
            else if (denominator < 0 && numerator > 0) {
                this.numerator = (numerator * -1) / gcd;
                this.denominator = (denominator * -1) / gcd;
            }
            else {
                this.denominator = denominator / gcd;
                this.numerator = numerator / gcd;
            }
        }
    }

    /**
     * The parameter is the numerator and 1  is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     * */

    public FractionImpl(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    /**
     * The parameter is a String  containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an ArithmeticException
     * if given a string representing a fraction whose denominator is zero.
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     * */

    public FractionImpl(String fraction) {

//        if (denominator == 0) throw new NumberFormatException;
        // TODO
    }

    /**
     * @inheritDoc
     * */

    @Override
    public Fraction add(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     * */

    @Override
    public Fraction subtract(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     * */

    @Override
    public Fraction multiply(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     * */

    @Override
    public Fraction divide(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     * */

    @Override
    public Fraction abs() {
        return null;
    }

    /**
     * @inheritDoc
     * */

    @Override
    public Fraction negate() {
        return null;
    }

    /**
     * @inheritDoc
     * */

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Returns true if o is a Fraction equal to this,
     * and false in all other cases.
     *
     * @param o the object to compare this one to
     * @return whether the true fractions are equal
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if (!(obj instanceof Fraction)) throwException(2);
        else {
            Fraction newFr = (Fraction) obj;
            if (newFr.toString().equals(this.toString())) result = true;
        }

        return result;
    }

    /**
     * returns: int which is greatest common divisor
     * takes two positive value int's (numerator and denominator)
     *
     * larger = larger % smaller
     * if one of the numbers = zero, the other number = GCD
     *
     * */


    private int findGCD(int a, int b) {
        int gdc = Math.abs(a);
        int secondNum = Math.abs(b);

        if (secondNum == 0 ) return gdc;
        return findGCD(secondNum , gdc % secondNum);
//        int smlr;
//        int gdc;
//
//        if (a < b) {
//            gdc = Math.abs(b);
//            smlr = Math.abs(a);
//        }
//        else {
//            gdc = Math.abs(a);
//            smlr = Math.abs(b);
//        }
//        if (smlr == 0 ) return gdc;
//        return findGCD(smlr , gdc % smlr);
//
//    }
    }

    /**
     * @inheritDoc
     * */

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     * */

    @Override
    public Fraction inverse() {
        return null;
    }

    /**
     * Returns:
     * A negative int if this is less than o.
     * Zero if this is equal to o.
     * positive int if this is greater than o.
     **
     * @param f the fraction to compare this to
     * @return the result of the comparison
     * */

    @Override
    public int compareTo(Fraction o) {

        int result = 0;
        double this_ =  (this.getNumerator() * 1.0)/this.getDenominator();
//        double other_ = (o.getNumerator()* 1.0)/o.getDenominator();
//        System.out.println(other_);
//        System.out.println(other_.getNumerator());
//        System.out.println(Double.toString(other_));
//        if (this_ < other_) result = -1;
////        else if (this_ == other_) result = 0;
//        else if (this_ > other_) result = 1;
        return result;
    }

    /**
     * @inheritDoc
     * */

    @Override
    public String toString() {
        int n = this.getNumerator();
        int d = this.getDenominator();
        if (d == 1) return String.valueOf(n) ;
        if (n <  0) return "-" + Math.abs(n) + "/" + Math.abs(d);
        else return n + "/" + d;
    }

    private int getDenominator() {
        return denominator;
    }

    private void setDenominator(int denominator) {
        this.denominator = denominator;
    }
    private int getNumerator() {
        return numerator;
    }

    private void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * Returns: void / throws exceptions
     * ArithmeticException if x is 1 (0 used as denominator to initialise Fraction)
     * NumberFormatException if x 0 (wrong format of string passed to initialise Fraction)
     *
     * @param x int
     *
     * */

    private void throwException(int x) {
        if (x == 0) throw new NumberFormatException("Cannot use this string format!");
        else if (x == 1) throw new ArithmeticException("Cannot use ZERO as denominator!");
        else if (x == 2) throw new IllegalArgumentException("Wrong argument passed to the method");
    }


}
