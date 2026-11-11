package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private static final String CARD = "//div[contains(@class,'card__login')]";

    private final Waits waits;

    public LoginPage (WebDriver driver){

        waits = new Waits(driver);
    }

    public WebElement getEmailInput(){

        return waits.visibilityOfElement(By.cssSelector(".card__login input[name='email']"));
    }

    public WebElement getPasswordInput(){

        return waits.visibilityOfElement(By.cssSelector(".card__login input[name='password']"));
    }

    public WebElement getAcessarButton(){

        return waits.visibilityOfElement(By.xpath(CARD + "//button[normalize-space()='Acessar']"));
    }

    public WebElement getRegistrarButton(){

        return waits.visibilityOfElement(By.xpath(CARD + "//button[normalize-space()='Registrar']"));
    }
}
