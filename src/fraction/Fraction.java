package fraction;

/**
 * Representing fractions of the form numerator and denominator
 * The object should be immutable.
 */
public interface Fraction extends Comparable<Fraction> {

    /**
     * Returns a new Fraction that is the sum of this and the parameter:
     *  a/b + c/d is (ad + bc)/bd
     *
     * @param f the fraction to add to the current fraction
     * @return the result of the addition
     */
    public Fraction add(Fraction f);

    /**
     * Returns a new Fraction that is the difference of this minus the parameter
     * a/b - c/d is (ad - bc)/bd
     *
     * @param f the fraction to subtract from the current fraction
     * @return the result of the subtraction
     */
    public Fraction subtract(Fraction f);

    /**
     * Returns a new Fraction that is the product of this and the parameter
     * (a/b) * (c/d) is (a*c)/(b*d)
     *
     * @param f the fraction to multiply with the current fraction
     * @return the result of the multiplication
     */
    public Fraction multiply(Fraction f);

    /**
     * Returns a new Fraction that is the quotient of dividing this by the parameter
     * (a/b) / (c/d) is (a*d)/(b*c)
     *
     * @param f the fraction to take part in the division
     * @return the result of the division
     */
    public Fraction divide(Fraction f);

    /**
     * Returns a new Fraction that is the absolute value of this fraction
     *
     * @return the absolute value of the fraction as a new fraction
     */
    public Fraction abs();

    /**
     * Returns a new Fraction that has the same numeric value of this fraction,
     * but the opposite sign.
     *
     * @return the newly negated fraction
     */
    public Fraction negate();

    /**
     * The inverse of a/b is b/a.
     *
     * @return the newly inverted fraction
     */
    public Fraction inverse();

    /**
     * Returns true if o is a Fraction equal to this,
     * and false in all other cases.
     *
     * @param o the object to compare this one to
     * @return whether the true fractions are equal
     */
    @Override
    public boolean equals(Object o);

    /**
     * Returns:
     * <ul>
     *     <li>A negative int if this is less than o.</li>
     *     <li>Zero if this is equal to o.</li>
     *     <li>A positive int if this is greater than o.</li>
     * </ul>
     *
     * @param f the fraction to compare this to
     * @return the result of the comparison
     */
    @Override
    public int compareTo(Fraction f);

    /**
     * Returns a String of the form n/d, where n is the
     * numerator and d is the denominator.
     * However, if d is 1, just return n (as a String).
     *
     * The returned String should not contain any blanks.
     * If the fraction represents a negative number, a minus sign should precede n
     *
     * @return the string representation fo the fraction
     */
    @Override
    public String toString();
}
