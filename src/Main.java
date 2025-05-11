import br.com.Sistema.Exceptions.ListaVaziaExeption;
import br.com.Sistema.Exceptions.SaldoInsuficienteException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Carrinho c = new Carrinho();
        int n = 0;

        System.out.println("Digite seu nome:");
        String nome = sc.nextLine();

        System.out.println("Digite seu saldo:");
        double saldo = sc.nextDouble();
        sc.nextLine();

        Usuario u1 = new Usuario(nome,saldo);
        while (n !=-1){
            System.out.println("""
                    Opções de escolha:
                    Adicionar produto,
                    Adicionar produto perecivel,
                    Mostrar carrinho,
                    Remover do carrinho,
                    Comprar os produtos,
                    -1 para finalizar programa.
                    """);
            String minhaEsco = sc.nextLine();
            switch (minhaEsco){
                case "Adicionar produto":
                    System.out.println("Digite o nome do produto e seu valor:");
                    String nomeP = sc.nextLine();
                    double valorP = sc.nextDouble();
                    Produto p1 = new Produto(nomeP, valorP);
                    c.Adicionar(p1);
                    sc.nextLine();
                    break;
                case"Adicionar produto perecivel":
                    System.out.println("Digite o nome do produto, seu valor e sua validade:");
                    String nomePP = sc.nextLine();
                    double valorPP = sc.nextDouble();
                    sc.nextLine();
                    String validade = sc.nextLine();
                    ProdutoPerecivel pp = new ProdutoPerecivel(nomePP, valorPP, validade);
                    c.Adicionar(pp);
                    break;
                case "Mostrar carrinho":
                    try {
                        c.mostrarCarrinho(u1);
                    }catch (ListaVaziaExeption e2){
                        System.out.println(e2.getMessage());
                    }
                    break;
                case "Remover produto":
                    System.out.println("Indique o produto que deseja remover pelo seu índicie:");
                    int indicie = sc.nextInt();
                    c.removerDoCarrinho(indicie);
                    sc.nextLine();
                    break;
                case "Comprar os produtos":
                    try {
                     c.comprar(u1);
                    }catch (SaldoInsuficienteException e2){
                        System.out.println(e2.getMessage());
                    }
                    break;
                case "-1":
                    System.out.println("Finalizando programa....");
                    n = -1;
                    break;
            }
        }
    }
}