package Validacao;

import Framework.Utils.Moeda;
import Framework.Utils.TakeScreenshot;
import PageObjects.HomePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public class HomeValidacao {

    private final WebDriver driver;
    private final HomePage homePage;

    public HomeValidacao (WebDriver driver){

        this.driver = driver;
        homePage = new HomePage(this.driver);
    }

    public void validaSaldo(BigDecimal esperado, String nomeEvidencia){

        try {

            BigDecimal atual = Moeda.parse(homePage.getSaldoLabel().getText());
            Assertions.assertEquals(0, esperado.compareTo(atual),
                    "Saldo na home: esperado " + esperado + " mas foi " + atual);
            TakeScreenshot.screenshotPage(driver, nomeEvidencia);

        } catch (Exception | AssertionError e) {

            TakeScreenshot.screenshotPage(driver, nomeEvidencia);
            throw e;
        }
    }
}
