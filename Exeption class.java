// Custom Exception Class
class BinaryFormatException extends Exception {
    public BinaryFormatException(String message) {
        super(message);
    }
}

// Method to convert binary string to decimal
public class BinaryConverter {
    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        // Validate the binary string
        for (char c : binaryString.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new BinaryFormatException("Invalid binary string: " + binaryString);
            }
        }

        // Convert binary to decimal
        int decimalValue = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            decimalValue = decimalValue * 2 + (binaryString.charAt(i) - '0');
        }
        return decimalValue;
    }

    public static void main(String[] args) {
        try {
            System.out.println(bin2Dec("1010")); // Valid binary
            System.out.println(bin2Dec("1020")); // Invalid binary
        } catch (BinaryFormatException e) {
            System.err.println(e.getMessage());
        }
    }
}