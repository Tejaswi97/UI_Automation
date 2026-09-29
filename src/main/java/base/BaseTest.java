package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.*;

public class BaseTest {
    
    protected WebDriver driver;
    protected WebDriverWait wait;
    String URL = "https://the-internet.herokuapp.com/";

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.navigate().to(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElements(By.xpath("//a[@href='/add_remove_elements/']")).size() > 0);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
