import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObject extends Basepage {

    public PageObject(WebDriver driver) {
        super(driver);
    }

    ExtentReports extent;
    ExtentSparkReporter sparkReporter;

    //-----------------------Indicadores necesarios para las pruebas  ---------------------------------
    //indicadores para ingresar a la pagina de Formulario para realizar las pruebas correspondientes

    By BtnForm = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]");
    By VentanaForm = By.xpath("(//li[@id='item-0'])[2]");
    By VentanaTitle = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/h5");

    //-------------------implementacion de funciones para las pruebas --------------------------


    //Acciones Antes Pruebas
    public void BeforeSuit() {
        extent = new ExtentReports();
        sparkReporter = new ExtentSparkReporter("Reports\\Report_ToolsQA.html");
        extent.attachReporter(sparkReporter);
        sparkReporter.config().setDocumentTitle("Prueba de Pagina ToolsQA");

        extent.setSystemInfo("Company name", "Babel");
        extent.setSystemInfo("Proyect Name", "ToolsQA Page");
        extent.setSystemInfo("Tester Name", "Ing. Justin Leon Castro");
        extent.setSystemInfo("Test Lead", "Ing. ..............");
    }

    //Acciones Despues Pruebas
    public void AfterSuit() {
        extent.flush();
    }

    //Test Cargar Pagina
    public void CargaPagina() throws InterruptedException {
        ExtentTest test = extent.createTest("Iniciar Prueba Cargar_Pagina");
        System.setProperty("webdriver.chrome.driver", Conexion.CHROME_DRIVER_LOCATION);
        test.log(Status.INFO, "Abierto navegador");
        Thread.sleep(2000);
        driver.get(Conexion.BASE_URL);
        test.info("Se Abre la URL de prueba" + "https://demoqa.com/");
        driver.manage().window().maximize();
        test.info("Se maximiza la ventana del navegador");
        test.pass("Prueba Cargar_Pagina Completa");
    }
}
