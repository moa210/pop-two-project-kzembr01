import fraction.Fraction;
import fraction.FractionImpl;

import java.util.Scanner;

/**
 * class Main uses the Fraction implementation to perform simple calculations as directed by the user
 * class Main invokes the super-class' constructors
 */


class Main extends FractionImpl {

    private Main(int numerator, int denominator) {
        super(numerator, denominator);
    }

    private Main(int wholeNumber) {
        super(wholeNumber);
    }

    private Main(String fraction) {
        super(fraction);
    }


    /**
     * void main class used as interface of the programme FractionImpl
     * '@param args'
     */
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        final Scanner myObj = new Scanner(System.in);
        System.out.print("What's the fraction you'd like to start with: ");
        // Read user input; fraction, math operator, 2nd fraction
        Fraction fraction = new FractionImpl(myObj.nextLine());
        System.out.print("What type of operation you'd like to perform? (use: - / * + < or =)? ");

        String method = myObj.nextLine();
        System.out.print("And your 2nd fraction? ");

        Fraction fraction2 = new FractionImpl(myObj.nextLine());

        final String methodQuestion = "What's your next operation? (use: - / * + < = or 'end') ";
        final String fractionQuestion = "And your new fraction? ";
        final String resultStr = " (result used for your next operation)";

        // loops operation based on user input; finishes on 'end' or when exception is thrown (i.e. ZERO passed as denominator)
        // actions based on operation's parameter as instructed by the user - tested via switch statement against input/ chosen math operators
        while (!method.equals("end")) {
            switch (method) {
                case "-":
                    System.out.print(fraction + " - " + fraction2 + " = ");
                    fraction = fraction.subtract(fraction2);
                    System.out.println(fraction + resultStr);
                    System.out.print(methodQuestion);
                    method = myObj.nextLine();
                    if (!method.equals("end")) {
                        System.out.print(fractionQuestion);
                        fraction2 = new FractionImpl(myObj.nextLine());
                    }
                    break;
                case "/":
                    System.out.print(fraction + " / " + fraction2 + " = ");
                    fraction = fraction.divide(fraction2);
                    System.out.println(fraction + resultStr);
                    System.out.print(methodQuestion);
                    method = myObj.nextLine();
                    if (!method.equals("end")) {
                        System.out.print(fractionQuestion);
                        fraction2 = new FractionImpl(myObj.nextLine());
                    }
                    break;
                case "*":
                    System.out.print(fraction + " * " + fraction2 + " = ");
                    fraction = fraction.multiply(fraction2);
                    System.out.println(fraction + resultStr);
                    System.out.print(methodQuestion);
                    method = myObj.nextLine();
                    if (!method.equals("end")) {
                        System.out.print(fractionQuestion);
                        fraction2 = new FractionImpl(myObj.nextLine());
                    }
                    break;
                case "+":
                    System.out.print(fraction + " + " + fraction2 + " = ");
                    fraction = fraction.add(fraction2);
                    System.out.println(fraction + resultStr);
                    System.out.print(methodQuestion);
                    method = myObj.nextLine();
                    if (!method.equals("end")) {
                        System.out.print(fractionQuestion);
                        fraction2 = new FractionImpl(myObj.nextLine());
                    }
                    break;
                case "=":
                    boolean result = fraction.equals(fraction2);
                    if (result) System.out.println(fraction + " == " + fraction2);
                    else System.out.println(fraction + " != " + fraction2 + resultStr);
                    System.out.print("And your next operation (use: - / * + < = or 'end')? ");
                    method = myObj.nextLine();
                    if (!method.equals("end")) {
                        System.out.print(fractionQuestion);
                        fraction = fraction2;
                        fraction2 = new FractionImpl(myObj.nextLine());
                    }
                    break;
                case "<":
                    int result1 = fraction.compareTo(fraction2);
                    if (result1 < 0) System.out.println(fraction + " < " + fraction2);
                    else if (result1 > 0) System.out.println(fraction + " > " + fraction2);
                    else System.out.println(fraction + " == " + fraction2 + resultStr);
                    System.out.print("What's your next operation (use: - / * + < = or 'end')? ");
                    method = myObj.nextLine();
                    if (!method.equals("end")) {
                        System.out.print(fractionQuestion);
                        fraction = fraction2;
                        fraction2 = new FractionImpl(myObj.nextLine());
                    }
                    break;
                default:
                    System.out.print("That fraction will be used * BUT * you gave a wrong operator; use: - / * + or 'end' ");
                    method = myObj.nextLine();
                    break;
            }
        }
    }
}
