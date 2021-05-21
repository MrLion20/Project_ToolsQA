import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

;

public class Test_1 {
    private static final WebDriver driver = new ChromeDriver();
    PageObject pageobject = new PageObject(driver);


    @Test
    public void test_1() throws InterruptedException {
        pageobject.visit("https://demoqa.com/");
        // aca se maximisa la ventana
        driver.manage().window().maximize();
        pageobject.CargaPagina();
    }
}
