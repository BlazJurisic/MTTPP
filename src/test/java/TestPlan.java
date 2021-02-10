import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Submit a login on carNET webmail, happy path")
    public static void submitFormHappy(){
        driver.get(Utils.BASE_URL);
        Utils.pause(1000);
        WebForm webForm = new WebForm(driver);
        webForm.enterEmailHappy();
        webForm.enterPasswordHappy();
        webForm.pressSubmitButton();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Utils.pause(1000);
        webForm.verifyAlertSuccess();
    }

    @Test(testName = "Submit a login on carNET webmail, sad path")
    public static void submitFormSad(){
        driver.get(Utils.BASE_URL);
        Utils.pause(1000);
        WebForm webForm = new WebForm(driver);
        webForm.enterEmailSad();
        webForm.enterPasswordSad();
        webForm.pressSubmitButton();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Utils.pause(1000);
        webForm.verifyAlertFailure();
    }

    @Test(testName = "changle language to french")
    public static void changeLanguage(){
        driver.get(Utils.BASE_URL);
        Utils.pause(1000);
        WebForm webForm = new WebForm(driver);
        webForm.changeLanguage();
        //        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Utils.pause(1000);
        webForm.verifyFrenchLanguageSet();
    }

    @Test(testName = "test mobile version")
    public static void changeToMobile(){
        driver.get(Utils.BASE_URL);
        Utils.pause(1000);
        WebForm webForm = new WebForm(driver);
        webForm.enterEmailHappy();
        webForm.enterPasswordHappy();
        webForm.selectMobileVersion();
        webForm.pressSubmitButton();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Utils.pause(1000);
        webForm.checkIfMobileVersion();
    }

    @Test(testName = "log out")
    public static void logout(){
        driver.get(Utils.BASE_URL);
        Utils.pause(1000);
        WebForm webForm = new WebForm(driver);
        webForm.enterEmailHappy();
        webForm.enterPasswordHappy();
        webForm.pressSubmitButton();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Utils.pause(1000);
        webForm.logout();
        webForm.assertLogout();
    }

    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
