import java.util.ArrayList;
import java.util.Scanner;

public class InitialNumberChecker {

    private int leadingZeroesCount = 0;

    public int getLeadingZeroesCount() {
        return leadingZeroesCount;
    }

    public void setLeadingZeroesCount(int leadingZeroesCount) {
        this.leadingZeroesCount = leadingZeroesCount;
    }

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
            //if String contains a digit grouping of more than three digits keep asking for input until valid String is provided
            } else if (!doesInputContainOnlyThreeDigitGroupings(input)){
                System.out.println("A phone number can contain digit groupings of only up to 3 digits, please enter a valid phone number.");
                input = sc.nextLine();
            } else {
                flag = false;
            }
        }
        sc.close();
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

    //check if user has provided digit groupings with more than 3 digits
    public boolean doesInputContainOnlyThreeDigitGroupings(String input) {
        String[] arrayOfNumberDigitGroups = input.split("\\s+");
        boolean doesContain = true;
        for (String digitGroup: arrayOfNumberDigitGroups) {
            if(digitGroup.length() > 3) {
                doesContain = false;
            }
        }
        return doesContain;
    }

    //convert the number given by the user to a list of Nodes
    public ArrayList<Node> convertNumberIntoListOfNodes(String number) {
        ArrayList<Node> listOfNodesFromNumber = new ArrayList();

        //check if number has leading zeroes which will be lost in the Node conversion process and keep count of them
        int leadingZeroesCount = Utilities.getLeadingZeroesCount(number);
        setLeadingZeroesCount(leadingZeroesCount);

        //remove all leading zeroes from the number since they will be added later on
        while(number.charAt(0) == '0') {
            number = number.replaceFirst("^0+(?!$)", "");
            number = number.trim();
        }

        String[] arrayOfNumberDigitGroups = number.split("\\s+");
        for (String digitGroup : arrayOfNumberDigitGroups) {
            listOfNodesFromNumber.add(new Node(Integer.parseInt(digitGroup)));
        }
        return listOfNodesFromNumber;
    }


}
