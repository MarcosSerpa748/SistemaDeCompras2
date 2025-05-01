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
                    Comprar produto,
                    Comprar produto perecivel,
                    Mostrar carrinho,
                    -1 para finalizar programa.
                    """);
            String minhaEsco = sc.nextLine();
            switch (minhaEsco){
                case "Comprar produto":
                    System.out.println("Digite o nome do produto:");
                    String nomeP = sc.nextLine();
                    System.out.println("Digite o valor desse produto:");
                    double valorP = sc.nextDouble();
                   try {
                       Produto p1 = new Produto(nomeP, valorP);
                       c.Adicionar(u1, p1);
                   }catch (SaldoInsuficienteException e){
                       System.out.println(e.getMessage());
                   }
                    break;
                case"Comprar produto perecivel":
                    System.out.println("Digite o nome do produto:");
                    String nomePP = sc.nextLine();
                    System.out.println("Digite o valor do produto:");
                    double valorPP = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite a data de validade do produto:");
                    String validade = sc.nextLine();
                    try {
                        ProdutoPerecivel pp = new ProdutoPerecivel(nomePP, valorPP, validade);
                        c.Adicionar(u1, pp);
                    }catch (SaldoInsuficienteException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Mostrar carrinho":
                    try {
                        c.mostrarCarrinho();
                    }catch (ListaVaziaExeption e2){
                        System.out.println(e2.getMessage());
                    }
                    break;
                case "-1":
                    System.out.println("Finalizando programa....");
                    n = -1;
            }
        }
    }
}