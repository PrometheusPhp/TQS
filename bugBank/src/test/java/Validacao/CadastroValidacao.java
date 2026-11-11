package Validacao;

import Framework.Utils.TakeScreenshot;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CadastroValidacao {

    private final WebDriver driver;

    public CadastroValidacao (WebDriver driver){

        this.driver = driver;
    }

    public void validaContaCriada(String textoModal, String nomeEvidencia){

        try {

            Assertions.assertTrue(textoModal.toLowerCase().contains("criada com sucesso"),
                    "Mensagem inesperada ao criar a conta: " + textoModal);
            TakeScreenshot.screenshotPage(driver, nomeEvidencia);

        } catch (Exception | AssertionError e) {

            TakeScreenshot.screenshotPage(driver, nomeEvidencia);
            throw e;
        }
    }
}
