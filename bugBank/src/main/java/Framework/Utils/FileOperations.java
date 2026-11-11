package Framework.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileOperations {


    public static Properties getProperties(String fileName){

        String caminho = "Properties/" + fileName + ".properties";
        Properties prop = new Properties();

        try (InputStream input = FileOperations.class.getClassLoader().getResourceAsStream(caminho)) {

            if (input == null) {
                throw new IllegalStateException("Arquivo de propriedade nao encontrado: " + caminho);
            }
            prop.load(input);
            return prop;

        } catch (IOException e) {

            throw new IllegalStateException("Nao foi possivel carregar o arquivo de propriedade: " + caminho, e);
        }
    }
}
