import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        getCombinationsAndValidate();

    }

    public static String initializeProcess() {
        InitialNumberChecker inChecker = new InitialNumberChecker();
        String input = inChecker.runInitialTests();
        Validator val = new Validator(input);
        val.displayValidityMessage();
        return input;
    }

    public static void getCombinationsAndValidate() {
        String input = initializeProcess();
        InitialNumberChecker inChecker = new InitialNumberChecker();
        ArrayList<Node> nodeListFromNo = new ArrayList(inChecker.convertNumberIntoListOfNodes(input));
        Node root = nodeListFromNo.get(0);
        nodeListFromNo.remove(0);
        root.getAllCombinationsFromList(nodeListFromNo, root);

    }
}
