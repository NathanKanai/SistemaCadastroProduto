package org.example;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        HashMap<Integer, Produto> produtos = new HashMap<>();

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Buscar produto por código");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProduto(scanner, produtos);
                    break;
                case 2:
                    buscarProduto(scanner, produtos);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }

    private static void cadastrarProduto(Scanner scanner, HashMap<Integer, Produto> produtos) {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        if (produtos.containsKey(codigo)) {
            System.out.println("Produto com este código já existe.");
            return;
        }

        System.out.print("Insira o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Insira o preço do produto: ");
        double preco = scanner.nextDouble();

        Produto produto = new Produto(codigo, nome, preco);
        produtos.put(codigo, produto);
        System.out.println("Produto cadastrado!");
    }

    private static void buscarProduto(Scanner scanner, HashMap<Integer, Produto> produtos) {
        System.out.print("Insira o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Produto produto = produtos.get(codigo);
        if (produto != null) {
            System.out.println("Produto encontrado:");
            System.out.println(produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}