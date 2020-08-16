public class Utilities {

    //remove whitespace from a string
    public static String removeWhiteSpace(String input) {
        input = input.replaceAll("\\s+", "");
        return input;
    };

    //retrieve x amount of beginning digits of a number
    public static String getDigitsOfNo(int numberOfDigits, String phoneNumber) {
        String numberNoSpace = Utilities.removeWhiteSpace(phoneNumber);
        String requiredDigits = numberNoSpace.substring(0, numberOfDigits);
        return requiredDigits;
    }

    public static int getLeadingZeroesCount(String number) {
        String numberNoWhiteSpace = Utilities.removeWhiteSpace(number);
        int leadingZeroesCount = numberNoWhiteSpace.length() - numberNoWhiteSpace.replaceAll("^0+", "").length();
        return leadingZeroesCount;
    }
}
