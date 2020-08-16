public class Validator {

    private String phoneNumber;

    public Validator(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //display appropriate message depending on number validity
    public boolean displayValidityMessage() {
        if (checkNoValidity()) {
            System.out.println(" [valid number]");
            return true;
        } else {
            System.out.println(" [invalid number]");
            return false;
        }
    }

    //check if number is a valid Greek phone number
    public boolean checkNoValidity() {
        String numberToBeChecked = Utilities.removeWhiteSpace(this.phoneNumber);
        char[] phoneNumberAsArr = numberToBeChecked.toCharArray();

        if (phoneNumberAsArr.length == 10) {
            if (Utilities.getDigitsOfNo(1, this.phoneNumber).equals("2") || Utilities.getDigitsOfNo(2, this.phoneNumber).equals("69")) {
                return true;
            }
        } else if (phoneNumberAsArr.length == 14) {
            if (Utilities.getDigitsOfNo(5, this.phoneNumber).equals("00302") || Utilities.getDigitsOfNo(6, this.phoneNumber).equals("003069")) {
                return true;
            }
        }
        return false;
    }






}