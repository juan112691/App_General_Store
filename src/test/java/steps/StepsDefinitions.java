package steps;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class StepsDefinitions {
    public static AndroidDriver driver;

    @Given("que la aplicación está abierta")
    public void que_la_aplicacion_esta_abierta() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", "Small Phone API 36");
        caps.setCapability("app", "C:\\Users\\juan_\\Desktop\\APKS\\General-Store.apk");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), caps);
    }

    @When("selecciono {string} como país")
    public void selecciono_pais(String pais) throws InterruptedException {
        Thread.sleep(5000);
        driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + pais + "\"));"
        ).click();
    }

    @When("ingreso el nombre {string}")
    public void ingreso_el_nombre(String nombre) {
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys(nombre);
    }

    @When("selecciono el género masculino")
    public void selecciono_el_genero_masculino() {
        driver.findElementById("com.androidsample.generalstore:id/radioMale").click();
    }

    @When("presiono el botón \"Let's Shop\"")
    public void presiono_el_boton() {
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
    }

    @Then("debería mostrarse la pantalla de productos")
    public void deberia_mostrarse_la_pantalla_de_productos() throws InterruptedException {
        Thread.sleep(5000);
        boolean isDisplayed = driver.findElementById("com.androidsample.generalstore:id/toolbar_title").isDisplayed();
        assertTrue(isDisplayed);
    }
}
