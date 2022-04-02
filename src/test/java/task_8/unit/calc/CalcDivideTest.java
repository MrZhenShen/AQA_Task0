package task_8.unit.calc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import task_2.Calculator;

public class CalcDivideTest {
    @DataProvider
    public static Object[][] divideTestDataProvider() {
        return new Object[][]{
                {1, 2},
                {-2, 2},
                {1, 9},
                {100, 100}
        };
    }

    @Test(dataProvider = "divideTestDataProvider")
    void calcTest(int a, int b) {
        Assert.assertEquals(Calculator.divide(a, b), (double) a / b, "Invalid divide operation");
    }
}
