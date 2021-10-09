package pages;

import base.PageObject;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;

public class FooterPage extends PageObject {

  public void clickPoweredByBtn() {
    click(By.xpath("//a[@id='poweredBy']"));
  }

  public void switchToAtlasIdTab() {
    List<String> windows = new ArrayList<>(getDriver().getWindowHandles());
    getDriver().switchTo().window(windows.get(1));
    System.out.println(getDriver().getTitle());
//    getDriver().switchTo().window(windows.get(0));
  }

}
