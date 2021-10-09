import driver.WebdriverInit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FooterPage;
import pages.InputQuotePage;
import pages.TableViewPage;

public class TestRunWithPageObject {

  private InputQuotePage inputQuotePage = new InputQuotePage();
  private TableViewPage tableViewPage = new TableViewPage();
  private FooterPage footerPage = new FooterPage();

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

  @Test
  public void hoverToShowTable() {
    inputQuotePage.openPage();
    tableViewPage.clickTableViewTab();
    tableViewPage.hoverShowTableBtn();
    Assertions.assertTrue(tableViewPage.checkTableAppear());
  }

  @Test
  public void clickButtonShowAfterTen() {
    inputQuotePage.openPage();
    tableViewPage.clickTableViewTab();
    tableViewPage.clickShowAfterTenBtn();
    Assertions.assertTrue(tableViewPage.checkTableAppear());
  }

  @Test
  public void clickPoweredByBtn() {
    inputQuotePage.openPage();
    footerPage.clickPoweredByBtn();
    footerPage.switchToAtlasIdTab();
  }

}
