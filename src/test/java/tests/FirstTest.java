package tests;

import base.PlaywrightBaseTest;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;
import utils.ConfigReader;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstTest extends PlaywrightBaseTest {

    @Test
    public void firstTest() throws InterruptedException {

        // The tab was already open. Google opens in this tab.
        page.navigate(ConfigReader.get("baseUrl"));

        // The links in the top menu are written as an arraylist.
        Locator menuItems = page.locator("[data-testid='utility-nav-link-text']");
        System.out.println(menuItems.allTextContents());

        // The links in the top menu are written line by line.
        for (int i = 0; i < menuItems.count(); i++) {

            // nth means the nth element. In English, 2nd, 3rd ... nth
            String itemText = menuItems.nth(i).textContent();
            System.out.println((i+1) + ". Menü item: " + itemText);
        }

        // Confirm something after the last item.
        // Chaining assertions with AssertJ (much more readable)
        // So org.assertj.core.api.Assertions.assertThat is imported
        assertThat(page.url())
                .contains("https://www.bestbuy.com/")
                .startsWith("https")
                .contains("bestbuy");

    }
}
