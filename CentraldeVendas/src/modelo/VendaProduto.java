package modelo;

import java.time.LocalDate;

public class VendaProduto {
    private Produto produto;
    private int quantidade;
    private LocalDate dataVenda;

    public VendaProduto(Produto produto, int quantidade, LocalDate dataVenda) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.dataVenda = dataVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public double getValorTotal() {
        return quantidade * produto.getPreco();
    }
}
