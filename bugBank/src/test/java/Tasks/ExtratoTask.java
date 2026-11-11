package Tasks;

import Framework.Browser.Waits;
import PageObjects.ExtratoPage;
import PageObjects.GenericPage;
import PageObjects.HomePage;
import Validacao.ExtratoValidacao;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public class ExtratoTask {

    private final HomePage homePage;
    private final ExtratoPage extratoPage;
    private final GenericPage genericPage;
    private final ExtratoValidacao extratoValidacao;
    private final Waits waits;

    public ExtratoTask (WebDriver driver){

        homePage = new HomePage(driver);
        extratoPage = new ExtratoPage(driver);
        genericPage = new GenericPage(driver);
        extratoValidacao = new ExtratoValidacao(driver);
        waits = new Waits(driver);
    }

    private void abrirExtrato(){

        homePage.getExtratoButton().click();
        waits.loadElement(extratoPage.getSaldoDisponivel());
    }


    public void validarExtratoOrigem(BigDecimal saldoEsperado, BigDecimal valor, String descricao){

        abrirExtrato();
        extratoValidacao.validaSaldo(saldoEsperado, "Extrato origem - saldo");
        extratoValidacao.validaTransacao(valor, descricao, "Extrato origem - transferencia");
        genericPage.getVoltarButton().click();
    }


    public void validarExtratoDestino(BigDecimal saldoEsperado, BigDecimal valor, String descricao){

        abrirExtrato();
        extratoValidacao.validaSaldo(saldoEsperado, "Extrato destino - saldo");
        extratoValidacao.validaTransacao(valor, descricao, "Extrato destino - transferencia");
        genericPage.getVoltarButton().click();
    }
}
