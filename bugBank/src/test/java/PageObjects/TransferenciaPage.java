package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferenciaPage {

    private final Waits waits;

    public TransferenciaPage(WebDriver driver){

        waits = new Waits(driver);
    }

    public WebElement getNumeroContaInput(){

        return waits.visibilityOfElement(By.cssSelector("input[name='accountNumber']"));
    }

    public WebElement getDigitoInput(){

        return waits.visibilityOfElement(By.cssSelector("input[name='digit']"));
    }

    public WebElement getValorInput(){

        return waits.visibilityOfElement(By.cssSelector("input[name='transferValue']"));
    }

    public WebElement getDescricaoInput(){

        return waits.visibilityOfElement(By.cssSelector("input[name='description']"));
    }

    public WebElement getTransferirButton(){

        return waits.visibilityOfElement(By.xpath("//button[normalize-space()='Transferir agora']"));
    }
}
