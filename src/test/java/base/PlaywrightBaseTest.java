package base;

import com.microsoft.playwright.*;
import listeners.TestListener;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;
import utils.ScreenshotUtil;

import java.nio.file.Path;
import java.util.Arrays;

@ExtendWith(TestListener.class)
public class PlaywrightBaseTest {

    protected static final Logger log = LoggerFactory.getLogger(PlaywrightBaseTest.class);

    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    static void init() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(ConfigReader.isHeadless())
                        .setSlowMo(ConfigReader.getSlowMo())
        );
    }

    @BeforeEach
    void setUp() {
        context = browser.newContext(
                new Browser.NewContextOptions()
                        .setPermissions(Arrays.asList("geolocation"))
        );
        page = context.newPage();
    }

    @AfterEach
    void tearDown(TestInfo info) {
        if (context != null) {
            context.close();
        }
    }

    @AfterAll
    static void tearDownAll() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    public Page getPage() {
        return page;
    }

    // Screenshot almak için yardımcı metod
    public void takeScreenshot(String testName) {
        if (page != null) {
            Path path = ScreenshotUtil.takeScreenshot(page, testName);
            log.info("📸 Screenshot: {}", path);
        }
    }
}