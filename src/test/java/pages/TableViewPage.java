package pages;

import base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TableViewPage extends PageObject {

  public void clickTableViewTab() {
    click(By.cssSelector("#tableView"));
  }

  public void hoverShowTableBtn() {
    WebElement btnShowTable = find(By.xpath("//button[@id='buttonShowTable']"));
    Actions actions = new Actions(getDriver());
    actions.moveToElement(btnShowTable).pause(2000).build().perform();
  }

  public boolean checkTableAppear() {
    //explicit wait
    WebDriverWait wait = new WebDriverWait(getDriver(), 15, 1000);
    WebElement table = wait.until(
        ExpectedConditions.presenceOfElementLocated(By.cssSelector("#tableQuote")));
//    WebElement table = find(By.cssSelector("#tableQuote"));
    return table.isDisplayed();
  }

  public void clickShowAfterTenBtn() {
    click(By.cssSelector("#buttonShowAfterTen"));
  }

}
