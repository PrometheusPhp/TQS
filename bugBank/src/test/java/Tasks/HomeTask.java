package Tasks;

import Framework.Browser.Waits;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Validacao.HomeValidacao;
import Validacao.LoginValidacao;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public class HomeTask {

    private final HomePage homePage;
    private final LoginPage loginPage;
    private final HomeValidacao homeValidacao;
    private final LoginValidacao loginValidacao;
    private final Waits waits;

    public HomeTask (WebDriver driver){

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homeValidacao = new HomeValidacao(driver);
        loginValidacao = new LoginValidacao(driver);
        waits = new Waits(driver);
    }

    public void validarSaldo(BigDecimal esperado, String nomeEvidencia){

        homeValidacao.validaSaldo(esperado, nomeEvidencia);
    }

    public void sair(){

        homePage.getSairButton().click();
        waits.loadElement(loginPage.getAcessarButton());
        loginValidacao.loginValidation();
    }
}
