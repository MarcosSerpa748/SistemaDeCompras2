package br.com.Sistema.Exceptions;

public class SaldoInsuficienteException extends RuntimeException {
    private String mensagem;
    public SaldoInsuficienteException(String s) {
        this.mensagem = s;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
