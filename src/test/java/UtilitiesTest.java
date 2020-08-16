import org.junit.Assert;
import org.junit.Test;

public class UtilitiesTest {

    @Test
    public void testRemoveWhiteSpace() {
        String input = "test test";
        String output = "testtest";
        String removedSpace = Utilities.removeWhiteSpace(input);
        Assert.assertEquals(output, removedSpace);
    }

    @Test
    public void testGetDigitsOfNo() {
        String input = "2106728969";
        String firstThreeDigits = "210";
        Assert.assertEquals(Utilities.getDigitsOfNo(3, input), firstThreeDigits);
    }

    @Test
    public void testGetLeadingZeroesCount() {
        String input = "00 00 0304552";
        int leadingZeroesCount = 5;
        Assert.assertEquals(leadingZeroesCount, Utilities.getLeadingZeroesCount(input));
    }
}
