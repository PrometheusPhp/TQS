package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final Waits waits;

    public HomePage(WebDriver driver){

        waits = new Waits(driver);
    }

    public WebElement getSaldoLabel(){

        return waits.visibilityOfElement(By.id("textBalance"));
    }

    public WebElement getTransferenciaButton(){

        return waits.visibilityOfElement(By.id("btn-TRANSFERÊNCIA"));
    }

    public WebElement getExtratoButton(){

        return waits.visibilityOfElement(By.id("btn-EXTRATO"));
    }

    public WebElement getSairButton(){

        return waits.visibilityOfElement(By.id("btnExit"));
    }
}
