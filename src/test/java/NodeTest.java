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
        List<List<Node>> possibleCombinations = root.getAllCombinationsFromList((ArrayList)listOfNodes, root, 0);
        Assert.assertTrue(possibleCombinations.size() == 4);

//        List<List<Integer>> listOfpossibleComboNodeValues = new ArrayList();
//
//        List<Integer> firstComboValues = new ArrayList();
//        firstComboValues.add(210);
//        firstComboValues.add(25);
//        firstComboValues.add(3);
//        listOfpossibleComboNodeValues.add(firstComboValues);
//
//        List<Integer> secondComboValues = new ArrayList();
//        secondComboValues.add(210);
//        secondComboValues.add(200);
//        secondComboValues.add(53);
//        secondComboValues.add(3);
//        listOfpossibleComboNodeValues.add(secondComboValues);
//
//        List<Integer> thirdComboValues = new ArrayList();
//        thirdComboValues.add(210);
//        thirdComboValues.add(200);
//        thirdComboValues.add(50);
//        thirdComboValues.add(3);
//        listOfpossibleComboNodeValues.add(thirdComboValues);
//
//        List<Integer> fourthComboValues = new ArrayList();
//        fourthComboValues.add(210);
//        fourthComboValues.add(250);
//        fourthComboValues.add(3);
//        listOfpossibleComboNodeValues.add(fourthComboValues);
//
//        for(int i = 0; i<listOfpossibleComboNodeValues.size(); i++) {
//            List<Node> combination = possibleCombinations.get(i);
//            List<Integer> correctNodeValues = listOfpossibleComboNodeValues.get(i);
//            for(int j = 0; j<correctNodeValues.size(); j++) {
//                System.out.println(combination.get(j).getValue());
//                System.out.println(correctNodeValues.get(j));
//                Assert.assertTrue(combination.get(j).getValue() == correctNodeValues.get(j));
//            }
//        }
    }

}
