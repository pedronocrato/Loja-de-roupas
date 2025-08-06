import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Programa {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto> carrinho = new ArrayList<>();
        boolean continuar = true;

        System.out.println("--Loja de Roupa--");
        System.out.println();

        while (continuar) {
            System.out.println("Escolha o tipo de produto: ");
            System.out.println("1 - Camisa");
            System.out.println("2 - Calça");
            System.out.println("3 - Calçado");
            System.out.println("4 - Perfume");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            int tipo = sc.nextInt();
            sc.nextLine();
            if(tipo == 0) break;

            Produto produto = null;
            String modelo = "";
            String tamanho;

            try {
                switch (tipo) {
                    case 1 -> {
                        System.out.println("\nModelos de Camisa:");
                        modelo = escolherModelo(new String[]{"Slim Fit", "Oversized", "Polo"});
                        System.out.print("Digite o tamanho (P, M, G, GG): ");
                        tamanho = sc.nextLine();
                        produto = new Camisa(modelo, tamanho);
                    }
                    case 2 -> {
                        System.out.println("\nModelos de Calça:");
                        modelo = escolherModelo(new String[]{"Social", "Alfaiataria", "Jeans"});
                        System.out.print("Digite o tamanho (P, M, G, GG): ");
                        tamanho = sc.nextLine();
                        produto = new Calca(modelo, tamanho);
                    }
                    case 3 -> {
                        System.out.println("\nModelos de Calçado:");
                        modelo = escolherModelo(new String[]{"Social", "Tenis", "Esportivo"});
                        System.out.print("Digite o tamanho (número): ");
                        tamanho = sc.nextLine();
                        produto = new Calcado(modelo, tamanho);
                    }
                    case 4 -> {
                        System.out.println("\nModelos de Perfume:");
                        modelo = escolherModelo(new String[]{"Dia a dia", "Marcantes", "Frescos"});
                        System.out.print("Digite o tamanho (50, 100, 150, 200 ml): ");
                        tamanho = sc.nextLine();
                        produto = new Perfume(modelo, tamanho);
                    }
                    default -> System.out.println("Opção inválida!");
                }

                if (produto != null) {
                    System.out.println("\nResumo do produto selecionado:");
                    System.out.println(produto.getResumo());

                    System.out.println("Escolha a forma de pagamento:");
                    System.out.println("1 - Pix (10% de desconto)");
                    System.out.println("2 - Parcelado (20% de acréscimo)");
                    System.out.print("Opção: ");
                    int opcaoPagamento = sc.nextInt();
                    sc.nextLine();

                    if (opcaoPagamento == 1) {
                        System.out.printf("Valor com Pix: R$%.2f\n", produto.pagarPix());
                    } else if (opcaoPagamento == 2) {
                        double total = produto.pagarParcelado();
                        int parcelas = 3;
                        double valorParcela = total / parcelas;
                        System.out.printf("Valor parcelado: R$%.2f em %dx de R$%.2f\n", total, parcelas, valorParcela);
                    } else {
                        System.out.println("Forma de pagamento inválida.");
                    }

                    carrinho.add(produto);


                }


            } catch (Exception e) {
                System.out.println("Erro ao cadastrar produto: " + e.getMessage());
            }

            System.out.print("\nDeseja continuar? (s/n): ");
            String resp = sc.nextLine();
            if(!resp.equalsIgnoreCase("s"))
                continuar = false;

            System.out.println("\nCarrinho: " + carrinho);
            for(Produto p : carrinho) {
                System.out.println(p.getResumo());
            }
        }

        salvarProdutos(carrinho);
    }

    private static String escolherModelo(String[] opcoes) {
        for (int i = 0; i < opcoes.length; i++) {
            System.out.printf("%d - %s\n", i + 1, opcoes[i]);
        }
        System.out.print("Escolha o modelo: ");
        int escolha = sc.nextInt();
        sc.nextLine();
        return opcoes[escolha - 1];
    }

    private static void salvarProdutos(List<Produto> produtos) {
        String pasta = "dados/carrinhos";
        String nomeArquivo = "produtos.csv";

        try {
            File diretorio = new File(pasta);
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }

            File arquivo = new File(diretorio, nomeArquivo);
            FileWriter fw = new FileWriter(arquivo);
            PrintWriter pw = new PrintWriter(fw);


            for (Produto produto : produtos) {
                pw.println(produto.toCSV());
            }

            pw.close();
            System.out.println("\nProdutos salvos com sucesso em: " + arquivo.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }


}
