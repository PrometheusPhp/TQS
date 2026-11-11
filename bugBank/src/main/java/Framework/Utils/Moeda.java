package Framework.Utils;

import java.math.BigDecimal;

public class Moeda {


    public static BigDecimal parse(String texto){

        String limpo = texto.replaceAll("[^0-9,]", "").replace(",", ".");
        return new BigDecimal(limpo);
    }

    public static boolean temValor(String texto){

        return texto != null && texto.matches(".*\\d.*");
    }
}
