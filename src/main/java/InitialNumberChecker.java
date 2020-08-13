import java.util.Scanner;

public class InitialNumberChecker {

    public String runInitialTests() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a phone number");
        String input = sc.nextLine();
        boolean flag = true;
        while(flag) {
            if(isInputEmpty(input)) {
                System.out.println("You have entered no numbers. Please enter a valid phone number.");
                input = sc.nextLine();
            }
            else if(!doesInputContainLetters(input)) {
                System.out.println("A phone number cannot contain letters, please enter a valid phone number.");
                input = sc.nextLine();
            } else {
                flag = false;
            }
        }
        sc.close();
        System.out.println("The phone number you have entered is: " + input);
        return input;
    }

    public boolean doesInputContainLetters(String input) {
        if(input.matches("[0-9 ]+"))
            return true;
        else
            return false;
    }

    public boolean isInputEmpty(String input) {
        if(input.isEmpty())
            return true;
        else
            return false;
    }


}
