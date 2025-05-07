package steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
public class Hooks {
    @After
    public void tearDown() {
        if (StepsDefinitions.driver != null) {
            StepsDefinitions.driver.quit();
        }
    }
}
