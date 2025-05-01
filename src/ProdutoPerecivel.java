public class ProdutoPerecivel extends Produto{
    private String validade;

    public ProdutoPerecivel(String nome, double valor,String validade){
        super(nome, valor);
        this.validade = validade;
    }

    public String getValidade() {
        return validade;
    }

    @Override
    public String toString() {
        return "Produto Perecível[Nome:"+getNome()+",Valor:R$"+getValor()+",Validade:"+getValidade()+"]";
    }
}
