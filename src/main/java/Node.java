import java.util.*;

public class Node {

    private Integer value = null;
    private List<Node> children = new ArrayList();
    private Node parent = null;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    //add children to nodes recursively
    public Node addChild(Node child) {

        //if number is up to 13 it cannot yield possible combinations
        //so it is immediately added as child
        if (child.value < 13) {
            child.setParent(this);
            this.children.add(child);

        //if number is more than 13 it can yield possible combinations
        } else if (child.value >= 13 && child.value < 100) {

            //firstly we set the number itself as a child
            child.setParent(this);
            this.children.add(child);

            //then we set the tens place value as a child
            //and we keep the remainder
            int tensPlaceValue = child.value - (child.value % 10);
            int remainder = child.value % 10;
            Node tensNode = new Node(tensPlaceValue);
            tensNode.setParent(this);
            this.children.add(tensNode);

            //we use recursion in order to add the remainder
            Node remainderNode = new Node(remainder);
            tensNode.addChild(remainderNode);

        //if number is more than 100 it can yield more possible combinations
        } else if (child.value >= 100) {

            //set itself as child
            child.setParent(this);
            this.children.add(child);

            //set its hundreds place value and use recursion to add the remainder
            int hundredsPlaceValue = child.value - (child.value % 100);
            int hundredsRemainder = child.value % 100;
            Node hundredsNode = new Node(hundredsPlaceValue);
            hundredsNode.setParent(this);
            this.children.add(hundredsNode);
            Node hundredsRemainderNode = new Node(hundredsRemainder);
            hundredsNode.addChild(hundredsRemainderNode);

            //repeat the above mentioned process for its tens place value
            int tensPlaceValue = child.value - (child.value % 10);
            int tensRemainder = child.value % 10;
            Node tensNode = new Node(tensPlaceValue);
            tensNode.setParent(this);
            this.children.add(tensNode);

            //χρησιμοποιούμε αναδρομή για το υπόλοιπο
            Node tensRemainderNode = new Node(tensRemainder);
            tensNode.addChild(tensRemainderNode);


        }

        return child;
    }

    //print tree structure
    public void printTree(Node node, String appender) {
        System.out.println(appender + node.getValue());
        for (Node child :
                node.getChildren()) {
            child.printTree(child, appender + appender);
        }
    }

    //print all possible interpretations of given list of nodes and validate them as Greek phone numbers
    public List<List<Node>> getAllCombinationsFromList(ArrayList<Node> listOfNodes, Node root) {
        System.out.println();

        //loop through given list of nodes adding each subsequent element
        //only to the leaf nodes of the tree to create the final tree
        for (Node node : listOfNodes) {
            Set<Node> leafNodes = root.getAllLeafNodes();
            for (Node leafNode : leafNodes) {
                leafNode.addChild(node);
            }
        }

        //initialize counter for number of combinations
        int interpretationCounter = 1;

        //retrieve all root to leaf paths (i.e. all possible combinations)
        List<List<Node>> lists = getPaths(root);

        //loop through each combination
        for (List<Node> list : lists) {
            //initialize an array with length equal to the nodes of the current combination
            String[] possibleNo = new String[list.size()];
            //print the count of interpretations that have been made
            System.out.print("Interpretation " + interpretationCounter + ": " );
            //loop through all the nodes of the current combination
            for (int count = 0; count < list.size(); count++) {
                //print its value
                System.out.print(list.get(count).getValue());
                //add its value to the array of the current combination
                possibleNo[count] = String.valueOf(list.get(count).getValue());
                if (count != list.size() - 1) {
                    System.out.print("");
                }
            }

            //create a String from the array that contains the values of the nodes of the current combination
            String noFromArray = String.join(",", possibleNo).replaceAll(",", "");
            //validate it as a Greek phone number
            Validator val = new Validator(noFromArray);
            val.displayValidityMessage();
            System.out.println();
            interpretationCounter++;
        }
        return lists;
    }

    //get allLeafNodes of current tree
    public Set<Node> getAllLeafNodes() {
        Set<Node> leafNodes = new HashSet<Node>();
        if (this.children.isEmpty()) {
            leafNodes.add(this);
        } else {
            for (Node child : this.children) {
                leafNodes.addAll(child.getAllLeafNodes());
            }
        }
        return leafNodes;
    }

    //get all root to leaf paths of a tree(i.e. all possible combinations of numbers)
    public List<List<Node>> getPaths0(Node pos) {
        List<List<Node>> retLists = new ArrayList();

        if (pos.getChildren().size() == 0) {
            List<Node> leafList = new LinkedList();
            leafList.add(pos);
            retLists.add(leafList);
        } else {
            for (Node node : pos.getChildren()) {
                List<List<Node>> nodeLists = getPaths0(node);
                for (List<Node> nodeList : nodeLists) {
                    nodeList.add(0, pos);
                    retLists.add(nodeList);
                }
            }
        }

        return retLists;
    }

    //get all root to leaf paths helper method
    public List<List<Node>> getPaths(Node head) {
        if (head == null) {
            return new ArrayList();
        } else {
            return getPaths0(head);
        }
    }
}