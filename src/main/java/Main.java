import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        getCombinationsAndValidate();
    }

    public static void getCombinationsAndValidate() {
        InitialNumberChecker inChecker = new InitialNumberChecker();
        String input = inChecker.runInitialTests();
        ArrayList<Node> nodeListFromNo = new ArrayList(inChecker.convertNumberIntoListOfNodes(input));
        Node root = nodeListFromNo.get(0);
        nodeListFromNo.remove(0);
        root.getAllCombinationsFromList(nodeListFromNo, root, inChecker.getLeadingZeroesCount());

    }
}
