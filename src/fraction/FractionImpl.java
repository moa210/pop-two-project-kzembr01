package fraction;

public class FractionImpl implements Fraction {

    private int numerator;
    private int denominator;
    private int wholeNumber;
    String fraction;


    /*
     * @inheritDoc
     */
    public FractionImpl(int numerator, int denominator) {
        //      check for precondition
        if (denominator == 0) throwException(1);
        //      normalize and create at positive and negative argument's values
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


    public FractionImpl(int wholeNumber) {
        //      create fraction where single argument's value only
        this.numerator = wholeNumber;
        this.denominator = 1;
    }


    public FractionImpl(String fraction) {
        //      format the argument's string to allow obtaining numerator and denominator values
        String[] arrOfStr = (fraction.replaceAll("\\s", "")).split("/");

        //      check if whole number fraction or two values are passed in the string
        //      if string format different that than expected throws NumberFormatException
        if (arrOfStr.length > 2 || !String.join("", arrOfStr).matches("[-]?[0-9]+[0-9]*([-]?[0-9]+[0-9]*)*")) {
            throwException(0);
        }
        else if (arrOfStr.length > 1){
        //          obtain integer values and check there is no ZERO value set as a denominator
            int n = Integer.parseInt(arrOfStr[0]);
            int d = Integer.parseInt(arrOfStr[1]);
            if (d == 0) throwException(1);
        //          normalize and create when two correct values
            else {
                int gcd = findGCD(n, d);
                this.numerator = n / gcd;
                this.denominator = d / gcd;
            }
        }
        //      create a fraction if whole number only
        else {
            this.numerator = Integer.parseInt(arrOfStr[0]);
            this.denominator = 1;
        }
    }


    /*
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        //      casting object to make methods accessible to it
        FractionImpl fr = (FractionImpl) f;

        //      establish result's Fraction denominator through use of method findLCM
        int newDen =  findLCM(this.denominator, fr.denominator);
        //      establish result's Fraction numerator
        int newNum = newDen/this.denominator*this.numerator + newDen/fr.denominator* fr.numerator;

        return new FractionImpl(newNum, newDen);
    }


    /*
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        //      casting object to make methods accessible to it
        FractionImpl fr = (FractionImpl) f;

        //      establish result's Fraction denominator through use of method findLCM
        int newDen =  findLCM(this.denominator, fr.denominator);
        //      calculate new numerator's value
        int newNum = newDen/this.denominator*this.numerator - newDen/fr.denominator* fr.numerator;

        return new FractionImpl(newNum, newDen);
    }


    /*
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        //      cast object to make methods accessible to it
        FractionImpl fr = (FractionImpl) f;

        //      calculate new numerator's and denominator's values
        int newNum = this.numerator * fr.numerator;
        int newDen =  this.denominator * fr.denominator;

        return new FractionImpl(newNum, newDen);
    }


    /*
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        //      cast object to make methods accessible to it and initialise variables
        FractionImpl fr = (FractionImpl) f;
        int numA = this.numerator;
        int denA = this.denominator;
        int numB = fr.numerator;
        int denB = fr.denominator;

        //      calculate result's Fraction values
        int newNum = numA * denB;
        int newDen =  denA * numB;

        //      check if fraction should return positive or negative value and return
        if (newNum < 0 && newDen < 0)return new FractionImpl(-newNum, -newDen);
        else return new FractionImpl(newNum, newDen);
    }


    /*
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        //      establishing result's Fraction absolute numerator (denominator is a positive)
        int newNum = Math.abs(this.numerator);

        return new FractionImpl(newNum, this.denominator);
    }


    /*
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        //      check if instance of Fraction/ correct argument passed
        if (!(obj instanceof Fraction)) throwException(2);
        else {
        //      compare both objects
            if (obj.toString().equals(this.toString())) result = true;
        }

        return result;
    }


    /*
     * returns: int which is the greatest common divisor of two fractions
     * parameters: takes two int's (numerator and denominator)
     * num1 = num1 % num2
     * if one of the numbers = zero, the other number = GCD
     */
    private int findGCD(int a, int b) {
        //      initiate variables as absolute values
        int gdc = Math.abs(a);
        int secondNum = Math.abs(b);

        //       method calls itself to find the greatest common divisor
        if (secondNum == 0 ) return gdc;
        return findGCD(secondNum , gdc % secondNum);
    }


    /*
     * returns: int as a positive value which is the lowest common multiplier (lcm for two fractions)
     * parameters: takes two int's (denominator a and denominator b)
     * lcm = a*b / greatest common denominator
     */
    private int findLCM(int a, int b) {
        //      method uses finding cgd method to find the lowest common multiplier
        return Math.abs((a*b)/ findGCD(a, b));
    }


    /*
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        //      establishing result's Fraction values by reversing numerator and denominator.
        return new FractionImpl(this.denominator, this.numerator);
    }


    /*
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction f) {
        //      cast object to make methods accessible to it
        FractionImpl fr = (FractionImpl) f;
        int result = 0;

        //      calculate double values of fraction
        double this_ =  (this.getNumerator() * 1.0) / this.getDenominator();
        double other_ = (fr.getNumerator()* 1.0) / fr.getDenominator();

        //      compare both fraction's values
        if (this_ < other_) result = -1;
        else if (this_ > other_) result = 1;

        return result;
    }


    /*
     * @inheritDoc
     */
    @Override
    public String toString() {
        //      obtain numerator and denominator values of fraction
        int n = this.getNumerator();
        int d = this.getDenominator();

        //      return whole number if denominator is equal to ONE, include minus if negative
        if (d == 1) return String.valueOf(n) ;
        if (n <  0) return "-" + Math.abs(n) + "/" + Math.abs(d);
        else return n + "/" + d;
    }


    /*
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        //      creating new fraction by negating numerator's value
        return new FractionImpl(-this.numerator, this.denominator);
    }


    /*
     * Returns: void / throws exceptions
     * parameter(s): x int
     * ArithmeticException if x is 1 (0 used as denominator to initialise Fraction)
     * NumberFormatException if x 0 (wrong format of string passed when initialising object)
     * IllegalArgumentException if x 2 (argument different than expected in methods)
     */
    private void throwException(int x) {
        //      check argument's value and throw exceptions accordingly
        if (x == 0) throw new NumberFormatException("Cannot use this format!");
        else if (x == 1) throw new ArithmeticException("Cannot use ZERO as denominator!");
        else if (x == 2) throw new IllegalArgumentException("Wrong argument passed to the method");
    }


    // no parameter returns integer value of the denominator
    private int getDenominator() {
        return denominator;
    }


    // no return; sets value of the denominator as an  integer
    private void setDenominator(int denominator) {
        this.denominator = denominator;
    }


    //  no parameter returns integer value of the numerator
    private int getNumerator() {
        return numerator;
    }


    // no return; sets value of the numerator as an  integer
    private void setNumerator(int numerator) {
        this.numerator = numerator;
    }


    /*
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }


    /*
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
