// Page URL: https://www.toptal.com/users/login
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.Console;

public class WebForm extends PageObject{

    private final String EMAIL_HAPPY = "#######ENTER YOR EMAIL HERE##################";
    private final String PASSWORD_HAPPY = "###########ENTER YOUR PASS HERE###########";
    private final String EMAIL_SAD = "ime@prezime.hr";
    private final String PASSWORD_SAD = "sifra123";

    @FindBy(id="horde_user")
    private WebElement email;

    @FindBy(id = "horde_pass")
    private WebElement password;

    @FindBy(xpath = "/html/body/div/div[2]/form/div[10]/input")
    private WebElement submit_button;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/span/a")
    private WebElement alertSuccess;

    @FindBy(xpath = "/html/body/div/div[2]/ul/li/div")
    private WebElement alertFailure;

    @FindBy(xpath = "/html/body/div/div[2]/form/div[1]/label")
    private WebElement user_email_label;

    @FindBy(id = "new_lang")
    private WebElement lang_selector;

    @FindBy(id = "horde_select_view")
    private WebElement display_selector;

    @FindBy(xpath = "/html")
    private WebElement html_tag;

    @FindBy(xpath = "/html/body/div[1]/div[4]/a")
    private WebElement logout_button;

    @FindBy(xpath = "/html/body/div[1]/div[2]/ul/li/div")
    private WebElement logout_message;


    public WebForm(WebDriver driver) {
        super(driver);
    }

    public void enterEmailHappy(){
        this.email.sendKeys(EMAIL_HAPPY);
    }

    public void enterPasswordHappy(){
        this.password.sendKeys(PASSWORD_HAPPY);
    }

    public void enterEmailSad(){
        this.email.sendKeys(EMAIL_SAD);
    }

    public void enterPasswordSad(){
        this.password.sendKeys(PASSWORD_SAD);
    }

    public void pressSubmitButton(){
        this.submit_button.click();
    }

    public void verifyAlertSuccess(){
        this.alertSuccess.isDisplayed();
    }

    public void verifyAlertFailure(){
        this.alertFailure.isDisplayed();
    }

    public void verifyFrenchLanguageSet() {
        System.out.print(this.user_email_label.getText());
        assert this.user_email_label.getText().equals("Nom d'utilisateur") : "failure, not equal";

    }

    public void changeLanguage() {
        Select selector = new Select(lang_selector);
        selector.selectByValue("fr_FR");

    }

    public void selectMobileVersion() {
        Select selector = new Select(display_selector);
        selector.selectByValue("smartmobile");
    }

    public void checkIfMobileVersion() {
        String classes = this.html_tag.getAttribute("class");

        for (String i : classes.split(" ")) {
            if (i.trim().equals("ui-mobile")) {
                assert true;
                return;
            }
        }
        assert false;
    }

    public void logout() {
        this.logout_button.click();
    }

    public void assertLogout() {
        assert this.logout_message.getText().equals("Odjavljeni ste iz sustava.");
    }


}
