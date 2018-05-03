package BigIntegerPackage;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise13_15 {

    public static void main(String[] args) {
    // Enter two Rational numbers
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first rational number: ");
        String n1 = input.next();
        String d1 = input.next();
        Rational r1 = new Rational(new BigInteger(n1), new BigInteger(d1));

        System.out.print("Enter the second rational number: ");
        String n2 = input.next();
        String d2 = input.next();
        Rational r2 = new Rational(new BigInteger(n2), new BigInteger(d2));

        // show results
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        System.out.println(r2 + " is " + r2.doubleValue());
    }
}

    class Rational extends Number{
        // Data fields for numerator and denominator
        private BigInteger[] r = new BigInteger[2];

        /** Construct a ratinoal with 0 and 1 by default */
        public Rational() {
            this(new BigInteger("0"), new BigInteger("1"));
        }
        /** Construct a rational with specifiec numerator and denominator */
        public Rational(BigInteger numerator, BigInteger denominator) {
            BigInteger gcd = gcd(numerator, denominator);
            r[0] = (denominator.compareTo(BigInteger.ZERO) > 0
                    ? BigInteger.ONE :
                    new BigInteger("-1")).multiply(numerator.divide(gcd));
            r[1] = denominator.divide(gcd);
        }
        /** Find GCD of two numbers */
        private static BigInteger gcd(BigInteger n, BigInteger d) {
            BigInteger n1 = n;
            BigInteger n2 = d;
            BigInteger gcd = BigInteger.ONE;
            for (BigInteger k = BigInteger.ONE;
                 k.compareTo(n1) <= 0 && k.compareTo(n2) <= 0;
                 k = k.add(BigInteger.ONE)) {
                if (n1.remainder(k).compareTo(BigInteger.ZERO) == 0 &&
                        n2.remainder(k).compareTo(BigInteger.ZERO) == 0)
                    gcd = k;
            }
            return gcd;
        }
        /** Return numerator */
        public BigInteger getNumerator() {
            return r[0];
        }
        /** Return denominator */
        public BigInteger getDenominator() {
            return r[1];
        }
        /** Add a rational number to this rational */
        public Rational add(Rational secondRational) {
            BigInteger n = (r[0].multiply(secondRational.getDenominator())).add(
                    r[1].multiply(secondRational.getNumerator()));
            BigInteger d = r[1].multiply(secondRational.getDenominator());
            return new Rational(n, d);
        }
        /** Subtract a rational number from this rational */
        public Rational subtract(Rational secondRational) {
            BigInteger n = (r[0].multiply(secondRational.getDenominator())).subtract(
                    r[1].multiply(secondRational.getNumerator()));
            BigInteger d = r[1].multiply(secondRational.getDenominator());
            return new Rational(n, d);
        }
        /** Mulitply a rational number by this rational */
        public Rational multiply(Rational secondRational) {
            BigInteger n = r[0].multiply(secondRational.getNumerator());
            BigInteger d = r[1].multiply(secondRational.getDenominator());
            return new Rational(n, d);
        }

        /** Divide a rational number by this rational */
        public Rational divide(Rational secondRational) {
            BigInteger n = r[0].multiply(secondRational.getDenominator());
            BigInteger d = r[1].multiply(secondRational.getNumerator());
            return new Rational(n, d);
        }

        @Override
        public String toString() {
            if (r[1].compareTo(BigInteger.ONE) == 0)
                return r[0] + "";
            else
                return r[0] + "/" + r[1];
        }

        @Override // Override the equals method in the Object class
        public boolean equals(Object other) {
            if (((this.subtract((Rational)(other))).getNumerator()).compareTo(
                    BigInteger.ZERO) == 0)
                return true;
            else
                return false;
        }

        @Override // Implement the abstract intValue method in Number
        public int intValue() {
            return (int)doubleValue();
        }

        @Override // Implement the abstract floatValue method in Number
        public float floatValue() {
            return (float)doubleValue();
        }

        @Override // Implement the doubleValue method in Number
        public double doubleValue() {
            return this.getNumerator().doubleValue() /
                    this.getDenominator().doubleValue();
        }

        @Override // Implement the abstract longValue method in Number
        public long longValue() {
            return (long) doubleValue();
        }

    }