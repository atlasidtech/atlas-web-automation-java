import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

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
    
    //scenario input Quote
    By inputQuote = By.id("inputQuote");
    driver.findElement(inputQuote).sendKeys("Halo 1");
    driver.findElement(By.id("inputQuote")).clear();
    driver.findElement(By.id("inputQuote")).sendKeys("Haloo Selamat Pagi");

    WebElement quoteElement = driver.findElement(By.id("inputQuote"));
    quoteElement.clear();
    quoteElement.sendKeys("Halo Ketiga");
    Thread.sleep(3000);

    //scenario choose color from dropdown list
    WebElement selectColor = driver.findElement(By.id("colorSelect"));
    selectColor.click();
    selectColor.sendKeys("Blue");
    Thread.sleep(3000);

    Select select = new Select(selectColor);
    select.selectByValue("Yellow");
    //Thread.sleep(3000);
    select.selectByIndex(2);
    //Thread.sleep(3000);
    select.selectByVisibleText("White");
    //Thread.sleep(3000);

    String xpathButtonAddQuote = "//*[@class='btn btn-primary']";

    WebElement buttonElement = driver.findElement(By.id("buttonAddQuote"));
    buttonElement.click();
    Thread.sleep(5000);

    WebElement buttonElement2 = driver.findElement(By.xpath(xpathButtonAddQuote));
    buttonElement2.click();
    Thread.sleep(5000);

    String xpathAlert = "//*[@class='alert alert-info']";
    WebElement alertElement = driver.findElement(By.xpath(xpathAlert));
    String alert = alertElement.getText();
    String resource = "Info: Click on a Quote to delete it!";
    Assert.assertEquals(alert, resource);
    Assert.assertTrue(alertElement.isDisplayed());

    System.out.println("alertnya ada = " + alert);
    Assert.assertTrue(alert.equals("Info: Click on a Quote to delete it!"));


    //scenario: 1. get text title page dan diprint
    //          2. isi quote dengan nama masing-masing
    //          3. pilih salah satu color
    //          4. click button add quote
    //          5. get text dari nama powered by

    String xpathHeader = "//h1[text()='Atlas Tech ID Web Playground']";
    WebElement header = driver.findElement(By.xpath(xpathHeader));
    System.out.println("headernya = " + header.getText());

    driver.quit();
  }
}
