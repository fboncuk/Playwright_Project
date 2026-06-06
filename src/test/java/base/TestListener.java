package base;

import org.junit.jupiter.api.extension.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestListener implements TestWatcher, BeforeEachCallback, AfterEachCallback {

    private static final Logger log = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void beforeEach(ExtensionContext context) {
        log.info("🚀 Test başlıyor: {}", context.getDisplayName());
    }

    @Override
    public void afterEach(ExtensionContext context) {
        log.info("✅ Test tamamlandı: {}", context.getDisplayName());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        log.error("❌ FAILED: {}", context.getDisplayName());
        log.error("Error: ", cause);

        Object testInstance = context.getRequiredTestInstance();
        if (testInstance instanceof PlaywrightBaseTest baseTest) {
            baseTest.takeScreenshot(context.getDisplayName());
        }
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        log.info("✅ PASSED: {}", context.getDisplayName());
    }
}