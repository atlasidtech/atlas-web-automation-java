import driver.WebdriverInit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.InputQuotePage;

public class TestRunWithPageObject {

  private InputQuotePage inputQuotePage = new InputQuotePage();

  @BeforeEach
  public void initializeWebdriver() {
    WebdriverInit.initialize();
  }

  @AfterEach
  public void quitWebDriver() throws InterruptedException {
    Thread.sleep(5000);
    WebdriverInit.quit();
  }

  @Test
  public void addQuote() {
    inputQuotePage.openPage();
    inputQuotePage.inputQuote("There is a will there is a way");
    inputQuotePage.selectColor("Yellow");
    inputQuotePage.clickButtonAddQuote();
    Assertions.assertTrue(inputQuotePage.checkQuoteExist("There is a will there is a way"));
  }

}
