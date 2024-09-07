package modelo;

public class Limpeza extends Produto {
    private String nivelToxicidade;

    public Limpeza(String codigo, String nome, double preco, int quantidadeEmEstoque, String nivelToxicidade) {
        super(codigo, nome, preco, "Limpeza", quantidadeEmEstoque);
        this.nivelToxicidade = nivelToxicidade;
    }

    public String getNivelToxicidade() {
        return nivelToxicidade;
    }

    @Override
    public String toString() {
        return super.toString() + ", Nível de Toxicidade: " + nivelToxicidade;
    }
}
