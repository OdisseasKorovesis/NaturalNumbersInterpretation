import java.util.ArrayList;
import java.util.Scanner;

public class InitialNumberChecker {

    //elicit an acceptable number from the user
    public String runInitialTests() {
        //retrieve user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a phone number");
        String input = sc.nextLine();
        boolean flag = true;
        while(flag) {
            //if empty String keep asking for input until not empty String is provided
            if(isInputEmpty(input)) {
                System.out.println("You have entered no numbers. Please enter a valid phone number.");
                input = sc.nextLine();
            }
            //if String contains characters other than numbers keep asking for input until valid String is provided
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

    //check for input that contains characters other than numbers and whitespace
    public boolean doesInputContainLetters(String input) {
        if(input.matches("[0-9 ]+"))
            return true;
        else
            return false;
    }

    //check for empty input
    public boolean isInputEmpty(String input) {
        if(input.isEmpty())
            return true;
        else
            return false;
    }

    //convert the number given by the user to a list of Nodes
    public ArrayList<Node> convertNumberIntoListOfNodes(String number) {
        ArrayList<Node> listOfNodesFromNumber = new ArrayList();
        String[] arrayOfNumberDigitGroups = number.split("\\s+");
        for (String digitGroup : arrayOfNumberDigitGroups) {
            listOfNodesFromNumber.add(new Node(Integer.parseInt(digitGroup)));
        }
        return listOfNodesFromNumber;
    }


}
