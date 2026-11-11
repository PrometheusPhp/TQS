package Tasks;

import Framework.Utils.Conta;
import PageObjects.GenericPage;
import PageObjects.HomePage;
import PageObjects.TransferenciaPage;
import Validacao.TransferenciaValidacao;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public class TransferenciaTask {

    private final HomePage homePage;
    private final TransferenciaPage transferenciaPage;
    private final GenericPage genericPage;
    private final TransferenciaValidacao transferenciaValidacao;

    public TransferenciaTask (WebDriver driver){

        homePage = new HomePage(driver);
        transferenciaPage = new TransferenciaPage(driver);
        genericPage = new GenericPage(driver);
        transferenciaValidacao = new TransferenciaValidacao(driver);
    }


    public void transferir(Conta destino, BigDecimal valor, String descricao){

        homePage.getTransferenciaButton().click();

        transferenciaPage.getNumeroContaInput().sendKeys(destino.getNumero());
        transferenciaPage.getDigitoInput().sendKeys(destino.getDigito());
        transferenciaPage.getValorInput().sendKeys(valor.toPlainString());
        transferenciaPage.getDescricaoInput().sendKeys(descricao);
        transferenciaPage.getTransferirButton().click();

        transferenciaValidacao.validaTransferenciaRealizada(genericPage.getModalText().getText());

        genericPage.getCloseModalButton().click();
        genericPage.aguardarModalFechar();
        genericPage.getVoltarButton().click();
    }
}
