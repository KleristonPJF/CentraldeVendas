package controle;

import modelo.Produto;
import modelo.VendaProduto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenciarProdutos {
    private List<Produto> produtos;
    private List<VendaProduto> vendas;

    public GerenciarProdutos() {
        this.produtos = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) {
        if (pesquisarProdutoPorCodigo(produto.getCodigo()) != null) {
            System.out.println("Erro: Já existe um produto cadastrado com o código " + produto.getCodigo());
            return;
        }
        produtos.add(produto);
        System.out.println("Produto cadastrado: " + produto.toString());
    }

    public Produto pesquisarProdutoPorCodigo(String codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }

    public void registrarVenda(String codigoProduto, int quantidade) {
        Produto produto = pesquisarProdutoPorCodigo(codigoProduto);
        if (produto != null) {
            if (produto.getQuantidadeEmEstoque() >= quantidade) {
                produto.reduzirEstoque(quantidade);
                VendaProduto venda = new VendaProduto(produto, quantidade, LocalDate.now());
                vendas.add(venda);
                System.out.println("Venda registrada: " + produto.getNome() + ", Quantidade: " + quantidade + ", Estoque restante: " + produto.getQuantidadeEmEstoque());

                if (produto.isEstoqueZerado()) {
                    produtos.remove(produto);
                    System.out.println("O produto " + produto.getNome() + " foi removido, pois o estoque acabou.");
                }
            } else {
                System.out.println("Erro: Estoque insuficiente. Estoque disponível: " + produto.getQuantidadeEmEstoque());
            }
        } else {
            System.out.println("Produto não encontrado para venda.");
        }
    }

    public List<Produto> listarProdutosPorCategoria(String categoria) {
        List<Produto> produtosCategoria = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getCategoria().equalsIgnoreCase(categoria)) {
                produtosCategoria.add(produto);
            }
        }
        return produtosCategoria;
    }

    public List<VendaProduto> listarVendasDoDia(LocalDate data) {
        List<VendaProduto> vendasDoDia = new ArrayList<>();
        for (VendaProduto venda : vendas) {
            if (venda.getDataVenda().equals(data)) {
                vendasDoDia.add(venda);
            }
        }
        return vendasDoDia;
    }
}
