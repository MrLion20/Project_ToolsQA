import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Test_1 {
    private WebDriver driver;
    PageObject pageobject;


    @Before
    public void setup(){
        PageObject pageobject = new PageObject(driver);
        driver = pageobject.chromeDriverConnection();
        pageobject.visit("https://demoqa.com/");
        // aca se maximisa la ventana
        driver.manage().window().maximize();

    }
    @Test
    public void test_1() throws InterruptedException {
        pageobject.CargaPagina();
    }
}
