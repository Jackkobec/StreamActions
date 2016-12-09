import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Jack on 09.12.2016.
 */
public class NullValidatorForVarArgsTest {

    NullValidationForVarArgs nullValidationForVarArgs = new NullValidationForVarArgs();

    private String correctString = "Test";
    private String correctString2 = "Test2";

    private String emptyString = "";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCheckStringForNullAndEmptyConditionJava8ExceptionNull() {

        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Передано null значение или args.length == 0.");

        nullValidationForVarArgs.checkStringForNullAndEmptyConditionJava8(null);
        nullValidationForVarArgs.checkStringForNullAndEmptyConditionJava8Alt(null);
    }

    @Test
    public void testCheckStringForNullAndEmptyConditionJava8ExceptionEmptyOrNull() {

        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Один из параметров имеет null значение или имеется пустая строка.");

        nullValidationForVarArgs.checkStringForNullAndEmptyConditionJava8(null, null);
        nullValidationForVarArgs.checkStringForNullAndEmptyConditionJava8(emptyString);
        nullValidationForVarArgs.checkStringForNullAndEmptyConditionJava8(correctString, emptyString);
        nullValidationForVarArgs.checkStringForNullAndEmptyConditionJava8(correctString, null);
    }

    @Test
    public void testCheckStringForNullAndEmptyConditionJava8Positive() {

        Assert.assertTrue(nullValidationForVarArgs.checkStringForNullAndEmptyConditionJava8(correctString));
        Assert.assertTrue(nullValidationForVarArgs.checkStringForNullAndEmptyConditionJava8(correctString, correctString2));
    }

    @Test
    public void testCheckStringForNullAndEmptyConditionJava8AltNegative() {

        Assert.assertFalse(nullValidationForVarArgs.checkStringForNullAndEmptyConditionJava8Alt(emptyString));
        Assert.assertFalse(nullValidationForVarArgs.checkStringForNullAndEmptyConditionJava8Alt(null, null));
        Assert.assertFalse(nullValidationForVarArgs.checkStringForNullAndEmptyConditionJava8Alt(correctString, ""));
        Assert.assertFalse(nullValidationForVarArgs.checkStringForNullAndEmptyConditionJava8Alt(correctString, null));
    }

    @Test
    public void testCheckStringForNullAndEmptyConditionJava8AltPositive() {

        Assert.assertTrue(nullValidationForVarArgs.checkStringForNullAndEmptyConditionJava8Alt(correctString));
        Assert.assertTrue(nullValidationForVarArgs.checkStringForNullAndEmptyConditionJava8Alt(correctString, correctString2));
    }
}

