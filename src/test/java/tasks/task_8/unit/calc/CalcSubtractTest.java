package tasks.task_8.unit.calc;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tasks.task_2.Calculator;

public class CalcSubtractTest {
    @Test
    @Parameters({"a", "b"})
    void calcTest(Integer a, Integer b) {
        Assert.assertEquals(Calculator.subtract(a, b), a - b, "Invalid subtract operation");
    }
}
