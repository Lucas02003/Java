# Rational Class Using BigInteger

import java.math.BigInteger;
import java.util.Scanner;

class Rational {
    private BigInteger numerator;
    private BigInteger denominator;

    public Rational(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    private void reduce() {
        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);
    }

    public Rational add(Rational other) {
        BigInteger newNumerator = this.numerator.multiply(other.denominator).add(other.numerator.multiply(this.denominator));
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }

    public Rational subtract(Rational other) {
        BigInteger newNumerator = this.numerator.multiply(other.denominator).subtract(other.numerator.multiply(this.denominator));
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }

    public Rational multiply(Rational other) {
        return new Rational(this.numerator.multiply(other.numerator), this.denominator.multiply(other.denominator));
    }

    public Rational divide(Rational other) {
        return new Rational(this.numerator.multiply(other.denominator), this.denominator.multiply(other.numerator));
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

public class RationalTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first rational number (numerator/denominator): ");
        String[] firstInput = scanner.nextLine().split("/");
        Rational firstRational = new Rational(new BigInteger(firstInput[0]), new BigInteger(firstInput[1]));

        System.out.print("Enter the second rational number (numerator/denominator): ");
        String[] secondInput = scanner.nextLine().split("/");
        Rational secondRational = new Rational(new BigInteger(secondInput[0]), new BigInteger(secondInput[1]));

        System.out.println("First Rational: " + firstRational);
        System.out.println("Second Rational: " + secondRational);
        System.out.println("Addition: " + firstRational.add(secondRational));
        System.out.println("Subtraction: " + firstRational.subtract(secondRational));
        System.out.println("Multiplication: " + firstRational.multiply(secondRational));
        System.out.println("Division: " + firstRational.divide(secondRational));
    }
}
