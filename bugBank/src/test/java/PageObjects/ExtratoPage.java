package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ExtratoPage {

    private final Waits waits;

    public ExtratoPage(WebDriver driver){

        waits = new Waits(driver);
    }

    public WebElement getSaldoDisponivel(){

        return waits.visibilityOfElement(By.id("textBalanceAvailable"));
    }


    public List<WebElement> getValores(){

        return waits.visibilityOfAllElements(By.id("textTransferValue"));
    }

    public List<WebElement> getDescricoes(){

        return waits.visibilityOfAllElements(By.id("textDescription"));
    }
}
