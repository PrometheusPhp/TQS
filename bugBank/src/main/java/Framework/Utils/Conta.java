package Framework.Utils;

import java.math.BigDecimal;

public class Conta {

    private final String nome;
    private final String email;
    private final String senha;
    private final BigDecimal saldoInicial;
    private String numero;
    private String digito;

    public Conta(String nome, String email, String senha, BigDecimal saldoInicial){

        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.saldoInicial = saldoInicial;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public BigDecimal getSaldoInicial() { return saldoInicial; }
    public String getNumero() { return numero; }
    public String getDigito() { return digito; }

    //Preenchidos depois do cadastro, a partir da mensagem de sucesso do BugBank
    public void setNumero(String numero) { this.numero = numero; }
    public void setDigito(String digito) { this.digito = digito; }
}
