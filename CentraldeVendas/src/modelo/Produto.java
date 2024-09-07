package modelo;

public abstract class Produto {
    private String codigo;
    private String nome;
    private double preco;
    private String categoria;
    private int quantidadeEmEstoque;

    public Produto(String codigo, String nome, double preco, String categoria, int quantidadeEmEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void reduzirEstoque(int quantidade) {
        this.quantidadeEmEstoque -= quantidade;
    }

    public boolean isEstoqueZerado() {
        return this.quantidadeEmEstoque == 0;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Preço: R$" + preco + ", Quantidade em Estoque: " + quantidadeEmEstoque;
    }
}
