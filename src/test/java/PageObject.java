import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.And;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.gherkin.model.Then;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

    //--------Formulario TXT --------------

    By Txt_FirstName = By.id("firstName");
    By Txt_LastName = By.id("lastName");
    By Txt_Email = By.id("userEmail");
    By Txt_Mobile = By.id("userNumber");
    By Txt_Address = By.id("currentAddress");

    //--------Formulario RadioButtons --------------

    By RB_Male = By.xpath("//div[@id='genterWrapper']/div[2]/div");
    By RB_Female = By.xpath("//div[@id='genterWrapper']/div[2]/div[2]");
    By RB_Other = By.xpath("//div[@id='genterWrapper']/div[2]/div[3]");

    //--------Formulario CheckBox --------------

    By CB_Sports = By.xpath("//div[@id='hobbiesWrapper']/div[2]/div");
    By CB_Reading = By.xpath("//div[@id='hobbiesWrapper']/div[2]/div[2]");
    By CB_Music = By.xpath("//div[@id='hobbiesWrapper']/div[2]/div[3]");

    //--------Formulario Picupload --------------

    By Pic_Upload = By.id("uploadPicture");

    //--------Formulario Calendario --------------

    By Cal_box = By.id("dateOfBirthInput");
    By Select_month = By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select");
    By Select_year = By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select");
    By Select_dia20 = By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[5]");

    //--------Formulario Materias --------------

    By Txt_Materias = By.xpath("//div[@id='subjectsContainer']/div/div");
    By Txt_Materia = By.xpath("//input[@id='subjectsInput']");
    By Option_Maths = By.xpath("//div[@id='react-select-2-option-0']");

    //-------- Selects de estado y ciudad -----------

    By Select_State = By.xpath("//div[@id='state']/div/div");
    By Option_Heryana = By.xpath("//div[@id='react-select-3-option-2']");
    By Select_City = By.xpath("//div[@id='stateCity-wrapper']/div[3]");
    By Option_Panipat = By.xpath("//div[@id='react-select-4-option-1']");

    //-------- Botones-----------
    By Btn_Submit = By.id("submit");

    By Btn_CloseModel = By.id("closeLargeModal");


    //-------------------implementacion de funciones para las pruebas --------------------------

    //Acciones Antes Pruebas
    public void BeforeSuit() {
        extent = new ExtentReports();
        sparkReporter = new ExtentSparkReporter("Reports\\ToolsQA_Formulario.html");
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
        ExtentTest test = extent.createTest("Iniciar Prueba Cargar_Pagina").assignDevice("Windows-10 - GoogleChrome - PCLenovo");;
        System.setProperty("webdriver.chrome.driver", Conexion.CHROME_DRIVER_LOCATION);
        test.log(Status.INFO, "Abierto navegador");
        Thread.sleep(2000);
        driver.get(Conexion.BASE_URL);
        test.info("Se Abre la URL de prueba" + "https://demoqa.com/");
        driver.manage().window().maximize();
        test.info("Se maximiza la ventana del navegador");
        test.pass("Prueba Cargar_Pagina Completa");
    }

    //Test Entrar a pagina de Formularios y llenar Datos
    public void Pagina_Formulario() throws InterruptedException {
        Thread.sleep(2000);
        ExtentTest test = extent.createTest("Ingreso a Pagina Formulario");
        //Esta funcion lo que realiza es buscar el elemento que deseamos y dirigirnos hacia el para luego tomar alguna accion
        WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        test.log(Status.INFO, "Dirigimos a la Card Formularios");
        actions.perform();

        ExtentTest node = test.createNode(Scenario.class, "Verificacion de Botones y ingreso", "Se verifica si estan los botones para ingresar a la pagina Formularios").assignCategory("Verificacion con Condicion IF");

        if (isDisplayed(BtnForm)) {
            node.createNode(Given.class, "Se corre corre un If para verificar si el boton de Formularios esta disponible");
            click(BtnForm);
            node.pass("Se presiona boton correctamente");
            Thread.sleep(2000);
            node.createNode(And.class, "Se presiona el otro boton para que se muestre el formulario");
            click(VentanaForm);
            node.pass("Boton Presionado corretamente");
            test.pass("Ingresamos correctamente a la pagina de Formulario ");
        } else {
            System.out.print("No esta disponible el Boton para poder ingresar a la Ventana de Formularios");
            node.createNode(Then.class, "No se encontro el boton para ingresar").fail("no se encontro el boton para ingresar");
        }
    }

    //Test para Ingresar la Informacion
    public void Ingresar_informacion() throws InterruptedException {
        ExtentTest test = extent.createTest("Ingresar informacion en Formulario");
        Thread.sleep(2000);
        if (isDisplayed(VentanaTitle)) {
            type("Justin", Txt_FirstName);
            type("Leon", Txt_LastName);
            type("jus@gamail.com", Txt_Email);
            // Probar los radio Buttons
            click(RB_Female);
            Thread.sleep(2000);
            click(RB_Other);
            Thread.sleep(2000);
            click(RB_Male);
            Thread.sleep(2000);

            type("8596859685", Txt_Mobile);
            type("Perez Zeledon, San jose, Costa Rica", Txt_Address);

            //Probar los CheckBox

            //Con esto verificamos si el CB esta seleccionado y si no lo esta devolvemos un false ara que se puedea dar clic
            WebElement CB_Sports = driver.findElement(By.xpath("//div[@id='hobbiesWrapper']/div[2]/div"));
            boolean isSelected = CB_Sports.isSelected();

            // performing click operation if element is not selected
            if (isSelected == false) {
                CB_Sports.click();
            } else {
                System.out.print("Ya esta Seleccionado el CB");
            }

            Thread.sleep(2000);

            click(CB_Music);

            //Adjuntar Foto
            type("C:\\Perfil.jpg", Pic_Upload);

            //Seleccionar El estado y La ciudad
            click(Select_State);
            Thread.sleep(2000);
            click(Option_Heryana);
            Thread.sleep(2000);
            click(Select_City);
            Thread.sleep(2000);
            click(Option_Panipat);

            //Seleccionar las materias
            click(Txt_Materias);
            type("math", Txt_Materia);
            Thread.sleep(2000);
            click(Option_Maths);

            click(Txt_Materias);
            type("Social", Txt_Materia);


        } else {
            System.out.print("No se encuentra en la pagina correcta para ingresar los datos ");
        }

    }
}
