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

    public void Adicionar(Usuario u,Produto p){
        if (u.getSaldo()<p.getValor()){
            throw new SaldoInsuficienteException("Saldo insuficiente! Saldo atual:R$"+u.getSaldo());
        }else{
             u.saldo -= p.getValor();
            this.carrinho.add(p);
            System.out.println("Produto adicionado ao carrinho.");
        }
    }
    public void mostrarCarrinho(){
        if (this.carrinho.isEmpty()){
            throw new ListaVaziaExeption("A lista está vazia.");
        }else{
            carrinho.sort(Comparator.comparing(Produto::getValor));
            for(Produto i:carrinho){
                System.out.println(i);
            }
        }
    }
    public void removerDoCarrinho(int indicie){
        this.carrinho.remove(indicie);

    }
}
