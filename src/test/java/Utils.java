// Configuration class for Form Automation project

public class Utils {
    final static String BASE_URL = "https://webmail.carnet.hr/login.php";
    final static String CHROME_DRIVER_LOCATION = "chromedriver";

    public static void pause(Integer milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}