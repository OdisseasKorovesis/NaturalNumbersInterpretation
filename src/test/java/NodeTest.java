import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class NodeTest {

    @Test
    public void testAddChild_oneParam() {

        //test in case of number < 13
        Node root = new Node(210);
        Node nodeToBeAdded = new Node(7);
        root.addChild(nodeToBeAdded);
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
        }
        Assert.assertTrue(root3.getChildren().get(0).getValue() == 772
                && root3.getChildren().get(1).getValue() == 700
                && root3.getChildren().get(2).getValue() == 770);


    }

    @Test
    public void testAddChild_twoParam() {

        Node root = new Node(213);
        Node firstNode = new Node(50);
        Node secondNode = new Node(3);

        root.addChild(firstNode, secondNode.getValue());
        for (Node nd: root.getAllLeafNodes()) {
            nd.addChild(secondNode);
        }

        int[] expectedRootChildrenValues = {50, 53};

        int[] returnedRootChildrenValues = new int[2];
        int counter = 0;
        for (Node nd: root.getChildren()) {
            returnedRootChildrenValues[counter] = nd.getValue();
            counter++;
        }
        Arrays.sort(returnedRootChildrenValues);
        counter = 0;
        for (int value : expectedRootChildrenValues) {
            Assert.assertTrue(returnedRootChildrenValues[counter] == expectedRootChildrenValues[counter]);
            counter++;
        }

        Node root2 = new Node(213);
        Node firstNode2 = new Node(50);
        Node secondNode2 = new Node(12);

        root2.addChild(firstNode2, secondNode2.getValue());
        for (Node nd: root2.getAllLeafNodes()) {
            nd.addChild(secondNode2);
        }

        counter = 0;
        for (Node nd: root2.getChildren()) {
            Assert.assertTrue(nd.getValue() == 50);
            Assert.assertTrue(nd.getChildren().get(counter).getValue() == 12);
            counter++;
        }

    }

    @Test
    public void testGetAllCombinationsFromList() {
        List<Node> listOfNodes = new ArrayList();
        Node root = new Node(210);
        Node nd = new Node(253);
        listOfNodes.add(nd);
        List<List<Node>> possibleCombinations = root.getAllCombinationsFromList((ArrayList)listOfNodes, root, 0);
        Assert.assertTrue(possibleCombinations.size() == 4);
    }

    @Test
    public void testGetAllLeafNodes() {
        Node root = new Node(215);
        Node child1 = new Node(253);
        root.addChild(child1);

        int[] orderedCorrectLeafNodeValues = {3, 3, 53, 253};
        int[] returnedLeafNodeValues = new int[4];
        Set<Node> leafNodes = root.getAllLeafNodes();
        int counter = 0;
        for (Node node :
             leafNodes) {
            returnedLeafNodeValues[counter] = node.getValue();
            counter++;
        }
        Arrays.sort(returnedLeafNodeValues);
        counter = 0;
        for (Integer nodeValue: returnedLeafNodeValues) {
            Assert.assertTrue(nodeValue == orderedCorrectLeafNodeValues[counter]);
            counter++;
        }

    }

    @Test
    public void testGetPaths0() {
        Node root = new Node(215);
        Node child1 = new Node(253);
        root.addChild(child1);
        List<List<Node>> returnedResult = root.getPaths(root);
        for (Node nd:
             returnedResult.get(1)) {
            System.out.println(nd.getValue());
        }
        List<int[]> arraysOfNodeListsValues = new ArrayList();
        int counter = 0;
        for (List<Node> nodeList : returnedResult) {
            int[] listOfValues = new int[nodeList.size()];
            for (Node nd:
                 nodeList) {
            listOfValues[counter] = nd.getValue();
            counter++;
            }
            Arrays.sort(listOfValues);
            arraysOfNodeListsValues.add(listOfValues);
            counter = 0;
        }

        List<int[]> arrayOfExpectedNodeListsValues = new ArrayList();
        int[] path1 = {215, 253};
        int[] path2 = {53, 200, 215};
        int[] path3 = {3, 50, 200, 215};
        int[] path4 = {3, 215, 250};
        arrayOfExpectedNodeListsValues.add(path1);
        arrayOfExpectedNodeListsValues.add(path2);
        arrayOfExpectedNodeListsValues.add(path3);
        arrayOfExpectedNodeListsValues.add(path4);

        for (int i = 0; i<arraysOfNodeListsValues.size(); i++) {

            for (int j = 0; j < arraysOfNodeListsValues.get(i).length; j++) {
                Assert.assertTrue(arraysOfNodeListsValues.get(i)[j] == arrayOfExpectedNodeListsValues.get(i)[j]);
            }
        }
    }

}
