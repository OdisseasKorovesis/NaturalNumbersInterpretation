public class Validator {

    private String phoneNumber;

    public Validator(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean displayValidityMessage() {
        if (checkNoValidity()) {
            System.out.println("[valid number]");
            return true;
        } else {
            System.out.println("[invalid number]");
            return false;
        }
    }

    private boolean checkNoValidity() {
        String numberToBeChecked = removeWhiteSpace(this.phoneNumber);
        char[] phoneNumberAsArr = numberToBeChecked.toCharArray();

        if (phoneNumberAsArr.length == 10) {
            if (getDigitsOfNo(1).equals("2") || getDigitsOfNo(2).equals("69")) {
                return true;
            }
        } else if (phoneNumberAsArr.length == 14) {
            if (getDigitsOfNo(5).equals("00302") || getDigitsOfNo(6).equals("003069")) {
                return true;
            }
        }
        return false;
    }

    private String getDigitsOfNo(int numberOfDigits) {
        String numberNoSpace = removeWhiteSpace(this.phoneNumber);
        String requiredDigits = numberNoSpace.substring(0, numberOfDigits);
        return requiredDigits;
    }

    public String removeWhiteSpace(String input) {
        input = input.replaceAll("\\s+", "");
        return input;
    }


}