package Tasks;

import Framework.Utils.Conta;
import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginTask {

    private final LoginPage loginPage;

    public LoginTask (WebDriver driver){

        loginPage = new LoginPage(driver);
    }

    public void efetuarLogin(Conta conta){

        loginPage.getEmailInput().sendKeys(conta.getEmail());
        loginPage.getPasswordInput().sendKeys(conta.getSenha());
        loginPage.getAcessarButton().click();
    }
}
