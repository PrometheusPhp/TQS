package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericPage {

    private static final By MODAL_TEXT = By.id("modalText");
    private static final By MODAL_CLOSE = By.id("btnCloseModal");
    private static final By VOLTAR = By.id("btnBack");

    private final Waits waits;

    public GenericPage(WebDriver driver){

        waits = new Waits(driver);
    }

    public WebElement getModalText(){

        return waits.visibilityOfElement(MODAL_TEXT);
    }

    public WebElement getCloseModalButton(){

        return waits.visibilityOfElement(MODAL_CLOSE);
    }

    public void aguardarModalFechar(){

        waits.invisibilityOfElement(MODAL_TEXT);
    }

    public WebElement getVoltarButton(){

        return waits.visibilityOfElement(VOLTAR);
    }
}
