package pages;

import base.PageObject;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InputQuotePage extends PageObject {

  public void openPage() {
    openUrl("http://bdd.atlasid.tech/");
  }

  public void inputQuote(String quote) {
    type(By.id("inputQuote"), quote);
  }

  public void selectColor(String color) {
    selectByVisibleText(By.id("colorSelect"), color);
  }

  public void clickButtonAddQuote() {
    click(By.id("buttonAddQuote"));
  }

  public boolean checkQuoteExist(String quote) {
    List<WebElement> quoteElements = findAll(By.name("quoteText"));
    boolean isSame = false;
    for (WebElement data : quoteElements) {
      if (data.getText().equals(quote)) {
        isSame = true;
        break;
      }
    }
//    quoteElements.stream().map(WebElement::getText).anyMatch(dt -> dt.equals(quote));
    return isSame;
  }

}
