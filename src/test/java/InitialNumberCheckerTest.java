import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class InitialNumberCheckerTest {



    @Test
    public void testRunInitialTests() {
        String input = "210 67 28 969";
        InitialNumberChecker inChecker = new InitialNumberChecker();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assert.assertEquals(input, inChecker.runInitialTests());
    }

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

    @Test
    public void testDoesInputContainOnlyThreeDigitGroupings() {
        InitialNumberChecker inChecker = new InitialNumberChecker();
        String correctInput = "210 5 6 782 45";
        Assert.assertTrue(inChecker.doesInputContainOnlyThreeDigitGroupings(correctInput));

        String wrongInput = "2143 5 6 782 45";
        Assert.assertFalse(inChecker.doesInputContainOnlyThreeDigitGroupings(wrongInput));
    }

}
