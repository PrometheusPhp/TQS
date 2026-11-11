package Framework;

import Framework.Browser.DriverManager;
import Framework.Browser.TypeBrowser;
import Framework.Utils.FileOperations;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class TestBase {

    private static final String URL = FileOperations.getProperties("url").getProperty("index");


    private static TypeBrowser lerBrowser(){

        String nome = System.getProperty("browser", "chrome");

        try {
            return TypeBrowser.valueOf(nome.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Browser invalido: '" + nome + "'. Use chrome, edge, firefox ou headless.");
        }
    }

    public static WebDriver getDriverManager (){

        return DriverManager.getDriver(lerBrowser());
    }


    protected void abrirHome(){

        getDriverManager().get(URL);
    }

    @BeforeEach
    public void setUp(){
        abrirHome();
    }

    @AfterEach
    public void finish(){
        DriverManager.fecharDriver();
    }

}
