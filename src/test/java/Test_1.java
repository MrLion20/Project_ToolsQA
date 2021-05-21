import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

;

public class Test_1 {
    private static final WebDriver driver = new ChromeDriver();
    PageObject pageobject = new PageObject(driver);

    @BeforeAll
    public void setup(){
        pageobject.visit("https://demoqa.com/");
        // aca se maximisa la ventana
        driver.manage().window().maximize();

    }
    @Test
    public void test_1() throws InterruptedException {
        pageobject.CargaPagina();
    }
}
