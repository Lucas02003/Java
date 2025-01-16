public class Main {

 public static void main(string[] args)  

 Scanner scanner = new Scanner(system.in);
system.out.print("Enter a credit card number as a long integer: ");
long number = scanner.nextLong();

if(isValid(number)) {
    system.out.println(number + " is  valid.");
}else{
    system.out.println(number + " is invalid.");

    /** Return true if the card number is valid */
    public static boolean isValid(long number) {
        return (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0;
    }

    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String numStr = Long.toString(number);
        for (int i = numStr.length() - 2; i >= 0; i -= 2) {
            sum += getDigit(Character.getNumericValue(numStr.charAt(i)));
        }
        return sum;
    }

    /** Return this number if it is a single digit, otherwise,
     * return the sum of the two digits */
    public static int getDigit(int number) {
        if (number < 10) {
            return number;
        } else {
            return number / 10 + number % 10;
        }
    }

    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String numStr = Long.toString(number);
        for (int i = numStr.length() - 1; i >= 0; i -= 2) {
            sum += Character.getNumericValue(numStr.charAt(i));
        }
        return sum;
    }

    /** Return true if the number d is a prefix for number */
    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    /** Return the number of digits in d */
    public static int getSize(long d) {
        return Long.toString(d).length();
    }

    /** Return the first k number of digits from number. If the
     * number of digits in number is less than k, return number. */
    public static long getPrefix(long number, int k) {
        String numStr = Long.toString(number);
        return Long.parseLong(numStr.substring(0, Math.min(k, numStr.length())));
    }
}
}
