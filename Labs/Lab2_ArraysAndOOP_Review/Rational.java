public class Rational { 

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
 this(numerator, 1);
    }

    public Rational(int numerator, int denominator) {
 if (denominator < 0) {
     denominator = -1 * denominator;
     numerator = -1 * numerator;
 }
 this.numerator = numerator;
 this.denominator = denominator;
 reduce();
    }

    // getters

    public int getNumerator() {
 return numerator;
    }

    public int getDenominator() {
 return denominator;
    }

    // instance methods

    public Rational plus(Rational other) {
 int newDenominator = denominator * other.denominator;
 int newNumerator = numerator * other.denominator;
 int newOtherNumerator = other.numerator * denominator;
 int sum = newNumerator + newOtherNumerator;
 return new Rational(sum, newDenominator);
    }

    public static Rational plus(Rational a, Rational b) {
 return a.plus( b );
    }

    // Transforms this number into its reduced form

    private void reduce() {
 if (numerator == 0) {
     denominator = 1;
 } else {
     int common = gcd(Math.abs(numerator), denominator);
     numerator = numerator/common;
     denominator = denominator/common;
 }
    }

    // Euclid's algorithm for calculating the greatest common divisor

    private int gcd(int a, int b) {
 while (a != b)
     if (a > b)
  a = a - b;
     else
  b = b - a;
 return a;
    }

    public int compareTo(Rational other) {

 int thisNewNum = other.denominator * numerator;
 int otherNewNum = other.numerator * denominator;

 return thisNewNum - otherNewNum;

    }

    public boolean equals(Rational other) {

 if (numerator == other.numerator && denominator == other.denominator)
     return true;
 else
     return false;
    }

    public String toString() {
 String result;
 if (denominator == 1) {
     result = Integer.toString(numerator);
 } else {
     result = numerator + "/" + denominator;
 }
 return result;
    }

}