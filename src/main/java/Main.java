public class Main {

    public static void main(String[] args) {
       String input = initializeProcess();

//        String phone = "21052 67 28 969";
//        String groupDigits[] = phone.split("\\s+");
//        for (String digits : groupDigits) {
//            StringBuilder sb = new StringBuilder();
//            sb.append(digits);
//            sb.reverse();
//            String reversed = sb.toString();
//            for(int i = 0; i < reversed.toCharArray().length; i++) {
//                System.out.print(reversed.toCharArray()[i] + " ");
//                for(int j = 0; j < i; j++) {
//                    System.out.print("0");
//                }
//                System.out.println(" ");
//            }
//            System.out.println(" ");
//        }
    }

    public static String initializeProcess() {
        InitialNumberChecker inChecker = new InitialNumberChecker();
        String input = inChecker.runInitialTests();
        Validator val = new Validator(input);
        val.displayValidityMessage();
        return input;
    }
}
