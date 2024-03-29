


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;
public class step_definitions {



    public static WebDriver driver;

    @Given("^user goes to the \"([^\"]*)\"$")
    public  void setUp(String page_url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(page_url);
    }


    @Then("^user waits for (\\d+) seconds$")
    public void userWaitsForSeconds(int seconds) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("^verifies that the page title contains the word \"([^\"]*)\"$")
    public void verifyPageTitleContains(String title) {
        assertTrue(driver.getTitle().contains(title));
    }

    @Then("^closes the page$")
    public void closePage() {
        driver.quit();

    }
}
