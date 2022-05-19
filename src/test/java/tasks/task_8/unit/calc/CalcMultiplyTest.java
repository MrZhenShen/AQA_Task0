package tasks.task_8.unit.calc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tasks.task_2.Calculator;

public class CalcMultiplyTest {
    @DataProvider
    public static Object[][] multiplyTestDataProvider() {
        return new Object[][]{
                {0, 0},
                {1, 2},
                {-2, 2},
                {1, 9},
                {100, 100}
        };
    }

    @Test(dataProvider = "multiplyTestDataProvider")
    void calcTest(int a, int b) {
        Assert.assertEquals(Calculator.multiply(a, b), a * b, "Invalid multiply operation");
    }
}
