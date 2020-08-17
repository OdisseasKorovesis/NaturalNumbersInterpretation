import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        getCombinationsAndValidate();
    }

    public static void getCombinationsAndValidate() {
        InitialNumberChecker inChecker = new InitialNumberChecker();
        String input = inChecker.runInitialTests();
        ArrayList<Node> nodeListFromNo = new ArrayList(inChecker.convertNumberIntoListOfNodes(input));

        //set dummy Node as root which will be redacted later
        //in order to be able to analyze first real node if necessary (i.e. 69 must be analyzed to 60 9)
        Node root = new Node(0);

        List<List<Node>> combinationsList = root.getAllCombinationsFromList(nodeListFromNo, root, inChecker.getLeadingZeroesCount());


    }
}
