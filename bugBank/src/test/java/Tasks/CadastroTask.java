package Tasks;

import Framework.Browser.Waits;
import Framework.Utils.Conta;
import PageObjects.CadastroPage;
import PageObjects.GenericPage;
import PageObjects.LoginPage;
import Validacao.CadastroValidacao;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroTask {

    private static final Pattern NUMERO_CONTA = Pattern.compile("(\\d+)-(\\d+)");

    private final LoginPage loginPage;
    private final CadastroPage cadastroPage;
    private final GenericPage genericPage;
    private final CadastroValidacao cadastroValidacao;
    private final Waits waits;

    public CadastroTask (WebDriver driver){

        loginPage = new LoginPage(driver);
        cadastroPage = new CadastroPage(driver);
        genericPage = new GenericPage(driver);
        cadastroValidacao = new CadastroValidacao(driver);
        waits = new Waits(driver);
    }


    public void cadastrarConta(Conta conta){

        loginPage.getRegistrarButton().click();

        cadastroPage.getEmailInput().sendKeys(conta.getEmail());
        cadastroPage.getNomeInput().sendKeys(conta.getNome());
        cadastroPage.getSenhaInput().sendKeys(conta.getSenha());
        cadastroPage.getConfirmaSenhaInput().sendKeys(conta.getSenha());
        waits.clickJs(cadastroPage.getSaldoToggle());
        cadastroPage.getCadastrarButton().click();

        String textoModal = genericPage.getModalText().getText();
        cadastroValidacao.validaContaCriada(textoModal, "Cadastro - " + conta.getNome());

        Matcher matcher = NUMERO_CONTA.matcher(textoModal);
        if (!matcher.find()) {
            throw new IllegalStateException("Nao foi possivel ler o numero da conta em: " + textoModal);
        }
        conta.setNumero(matcher.group(1));
        conta.setDigito(matcher.group(2));

        genericPage.getCloseModalButton().click();
        genericPage.aguardarModalFechar();
    }
}
