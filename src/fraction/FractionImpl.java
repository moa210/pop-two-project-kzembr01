package fraction;
public class FractionImpl implements Fraction {


    /**
     * Parameters are the numerator and the denominator
     * fraction is normalised
     * For instance, if the parameters are (8, -12) , create a Fraction  with numerator
     * -2 and denominator 3 .
     * The constructor throws an ArithmeticException  if the denominator is zero.
     * */

    private int numerator;
    private int denominator;
    private int wholeNumber;
    String fraction;


    public FractionImpl(int numerator, int denominator) {
//        check for precondition
        if (denominator == 0) throwException(1);

//        normalize and create at positive and negative argument's values
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
     * The parameter is the numerator and 1 is the implicit denominator.
     * parameter(s): wholeNumber representing the numerator
     * */

    public FractionImpl(int wholeNumber) {
//        create fraction where single argument's value only
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
     * parameter(s): fraction the string representation of the fraction
     * */

    public FractionImpl(String fraction) {
//        format string to allow obtaining numerator and denominator values from the argument's string
        String[] arrOfStr = (fraction.replaceAll("\\s", "")).split("/");

//        check if whole number fraction or two values passed in string
        if (arrOfStr.length > 1){
//            obtain integer values and check there is no ZERO as denominator
            int n = Integer.parseInt(arrOfStr[0]);
            int d = Integer.parseInt(arrOfStr[1]);
            if (d == 0) throwException(1);
//            normalize and create when two values
            else {
                int gcd = findGCD(n, d);
                this.numerator = n / gcd;
                this.denominator = d / gcd;
            }
        }
//        create a fraction if whole number only
        else {
            this.numerator = Integer.parseInt(arrOfStr[0]);
            this.denominator = 1;
        }
    }


    /**
     * @inheritDoc
     * */

    @Override
    public Fraction add(Fraction f) {
//        casting object to make methods accessible to it
        FractionImpl fr = (FractionImpl) f;

//        establish result's Fraction denominator through use of method findLCM
        int newDen =  findLCM(this.denominator, fr.denominator);
//        establish result's Fraction numerator
        int newNum = newDen/this.denominator*this.numerator + newDen/fr.denominator* fr.numerator;

        return new FractionImpl(newNum, newDen);
    }


    /**
     * @inheritDoc
     * */

    @Override
    public Fraction subtract(Fraction f) {
//        casting object to make methods accessible to it
        FractionImpl fr = (FractionImpl) f;

//        establish result's Fraction denominator through use of method findLCM
        int newDen =  findLCM(this.denominator, fr.denominator);
//        calculate new numerator's value
        int newNum = newDen/this.denominator*this.numerator - newDen/fr.denominator* fr.numerator;

        return new FractionImpl(newNum, newDen);
    }


    /**
     * @inheritDoc
     * */

    @Override
    public Fraction multiply(Fraction f) {
//        cast object to make methods accessible to it
        FractionImpl fr = (FractionImpl) f;

//        calculate new numerator's value
        int newNum = this.numerator * fr.numerator;
//        calculate new denominator's value
        int newDen =  this.denominator * fr.denominator;

        return new FractionImpl(newNum, newDen);
    }


    /**
     * @inheritDoc
     * */

    @Override
    public Fraction divide(Fraction f) {
//        cast object to make methods accessible to it and set variables
        FractionImpl fr = (FractionImpl) f;
        int numA = this.numerator;
        int denA = this.denominator;
        int numB = fr.numerator;
        int denB = fr.denominator;

//        calculate result's Fraction values
        int newNum = numA * denB;
        int newDen =  denA * numB;

//        check if fraction should return positive or negative value and return
        if (newNum < 0 && newDen < 0)return new FractionImpl(-newNum, -newDen);
        else return new FractionImpl(newNum, newDen);
    }


    /**
     * @inheritDoc
     * */

    @Override
    public Fraction abs() {
//        establishing result's Fraction numerator (denominator is positive = unchanged)
        int newNum = Math.abs(this.numerator);

        return new FractionImpl(newNum, this.denominator);
    }


    /**
     * @inheritDoc
     * */

    @Override
    public Fraction negate() {
//        creating result's Fraction by negating numerator's value
        return new FractionImpl(-this.numerator, this.denominator);
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
     * parameter(s): o the object to compare this one to
     * @return whether the true fractions are equal
     */

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
//        check if instance of Fraction/ correct argument passed
        if (!(obj instanceof Fraction)) throwException(2);
        else {
//            compare both objects
            if (obj.toString().equals(this.toString())) result = true;
        }

        return result;
    }


    /**
     * returns: int which is greatest common divisor
     * parameters: takes two int's (numerator and denominator)
     * num1 = num1 % num2
     * if one of the numbers = zero, the other number = GCD
     * */

    private int findGCD(int a, int b) {
//        set variables at absolute values
        int gdc = Math.abs(a);
        int secondNum = Math.abs(b);

//         method calls itself to find the greatest common denominator
        if (secondNum == 0 ) return gdc;
        return findGCD(secondNum , gdc % secondNum);
    }

    /**
     * returns: int at positive value which is the lowest common multiplier (lcm)
     * parameters: takes two int's (denominator a and denominator b)
     * lcm = a*b / greatest common denominator
     * */

    private int findLCM(int a, int b) {
//        method uses finding cgd method to find the lowest common multiplier
        return Math.abs((a*b)/ findGCD(a, b));
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
//        establishing result's Fraction values by reversing num. and denom.
        return new FractionImpl(this.denominator, this.numerator);
    }


    /**
     * Returns:
     * A negative int if this is less than f.
     * Zero if this is equal to f.
     * positive int if this is greater than f
     * parameter(s): f the fraction to compare this to
     * @return the result of the comparison
     * */

    @Override
    public int compareTo(Fraction f) {
//        cast object to make methods accessible to it
        FractionImpl fr = (FractionImpl) f;
        int result = 0;

//        calculate double values of fraction
        double this_ =  (this.getNumerator() * 1.0) / this.getDenominator();
        double other_ = (fr.getNumerator()* 1.0) / fr.getDenominator();

//        compare both values
        if (this_ < other_) result = -1;
        else if (this_ > other_) result = 1;

        return result;
    }


    /**
     * @inheritDoc
     * */

    @Override
    public String toString() {
//        obtain numerator and denominator values of fraction
        int n = this.getNumerator();
        int d = this.getDenominator();

//        return whole number if denominator is equal to ONE, include minus if negative
        if (d == 1) return String.valueOf(n) ;
        if (n <  0) return "-" + Math.abs(n) + "/" + Math.abs(d);
        else return n + "/" + d;
    }


//    returns integer value of the denominator
    private int getDenominator() {
        return denominator;
    }


//    sets value of the denominator as an  integer
    private void setDenominator(int denominator) {
        this.denominator = denominator;
    }


//    returns integer value of the numerator
    private int getNumerator() {
        return numerator;
    }


//    sets value of the numerator as an  integer
    private void setNumerator(int numerator) {
        this.numerator = numerator;
    }


    /**
     * Returns: void / throws exceptions
     * ArithmeticException if x is 1 (0 used as denominator to initialise Fraction)
     * NumberFormatException if x 0 (wrong format of string passed to initialise Fraction)
     * parameter(s): x int
     *
     * */

    private void throwException(int x) {
//        check argument's value and throw exceptions accordingly
        if (x == 0) throw new NumberFormatException("Cannot use this string format!");
        else if (x == 1) throw new ArithmeticException("Cannot use ZERO as denominator!");
        else if (x == 2) throw new IllegalArgumentException("Wrong argument passed to the method");
    }

}
