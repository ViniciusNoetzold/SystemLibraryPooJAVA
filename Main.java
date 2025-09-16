
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU BIBLIOTECA =====");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Remover livro");
            System.out.println("4 - Atualizar livro");
            System.out.println("5 - Contar livros");
            System.out.println("6 - Pesquisar por intervalo de anos");
            System.out.println("7 - Mostrar livro mais antigo");
            System.out.println("8 - Mostrar livro mais novo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            String entrada = sc.nextLine();
            int opcao;
            try {
                opcao = Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida.");
                continue;
            }

            if (opcao == 0) {
                System.out.println("Saindo...");
                break;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Ano: ");
                    String anoStr = sc.nextLine();
                    try {
                        int ano = Integer.parseInt(anoStr.trim());
                        biblioteca.adicionar(new Livro(titulo, autor, ano));
                    } catch (NumberFormatException e) {
                        System.out.println("Ano inválido. Tente novamente.");
                    }
                    break;

                case 2:
                    biblioteca.listar();
                    break;

                case 3:
                    biblioteca.listar();
                    System.out.print("Digite o índice do livro para remover: ");
                    String idxRem = sc.nextLine();
                    try {
                        int indiceRemover = Integer.parseInt(idxRem.trim());
                        biblioteca.remover(indiceRemover);
                    } catch (NumberFormatException e) {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 4:
                    biblioteca.listar();
                    System.out.print("Digite o índice do livro para atualizar: ");
                    String idxUpdStr = sc.nextLine();
                    try {
                        int indiceAtualizar = Integer.parseInt(idxUpdStr.trim());
                        System.out.print("Novo título: ");
                        String novoTitulo = sc.nextLine();
                        System.out.print("Novo autor: ");
                        String novoAutor = sc.nextLine();
                        System.out.print("Novo ano: ");
                        String novoAnoStr = sc.nextLine();
                        int novoAno = Integer.parseInt(novoAnoStr.trim());
                        biblioteca.atualizar(indiceAtualizar, new Livro(novoTitulo, novoAutor, novoAno));
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Atualização cancelada.");
                    }
                    break;

                case 5:
                    System.out.println("Total de livros: " + biblioteca.contarLivros());
                    break;

                case 6:
                    System.out.print("Ano inicial: ");
                    String inicioStr = sc.nextLine();
                    System.out.print("Ano final: ");
                    String fimStr = sc.nextLine();
                    try {
                        int inicio = Integer.parseInt(inicioStr.trim());
                        int fim = Integer.parseInt(fimStr.trim());
                        biblioteca.pesquisarPorAno(inicio, fim);
                    } catch (NumberFormatException e) {
                        System.out.println("Ano inválido.");
                    }
                    break;

                case 7:
                    Livro antigo = biblioteca.maisAntigo();
                    if (antigo == null) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        System.out.println("Livro mais antigo: " + antigo);
                    }
                    break;

                case 8:
                    Livro novo = biblioteca.maisNovo();
                    if (novo == null) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        System.out.println("Livro mais novo: " + novo);
                    }
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}
