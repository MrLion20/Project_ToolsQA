import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageObject extends Basepage {

    public PageObject(WebDriver driver) {
        super(driver);
    }
    //-----------------------Indicadores necesarios para las pruebas  ---------------------------------
    //indicadores para ingresar a la pagina de Formulario para realizar las pruebas correspondientes

    By BtnForm = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]");
    By VentanaForm = By.xpath("(//li[@id='item-0'])[2]");
    By VentanaTitle = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/h5");

    //-------------------implementacion de funciones para las pruebas --------------------------
    //--------------Esperamos que la pagina Cargue por completo nos dirigimos a el boton que debemos e seleccionar

    public void CargaPagina() throws InterruptedException {
        Thread.sleep(2000);
        //Esta funcion lo que realiza es buscar el elemento que deseamos y dirigirnos hacia el para luego tomar alguna accion
        WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        Thread.sleep(2000);
    }
}
