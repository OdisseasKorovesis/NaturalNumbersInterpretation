import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {

    @Test
    public void displayValidityMessage() {
        Validator incorrect1 = new Validator("123");
        Assert.assertFalse(incorrect1.displayValidityMessage());
        Validator incorrect2 = new Validator("1234567890");
        Assert.assertFalse(incorrect2.displayValidityMessage());
        Validator incorrect3 = new Validator("00305548726045");
        Assert.assertFalse(incorrect3.displayValidityMessage());

        Validator correct1 = new Validator("6945102996");
        Assert.assertTrue(correct1.displayValidityMessage());
        Validator correct2 = new Validator("2106728969");
        Assert.assertTrue(correct2.displayValidityMessage());
        Validator correct3 = new Validator("00306945102996");
        Assert.assertTrue(correct3.displayValidityMessage());
        Validator correct4 = new Validator("00302106728969");
        Assert.assertTrue(correct4.displayValidityMessage());
    }
}
