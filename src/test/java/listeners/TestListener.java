package listeners;

import base.PlaywrightBaseTest;
import org.junit.jupiter.api.extension.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestListener implements TestWatcher, BeforeEachCallback, AfterEachCallback {

    private static final Logger log = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void beforeEach(ExtensionContext context) {
        log.info("🚀 The test begins: {}", context.getDisplayName());
    }

    @Override
    public void afterEach(ExtensionContext context) {
        log.info("✅ Test completed: {}", context.getDisplayName());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        log.error("❌ FAILED: {}", context.getDisplayName());
        log.error("Error: ", cause);

        Object testInstance = context.getRequiredTestInstance();
        if (testInstance instanceof PlaywrightBaseTest baseTest) {
            try {
                baseTest.takeScreenshot(context.getDisplayName());
            } catch (Exception e) {
                log.error("Screenshot could not be taken!", e);
            }
        }
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        log.info("✅ PASSED: {}", context.getDisplayName());
    }
}