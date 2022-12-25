package Base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static Base.Config.CONFIG;
import static Base.Config.IMPLICIT_WAIT;

public class BaseAction {
    private static WebDriver driver = null;

    private BaseAction() {

    }

    public static WebDriver createDriver() {
        if (driver == null) {
            switch (CONFIG) {
                case ("win_chrome"):
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                default:
                    Assert.fail("Invalid configuration. Incorrect platform or browser name: " + CONFIG);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        }
        return driver;
    }


}
