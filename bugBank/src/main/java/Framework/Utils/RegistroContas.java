package Framework.Utils;

import io.qameta.allure.Allure;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroContas {


    private static final Path ARQUIVO = Path.of("evidencias", "contas-criadas.txt");

    public static void registrar(Conta origem, Conta destino){

        StringBuilder texto = new StringBuilder();
        texto.append("Contas criadas pelo teste - ")
                .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")))
                .append("\n\n");
        adicionar(texto, "CONTA DE ORIGEM (enviou a transferencia)", origem);
        adicionar(texto, "CONTA DE DESTINO (recebeu a transferencia)", destino);

        String conteudo = texto.toString();

        System.out.println(conteudo);

        try {
            Files.createDirectories(ARQUIVO.getParent());
            Files.writeString(ARQUIVO, conteudo, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException("Nao foi possivel gravar " + ARQUIVO, e);
        }

        Allure.addAttachment("Contas criadas", "text/plain", conteudo, ".txt");
    }

    private static void adicionar(StringBuilder texto, String titulo, Conta conta){

        String numero = conta.getNumero() == null
                ? "(conta nao foi criada)"
                : conta.getNumero() + "-" + conta.getDigito();

        texto.append(titulo).append("\n")
                .append("  Nome:   ").append(conta.getNome()).append("\n")
                .append("  E-mail: ").append(conta.getEmail()).append("\n")
                .append("  Senha:  ").append(conta.getSenha()).append("\n")
                .append("  Conta:  ").append(numero).append("\n")
                .append("  Saldo inicial: ").append(conta.getSaldoInicial()).append("\n\n");
    }
}
