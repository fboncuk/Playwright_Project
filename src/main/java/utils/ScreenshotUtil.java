package utils;

import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    private static final Logger log = LoggerFactory.getLogger(ScreenshotUtil.class);
    private static final String SCREENSHOT_DIR = "target/screenshots/";
    // target/screenshots/ (cleaned with mvn clean)

    static {
        try {
            Files.createDirectories(Paths.get(SCREENSHOT_DIR));
        } catch (Exception e) {
            log.error("The screenshot directory could not be created: {}", e.getMessage());
        }
    }

    // Path return has Low risk of NullPointer with respect to String
    public static Path takeScreenshot(Page page, String testName) {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = String.format("%s_%s.png", testName, timestamp);
            Path filePath = Paths.get(SCREENSHOT_DIR, fileName);

            page.screenshot(new Page.ScreenshotOptions().setPath(filePath));
            log.info("📸 Screenshot saved: {}", filePath);

            return filePath;
        } catch (Exception e) {
            log.error("Screenshot could not be taken!", e);
            return null;
        }
    }
}