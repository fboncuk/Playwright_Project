package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CreateAccountPage {

    private final Page page;

    // Locator names are defined.
    private final Locator firstName;
    private final Locator lastName;
    private final Locator email;
    private final Locator phone;
    private final Locator createAccountButton;
    private final Locator password1;
    private final Locator showPasswordToggle;
    private final Locator password2;
    private final Locator showReenterPasswordToggle;
    private final Locator setPhoneCheckBox;

    // The constructor is defined.
    public CreateAccountPage (Page page) {
        this.page = page;

        // Locators are assigned.
        this.firstName = page.getByLabel("First Name");
        this.lastName = page.getByLabel("Last Name");
        this.email = page.locator("#email");
        this.password1 = page.locator("input#fld-p1");
        this.showPasswordToggle = page.locator("button#show-hide-password-toggle");
        this.password2 = page.locator("input#reenterPassword");
        this.showReenterPasswordToggle = page.locator("button#show-hide-reenter-password-toggle");
        this.phone = page.locator("#phone");
        this.setPhoneCheckBox = page.locator("#is-recovery-phone");
        this.createAccountButton = page.locator("button[type='submit']");
    }

    // Fill/click/check methods are prepared for each locator.
    public void fillFirstName(String value) { firstName.fill(value); }
    public void fillLastName(String value) {
        lastName.fill(value);
    }
    public void fillEmail(String value) {
        email.fill(value);
    }
    public void fillPassword1(String value) { password1.fill(value); }
    public void clickshowPasswordToggle() { showPasswordToggle.click(); }
    public void fillPassword2(String value) { password2.fill(value); }
    public void clickshowReenterPasswordToggle() { showReenterPasswordToggle.click(); }
    public void fillPhone(String value) {
        phone.fill(value);
    }
    public void setPhoneCheckBox() { setPhoneCheckBox.check(); }

    // For testing purposes (will be removed or modified in the future)
    public void printCreateAccount() {
        System.out.println(createAccountButton.innerText()); }

    // For real test, "creating account" codes are below
    // public void clickCreateAccount() {
    //     createAccountButton.click();  // Gerçek kullanım
    // }




    // *************************************************************************
    // LOCATOR ÖRNEKLERİ (Aynı kutuya isim girişi yapılması gerekiyor)
    // 1. getByRole
    // page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill("Fatih");

    // 2. getByLabel
    //page.getByLabel("First Name").fill("Fatih"); //getByLabel 1. öncelikle tercih edilir

    // 3. getByPlaceholder (bu formda placeholder boş ama örnek kullanım)
    //page.getByPlaceholder("First Name").fill("Fatih");

    // 4. getByText (label üzerinden dolaylı kullanım)
    //page.getByText("First Name")
    //.locator("..")
    //.locator("input")
    //.fill("Fatih");

    // 5. getByAltText (input için genelde kullanılmaz, sadece görüntü için)
    // Bu case'te uygun değil, ama örnek olsun diye:
    //page.getByAltText("First Name");

    // 6. getByTitle (bu formda yok, ama örnek)
    //page.getByTitle("First Name").fill("Fatih");

    // 7. getByTestId (HTML’de yok ama en stabil yöntem olurdu)
    // Eğer dev şöyle ekleseydi:
    // data-testid="first-name"
    //page.getByTestId("first-name").fill("Fatih");

    // 8. CSS selector (ID ile en net fallback)
    //page.locator("#firstName").fill("Fatih");

    // 9. XPath (en son çare)
    //page.locator("//input[@id='firstName']").fill("Fatih");


}

