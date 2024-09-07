package modelo;

public class Alimento extends Produto {
    private String informacoesNutricionais;
    private String categoriaAlimento;

    public Alimento(String codigo, String nome, double preco, int quantidadeEmEstoque, String informacoesNutricionais, String categoriaAlimento) {
        super(codigo, nome, preco, "Alimento", quantidadeEmEstoque);
        this.informacoesNutricionais = informacoesNutricionais;
        this.categoriaAlimento = categoriaAlimento;
    }

    public String getInformacoesNutricionais() {
        return informacoesNutricionais;
    }

    public String getCategoriaAlimento() {
        return categoriaAlimento;
    }

    @Override
    public String toString() {
        return super.toString() + ", Informações Nutricionais: " + informacoesNutricionais + ", Categoria: " + categoriaAlimento;
    }
}
