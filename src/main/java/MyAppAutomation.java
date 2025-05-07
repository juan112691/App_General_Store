import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MyAppAutomation {
    private AndroidDriver driver;
    /*public static void main(String[] args) {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("deviceName", "Small Phone API 31"); // nombre del emulador
            caps.setCapability("app", "C:\\Users\\juan_\\OneDrive\\Escritorio\\selendroid.apk");
            // También puedes usar "appPackage" y "appActivity" si la app ya está instalada
            // caps.setCapability("appPackage", "com.ejemplo.app");
            // caps.setCapability("appActivity", "com.ejemplo.app.MainActivity");

            // instancia del driver de Appium
            AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), caps);

            // Esperar hasta que la app esté abierta
            Thread.sleep(3000);
            MobileElement mensaje = driver.findElementById("android:id/button1");
            mensaje.click(); // Ejemplo de interacción: clic en el elemento

            MobileElement texto = driver.findElementById("io.selendroid.testapp:id/my_text_field");
            texto.sendKeys("Este es un texto de prueba");

            MobileElement elemento = driver.findElementById("io.selendroid.testapp:id/waitingButtonTest");
            elemento.click(); // Ejemplo de interacción: clic en el elemento
            Thread.sleep(5000);
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

        @Before
        public void setUp () throws MalformedURLException {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("deviceName", "Small Phone API 31"); // nombre del emulador
            caps.setCapability("app", "C:\\Users\\juan_\\Escritorio\\APKS\\General-Store.apk");

            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), caps);
        }

        @Test
        public void testApp () throws Exception{
            // Seleccionar y deslizar hasta encontrar "El Salvador"
            Thread.sleep(5000);
            driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"El Salvador\"));").click();
            driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("JUAN");
            driver.findElementById("com.androidsample.generalstore:id/radioMale").click();
            driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
            Thread.sleep(5000);
            // Validar que se muestra la pantalla de productos
            boolean isDisplayed = driver.findElementById("com.androidsample.generalstore:id/toolbar_title").isDisplayed();
            assert(isDisplayed);
        }

        @After
        public void tearDown () {
            if (driver != null) {
                driver.quit();
            }
        }
    }
