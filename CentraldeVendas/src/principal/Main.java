package principal;

import controle.GerenciarProdutos;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import modelo.Alimento;
import modelo.Limpeza;
import modelo.Produto;
import modelo.VendaProduto;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciarProdutos gerenciarProdutos = new GerenciarProdutos();
        
        int opcao;
        do {
            System.out.println("\nCentral de Vendas");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Pesquisar Produto por Código");
            System.out.println("3. Listar Produtos por Categoria");
            System.out.println("4. Registrar Venda");
            System.out.println("5. Listar Vendas do Dia");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProduto(scanner, gerenciarProdutos);
                    break;
                case 2:
                    pesquisarProduto(scanner, gerenciarProdutos);
                    break;
                case 3:
                    listarProdutosPorCategoria(scanner, gerenciarProdutos);
                    break;
                case 4:
                    registrarVenda(scanner, gerenciarProdutos);
                    break;
                case 5:
                    listarVendasDoDia(gerenciarProdutos);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
        
        scanner.close();
    }

    private static void cadastrarProduto(Scanner scanner, GerenciarProdutos gerenciarProdutos) {
        System.out.print("Digite o código do produto: ");
        String codigo = scanner.nextLine();
    
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
    
        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
    
        System.out.print("Digite a quantidade em estoque: ");
        int quantidadeEmEstoque = scanner.nextInt();
        scanner.nextLine();
    
        System.out.print("Digite a categoria do produto (1 - Alimento, 2 - Limpeza): ");
        int categoria = scanner.nextInt();
        scanner.nextLine();
    
        Produto produto;
        if (categoria == 1) {
            System.out.print("Digite as informações nutricionais: ");
            String informacoesNutricionais = scanner.nextLine();
    
            System.out.print("Digite a categoria do alimento (perecível, não perecível, congelado, etc.): ");
            String categoriaAlimento = scanner.nextLine();
    
            produto = new Alimento(codigo, nome, preco, quantidadeEmEstoque, informacoesNutricionais, categoriaAlimento);
        } else if (categoria == 2) {
            System.out.print("Digite o nível de toxicidade: ");
            String nivelToxicidade = scanner.nextLine();
    
            produto = new Limpeza(codigo, nome, preco, quantidadeEmEstoque, nivelToxicidade);
        } else {
            System.out.println("Categoria inválida. Produto não cadastrado.");
            return;
        }
    
        gerenciarProdutos.cadastrarProduto(produto);
    }
    

    private static void pesquisarProduto(Scanner scanner, GerenciarProdutos gerenciarProdutos) {
        System.out.print("Digite o código do produto: ");
        String codigo = scanner.nextLine();

        Produto produto = gerenciarProdutos.pesquisarProdutoPorCodigo(codigo);
        if (produto != null) {
            System.out.println("Produto encontrado: " + produto.getNome() + ", Preço: R$" + produto.getPreco() + ", Categoria: " + produto.getCategoria() + ", Estoque: " + produto.getQuantidadeEmEstoque());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void listarProdutosPorCategoria(Scanner scanner, GerenciarProdutos gerenciarProdutos) {
        System.out.print("Digite a categoria para listar (Alimento ou Limpeza): ");
        String categoria = scanner.nextLine();
        
    
        System.out.println("Produtos da categoria " + categoria + ":");
        List<Produto> produtos = gerenciarProdutos.listarProdutosPorCategoria(categoria);
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado para a categoria " + categoria + ".");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto.toString());
            }
        }
    }
    

    private static void registrarVenda(Scanner scanner, GerenciarProdutos gerenciarProdutos) {
        System.out.print("Digite o código do produto para venda: ");
        String codigoProduto = scanner.nextLine();

        System.out.print("Digite a quantidade vendida: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); 

        gerenciarProdutos.registrarVenda(codigoProduto, quantidade);
    }

    private static void listarVendasDoDia(GerenciarProdutos gerenciarProdutos) {
        LocalDate hoje = LocalDate.now();
        System.out.println("Vendas do dia " + hoje + ":");
    
        List<VendaProduto> vendasDoDia = gerenciarProdutos.listarVendasDoDia(hoje);
    
        if (vendasDoDia.isEmpty()) {
            System.out.println("Nenhuma venda registrada para hoje.");
        } else {
            for (VendaProduto venda : vendasDoDia) {
            System.out.println(venda.getProduto().getNome() + " - Quantidade: " + venda.getQuantidade() + " - Total: R$ " + venda.getValorTotal());
            }
        }
    }
}
