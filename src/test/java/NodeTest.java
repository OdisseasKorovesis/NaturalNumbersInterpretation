import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NodeTest {

    @Test
    public void testAddChild() {

        //test in case of number < 13
        Node root = new Node(210);
        Node nodeToBeAdded = new Node(7);
        root.addChild(nodeToBeAdded);
        System.out.println(root.getChildren().size());
        Assert.assertTrue(root.getChildren().contains(nodeToBeAdded));

        //test in case of number > 12
        Node root2 = new Node(210);
        Node nodeToBeAdded2 = new Node(72);
        root2.addChild(nodeToBeAdded2);
        Assert.assertTrue(root2.getChildren().get(0).getValue() == 72
                && root2.getChildren().get(1).getValue() == 70);

        //test in case of number >= 100
        Node root3 = new Node(210);
        Node nodeToBeAdded3 = new Node(772);
        root3.addChild(nodeToBeAdded3);
        for (Node nd:
             root3.getChildren()) {
            System.out.println(nd.getValue());
        }
        Assert.assertTrue(root3.getChildren().get(0).getValue() == 772
                && root3.getChildren().get(1).getValue() == 700
                && root3.getChildren().get(2).getValue() == 770);


    }

    @Test
    public void testGetAllCombinationsFromList() {
        List<Node> listOfNodes = new ArrayList();
        Node root = new Node(210);
        Node nd = new Node(253);
        listOfNodes.add(nd);
        List<List<Node>> possibleCombinations = root.getAllCombinationsFromList((ArrayList)listOfNodes, root);
        Assert.assertTrue(possibleCombinations.size() == 4);
    }

}
