package br.com.classes;

public class Usuario {
    protected String nome;
    protected double saldo;

    public Usuario(String nome, double saldo){
        this.nome = nome;
        this.saldo = saldo;
    }
    public  Usuario(){

    }
    @SuppressWarnings("unused")
    public String getNome() {
        return this.nome;
    }

    public double getSaldo() {
        return this.saldo;
    }

}
