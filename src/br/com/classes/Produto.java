package br.com.classes;

public class Produto {
    private String nome;
    private double valor;

    public Produto(String nome, double valor){
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "br.com.classes.Produto[Nome:"+this.getNome()+",Valor:R$"+this.getValor()+"]";
    }
}
