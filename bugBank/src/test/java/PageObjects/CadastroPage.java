package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroPage {

    private static final String CARD = "//div[contains(@class,'card__register')]";

    private final Waits waits;

    public CadastroPage(WebDriver driver){

        waits = new Waits(driver);
    }

    public WebElement getEmailInput(){

        return waits.visibilityOfElement(By.cssSelector(".card__register input[name='email']"));
    }

    public WebElement getNomeInput(){

        return waits.visibilityOfElement(By.cssSelector(".card__register input[name='name']"));
    }

    public WebElement getSenhaInput(){

        return waits.visibilityOfElement(By.cssSelector(".card__register input[name='password']"));
    }

    public WebElement getConfirmaSenhaInput(){

        return waits.visibilityOfElement(By.cssSelector(".card__register input[name='passwordConfirmation']"));
    }


    public WebElement getSaldoToggle(){

        return waits.presenceOfElement(By.id("toggleAddBalance"));
    }

    public WebElement getCadastrarButton(){

        return waits.visibilityOfElement(By.xpath(CARD + "//button[normalize-space()='Cadastrar']"));
    }
}
