package tasks.task_13;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tasks.task_13.CustomSuiteListener;
import tasks.task_13.CustomTestListener;

@Listeners({CustomSuiteListener.class, CustomTestListener.class})
public class DemoListenerTest {
    @Test
    void testMethod() {
        Assert.assertTrue(true);
    }

    @Test
    void testFailedMethod() {
        Assert.assertTrue(false);
    }
}
