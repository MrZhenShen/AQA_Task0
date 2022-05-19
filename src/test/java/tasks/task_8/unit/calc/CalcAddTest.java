package tasks.task_8.unit.calc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tasks.task_2.Calculator;

public class CalcAddTest {
    @DataProvider
    public static Object[][] addTestDataProvider() {

        // col count - argument count
        // row count - test execution count
        Object[][] res = new Object[][]{
                {0, 0},
                {1, 2},
                {-2, 2},
                {1, 9},
                {100, 100}
        };
        return res;
    }

    @Test(dataProvider = "addTestDataProvider")
    void calcTest(int a, int b) {
        int expected = a + b;
        Assert.assertEquals(Calculator.add(a, b), expected, "Invalid add operation");
    }
}
