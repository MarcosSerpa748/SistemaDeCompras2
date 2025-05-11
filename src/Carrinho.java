import br.com.Sistema.Exceptions.ListaVaziaExeption;
import br.com.Sistema.Exceptions.SaldoInsuficienteException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrinho extends Usuario {
    private List<Produto>carrinho;

    public Carrinho(){
        this.carrinho = new ArrayList<>();
    }

    public void Adicionar(Produto p){
             carrinho.add(p);
            System.out.println("Produto adicionado ao carrinho.");

    }
    public void mostrarCarrinho(Usuario u){
        if (this.carrinho.isEmpty()){
            throw new ListaVaziaExeption("A lista está vazia.");
        }else{
            carrinho.sort(Comparator.comparing(Produto::getValor));
            for(Produto i:carrinho){
                System.out.println(i);
            }
            System.out.println("Seu saldo:R$"+u.getSaldo());
        }
    }
    public void removerDoCarrinho(int indicie){
        carrinho.remove(indicie);
        System.out.println("Produto removido do carrinho.");
    }
    public void comprar(Usuario u){
        double valorTotal = 0;
        for (Produto i:carrinho){
            valorTotal += i.getValor();
        }
        if (valorTotal> u.saldo){
            throw new SaldoInsuficienteException("Saldo insuficiente! Saldo atual:"+u.getSaldo());
        }else{
            u.saldo -= valorTotal;
            System.out.println("Compra feita com sucesso");
            carrinho.clear();
        }
    }
}
