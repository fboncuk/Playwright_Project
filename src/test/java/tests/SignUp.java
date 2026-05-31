package tests;

import org.junit.jupiter.api.Test;
import pages.CreateAccountPage;
import static org.assertj.core.api.Assertions.assertThat;

public class SignUp extends PlaywrightBaseTest {


    @Test
    public void signUpTest () throws InterruptedException {

        CreateAccountPage createAccountPage = new CreateAccountPage(page);

        // Browser sayfasında işlem yapılır
        page.navigate("https://www.bestbuy.com/?intl=nosplash");
        page.locator("[class='flex justify-start font-400 text-3 leading-3 text-brand-tech-white']").click();
        page.locator("[data-testid='createAccountButton']").click();
        // Thread.sleep(1000); // TODO: Gözlem için geçici, kaldırılacak

        // CreateAccountPage sayfasındaki metotlar ile işlem yapılır
        createAccountPage.fillFirstName("BenimAdim");
        createAccountPage.fillLastName("BenimSoyadim");
        createAccountPage.fillEmail("BenimEmail@adresim.com");
        // Thread.sleep(1000); // TODO: Gözlem için geçici, kaldırılacak

        createAccountPage.fillPassword1("Pa55w0rd.* 111");
        createAccountPage.clickshowPasswordToggle();
        // Thread.sleep(1000); // TODO: Gözlem için geçici, kaldırılacak

        createAccountPage.fillPassword2("Pa55w0rd.* 111");
        createAccountPage.clickshowReenterPasswordToggle();
        // Thread.sleep(1000); // TODO: Gözlem için geçici, kaldırılacak

        assertThat(page.locator("span.cdi-input-success-message").textContent())
                .contains("Your passwords match");

        createAccountPage.fillPhone("0613026899");
        // Thread.sleep(1000); // TODO: Gözlem için geçici, kaldırılacak

        createAccountPage.setPhoneCheckBox();
        // Thread.sleep(1000); // TODO: Gözlem için geçici, kaldırılacak

        System.out.println(page.locator("#is-recovery-phone").isChecked());

        createAccountPage.printCreateAccount();

    }

}
