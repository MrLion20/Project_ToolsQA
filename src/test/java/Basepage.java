import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Basepage {

    protected WebDriver driver;

    public Basepage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Aca se definen variables como la locator para que sea mas sencilla la busqueda de los elementos en los test.

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }
    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    // Aca se le asigna la palabra Type al sendkeys cuando queremos escribir en algun espacio de text
    public void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    //Aca se menciona tambien la accion de dar clic a un elemento
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    //Esta funcion lo que realiza es verificar que el locator(elemento) que estamos buscando este disponible para aplicar la accion deseada.
    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void visit(String url) {
        driver.get(url);
    }

}
