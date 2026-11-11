package Validacao;

import Framework.Utils.Moeda;
import Framework.Utils.TakeScreenshot;
import PageObjects.ExtratoPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;

public class ExtratoValidacao {

    private final WebDriver driver;
    private final ExtratoPage extratoPage;

    public ExtratoValidacao (WebDriver driver){

        this.driver = driver;
        extratoPage = new ExtratoPage(this.driver);
    }

    public void validaSaldo(BigDecimal esperado, String nomeEvidencia){

        try {

            BigDecimal atual = Moeda.parse(extratoPage.getSaldoDisponivel().getText());
            Assertions.assertEquals(0, esperado.compareTo(atual),
                    "Saldo no extrato: esperado " + esperado + " mas foi " + atual);
            TakeScreenshot.screenshotPage(driver, nomeEvidencia);

        } catch (Exception | AssertionError e) {

            TakeScreenshot.screenshotPage(driver, nomeEvidencia);
            throw e;
        }
    }


    public void validaTransacao(BigDecimal valor, String descricao, String nomeEvidencia){

        try {

            boolean achouValor = false;
            for (WebElement el : extratoPage.getValores()) {
                String texto = el.getText();
                if (Moeda.temValor(texto) && valor.compareTo(Moeda.parse(texto)) == 0) {
                    achouValor = true;
                    break;
                }
            }

            boolean achouDescricao = false;
            for (WebElement el : extratoPage.getDescricoes()) {
                if (el.getText().contains(descricao)) {
                    achouDescricao = true;
                    break;
                }
            }

            Assertions.assertTrue(achouValor, "Valor " + valor + " nao encontrado no extrato");
            Assertions.assertTrue(achouDescricao, "Descricao '" + descricao + "' nao encontrada no extrato");
            TakeScreenshot.screenshotPage(driver, nomeEvidencia);

        } catch (Exception | AssertionError e) {

            TakeScreenshot.screenshotPage(driver, nomeEvidencia);
            throw e;
        }
    }
}
