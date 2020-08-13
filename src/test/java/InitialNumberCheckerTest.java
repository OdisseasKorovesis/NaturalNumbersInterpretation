import org.junit.Assert;
import org.junit.Test;

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

//    @Test
//    public void testRemoveWhiteSpace() {
//        InitialNumberChecker noChecker = new InitialNumberChecker();
//        String input = "test test";
//        String output = "testtest";
//        String removedSpace = noChecker.removeWhiteSpace(input);
//        Assert.assertEquals(output, removedSpace);
//
//    }
}
