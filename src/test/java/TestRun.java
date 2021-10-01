
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestRun {

  @Test
  public void testRunWebAutomation() throws InterruptedException {
    //setup chromedriver
    WebDriverManager.chromedriver().setup();
    //initialize chrome options
    ChromeOptions options = new ChromeOptions();
    //setting chrome capabilities https://peter.sh/experiments/chromium-command-line-switches/
    options.addArguments("--start-maximized,--incognito");
    WebDriver driver = new ChromeDriver(options);
    //for mac it --start-maximized not working properly. So need use this command to maximize
    driver.manage().window().maximize();
    driver.get("http://bdd.atlasid.tech/");
    Thread.sleep(5000);
    driver.quit();
  }
}
