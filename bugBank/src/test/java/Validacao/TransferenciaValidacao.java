package Validacao;

import Framework.Utils.TakeScreenshot;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class TransferenciaValidacao {

    private final WebDriver driver;

    public TransferenciaValidacao (WebDriver driver){

        this.driver = driver;
    }

    public void validaTransferenciaRealizada(String textoModal){

        try {

            Assertions.assertTrue(textoModal.toLowerCase().contains("realizada com sucesso"),
                    "Mensagem inesperada ao transferir: " + textoModal);
            TakeScreenshot.screenshotPage(driver, "Transferencia realizada");

        } catch (Exception | AssertionError e) {

            TakeScreenshot.screenshotPage(driver, "Transferencia realizada");
            throw e;
        }
    }
}
