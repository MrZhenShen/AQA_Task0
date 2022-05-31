package testFramework.duolingoUI.listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.util.logging.Logger;

public class SuiteListener implements ISuiteListener {
    public static final Logger LOGGER = Logger.getLogger(String.valueOf(SuiteListener.class));

    @Override
    public void onStart(ISuite suite) {
        LOGGER.info(suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        LOGGER.info(suite.getName());
    }
}
