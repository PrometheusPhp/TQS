package TestCases;

import Framework.TestBase;
import Framework.Utils.Conta;
import Framework.Utils.FakersGeneration;
import Framework.Utils.FileOperations;
import Framework.Utils.RegistroContas;
import Framework.Utils.RegistroContas;
import Framework.Utils.TakeScreenshot;
import Tasks.CadastroTask;
import Tasks.ExtratoTask;
import Tasks.HomeTask;
import Tasks.LoginTask;
import Tasks.TransferenciaTask;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;
import java.util.Properties;

@Epic("Teste Banco Digital")
@Feature("Transferencia entre contas")
public class TransferenciaEntreContasTest extends TestBase {

    private final WebDriver driver = getDriverManager();

    CadastroTask cadastroTask = new CadastroTask(driver);
    LoginTask loginTask = new LoginTask(driver);
    HomeTask homeTask = new HomeTask(driver);
    TransferenciaTask transferenciaTask = new TransferenciaTask(driver);
    ExtratoTask extratoTask = new ExtratoTask(driver);

    @Test
    @Story("Usuario transfere valor entre duas contas com saldo e confere os dois extratos")
    @Description("Cadastra duas contas com saldo, transfere da primeira para a segunda e valida saldo e extrato das duas")
    public void realizarTransferencia() {

        Properties config = FileOperations.getProperties("conta");
        BigDecimal saldoInicial = new BigDecimal(config.getProperty("saldoInicial"));
        BigDecimal valor = new BigDecimal(config.getProperty("valorTransferencia"));
        String descricao = config.getProperty("descricaoTransferencia");

        FakersGeneration faker = new FakersGeneration();
        String senha = faker.getPassword();
        Conta origem = new Conta(faker.getFullName(), faker.getEmail(), senha, saldoInicial);
        Conta destino = new Conta(faker.getFullName(), faker.getEmail(), senha, saldoInicial);

        try {


            cadastroTask.cadastrarConta(origem);
            abrirHome();
            cadastroTask.cadastrarConta(destino);
            RegistroContas.registrar(origem, destino);
            abrirHome();


            loginTask.efetuarLogin(origem);
            homeTask.validarSaldo(saldoInicial, "Home origem - saldo inicial");
            transferenciaTask.transferir(destino, valor, descricao);


            extratoTask.validarExtratoOrigem(saldoInicial.subtract(valor), valor, descricao);
            homeTask.sair();

            //6: extrato da conta que recebeu
            loginTask.efetuarLogin(destino);
            homeTask.validarSaldo(saldoInicial.add(valor), "Home destino - saldo final");
            extratoTask.validarExtratoDestino(saldoInicial.add(valor), valor, descricao);

        } catch (Exception | AssertionError e) {

            TakeScreenshot.screenshotPage(driver, "ERRO");
            throw e;

        } finally {


            RegistroContas.registrar(origem, destino);
        }
    }
}
