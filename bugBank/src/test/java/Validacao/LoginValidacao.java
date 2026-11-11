package Validacao;

import Framework.Utils.TakeScreenshot;
import PageObjects.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginValidacao {

    private final WebDriver driver;
    private final LoginPage loginPage;

    public LoginValidacao (WebDriver driver){

        this.driver = driver;
        loginPage = new LoginPage(this.driver);
    }

    public void loginValidation(){

        try {

            Assertions.assertTrue(loginPage.getAcessarButton().isDisplayed());
            TakeScreenshot.screenshotPage(driver, "Login");

        } catch (Exception | AssertionError e) {

            TakeScreenshot.screenshotPage(driver, "Login");
            throw e;
        }
    }
}
