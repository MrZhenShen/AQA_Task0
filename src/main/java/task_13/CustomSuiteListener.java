package task_13;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.util.logging.Logger;

public class CustomSuiteListener implements ISuiteListener {
    public static final Logger LOGGER = Logger.getLogger(String.valueOf(CustomSuiteListener.class));

    @Override
    public void onStart(ISuite suite) {
        LOGGER.info("CustomSuiteListener: onStart");
    }

    @Override
    public void onFinish(ISuite suite) {
        LOGGER.info("CustomSuiteListener: onFinish");
    }
}
