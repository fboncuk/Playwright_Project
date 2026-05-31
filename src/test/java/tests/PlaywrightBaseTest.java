package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

public class PlaywrightBaseTest {

    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext browserContext;
    protected Page page;


    @BeforeAll
    public static void init() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)  // CI/CD'de true yapın
                .setSlowMo(50));     // Opsiyonel: Yavaşlatma
    }


    @BeforeEach
    public void setup() {
        browserContext = browser.newContext(new Browser.NewContextOptions().setPermissions(Arrays.asList("geolocation")));
        page = browserContext.newPage();
    }


    @AfterEach
    public void teardown(){
        browserContext.close();
    }


    @AfterAll
    public static void tearDownAll() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }



}