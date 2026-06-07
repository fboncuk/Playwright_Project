package tests;

import base.PlaywrightBaseTest;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.CreateAccountPage;
import utils.ConfigReader;

import static org.assertj.core.api.Assertions.assertThat;

public class SignUp extends PlaywrightBaseTest {

    private Faker faker = new Faker();

    @Test
    public void signUpTest () {

        CreateAccountPage createAccountPage = new CreateAccountPage(page);

        // The process is carried out on the browser page.
        page.navigate(ConfigReader.get("baseUrl"));
        page.locator("[class='flex justify-start font-400 text-3 leading-3 text-brand-tech-white']").click();
        page.locator("[data-testid='createAccountButton']").click();

        // Random fake values are generated and entered
        String anyFirstName = faker.name().firstName();
        String anyLastName = faker.name().lastName();
        String uniqueEmail = faker.internet().emailAddress();
        String password = faker.internet()
                .password(8,15,true,true,true);
        String anyPhoneNumber = faker.number().digits(10);

        // The process is carried out using the methods on the CreateAccountPage.
        createAccountPage.fillFirstName(anyFirstName);
        createAccountPage.fillLastName(anyLastName);
        createAccountPage.fillEmail(uniqueEmail);

        createAccountPage.fillPassword1(password);
        createAccountPage.clickshowPasswordToggle();

        createAccountPage.fillPassword2(password);
        createAccountPage.clickshowReenterPasswordToggle();

        assertThat(page.locator("span.cdi-input-success-message").textContent())
                .contains("Your passwords match");

        createAccountPage.fillPhone(anyPhoneNumber);

        createAccountPage.setPhoneCheckBox();

        System.out.println(page.locator("#is-recovery-phone").isChecked());

        // Printing is only for test purposes
        // In real tests "Create Account" button should be clicked.
        createAccountPage.printCreateAccount();

    }

}
