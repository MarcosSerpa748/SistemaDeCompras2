package br.com.Sistema.Exceptions;

public class ListaVaziaExeption extends RuntimeException {
    private String mensagem;

    public ListaVaziaExeption(String s) {
        this.mensagem = s;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
