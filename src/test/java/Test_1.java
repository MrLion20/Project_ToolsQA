import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test_1 {
    ExtentReports extent;
    ExtentSparkReporter sparkReporter;
    private static final WebDriver driver = new ChromeDriver();
    PageObject pageobject = new PageObject(driver);

    @BeforeSuite
    public void BeforeSuit() {
        pageobject.BeforeSuit();
    }

    @Test(priority = 1)
    public void test_1() throws InterruptedException {
        pageobject.CargaPagina();
    }
    @AfterSuite
    public void AfterSuite() {
        pageobject.AfterSuit();
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }
}
