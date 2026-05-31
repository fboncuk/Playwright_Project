package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

//import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FirstTest extends PlaywrightBaseTest {

    @Test
    public void firstTest() throws InterruptedException {

        // Sekme zaten açılmıştı. Bu sekmede Google açılır
        page.navigate("https://www.bestbuy.com/?intl=nosplash");

        // Üst menüdeki linkleri array list olarak yazdıralım
        Locator menuItems = page.locator("[data-testid='utility-nav-link-text']");
        System.out.println(menuItems.allTextContents());

        // Üst menüdeki linkleri satır satır yazdıralım
        for (int i = 0; i < menuItems.count(); i++) {

            // nth n'inci element demektir. İngilizcede 2nd 3rd ... nth
            String itemText = menuItems.nth(i).textContent();
            System.out.println((i+1) + ". Menü item: " + itemText);
        }

        // En son item'dan sonra bir şey doğrula
        // AssertJ ile zincirleme assertion'lar (çok daha okunabilir)
        assertThat(page.url())
                .contains("https://www.bestbuy.com/")
                .startsWith("https")
                .contains("bestbuy");

        // playwright assertionThat
        // assertThat(page).hasURL("https://www.bestbuy.com/");


    }
}
