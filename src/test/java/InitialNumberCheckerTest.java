import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class InitialNumberCheckerTest {



    @Test
    public void testIsInputEmpty() {
        InitialNumberChecker noChecker = new InitialNumberChecker();
        String input = "";
        Assert.assertTrue(noChecker.isInputEmpty(input));
    }

    @Test
    public void testDoesInputContainLetters() {
        InitialNumberChecker noChecker = new InitialNumberChecker();
        String incorrectInput = "asdf98";
        Assert.assertFalse(noChecker.doesInputContainLetters(incorrectInput));
        String correctInput = "654 135";
        Assert.assertTrue(noChecker.doesInputContainLetters(correctInput));
    }

    @Test
    public void testConvertNumberIntoListOfNodes() {
        String inputNumber = "210 68";
        InitialNumberChecker inChecker = new InitialNumberChecker();
        List<Node> listOfNodes = inChecker.convertNumberIntoListOfNodes(inputNumber);
        Assert.assertTrue(listOfNodes.get(0).getValue() == 210 );
        Assert.assertTrue(listOfNodes.get(1).getValue() == 68 );
    }

}
