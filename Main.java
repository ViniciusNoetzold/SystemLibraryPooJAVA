import java.util.List;
import java.util.Scanner;

public class Main {
    private static Biblioteca biblioteca = new Biblioteca();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String menu = """
                === Sistema Biblioteca ===
                Escolha uma das opções abaixo:
                1 - Adicionar Livro
                2 - Listar Acervo
                3 - Pesquisar Livro
                4 - Atualizar Livro
                5 - Remover Livro
                6 - Contar Livros
                7 - Pesquisar por intervalo de anos
                8 - Livro mais antigo
                9 - Livro mais novo
                0 - Sair
                """;
        int opcao;
        do {
            System.out.println(menu);
            opcao = Input.scanInt("Digite sua escolha: ", scan);
            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 2:
                    listarAcervo();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 3:
                    pesquisarLivro();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 4:
                    atualizarLivro();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 5:
                    removerLivro();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 6:
                    contarLivros();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 7:
                    pesquisarPorAno();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 8:
                    livroMaisAntigo();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 9:
                    livroMaisNovo();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 0:
                    System.out.println("Volte Sempre!!!");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private static void cadastrarLivro() {
        String titulo = Input.scanString("Digite o Título: ", scan);
        String autor = Input.scanString("Digite o Autor: ", scan);
        int anoPublicacao = Input.scanInt("Digite o ano de publicação: ", scan);
        int numeroPaginas = Input.scanInt("Digite o número de páginas: ", scan);
        int tipoLivro = Input.scanInt("Livro Físico(1) Livro Digital(2): ", scan);
        Livro novoLivro;
        if (tipoLivro == 1){
            int numeroExemplares = Input.scanInt("Digite o número de exemplares: ", scan);
            String dimensoes = Input.scanString("Digite as dimensões (LxAxP): ", scan);
            novoLivro = new LivroFisico(titulo, autor, anoPublicacao, numeroPaginas, numeroExemplares, dimensoes);
        }
        else{
            String formatoArquivo = Input.scanString("Digite o formato do arquivo (ex: PDF, EPUB): ", scan);
            double tamanhoArquivo = Input.scanDouble("Digite o tamanho do arquivo (MB): ", scan);
            novoLivro = new LivroDigital(titulo, autor, anoPublicacao, numeroPaginas, formatoArquivo, tamanhoArquivo);
        }
        try {
            biblioteca.adicionar(novoLivro);
            System.out.println("Livro adicionado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listarAcervo() {
        var acervo = biblioteca.pesquisar();
        imprimirLista(acervo);
    }

    private static void pesquisarLivro() {
        String titulo = Input.scanString("Digite o título que procuras: ", scan);
        String pesquisaAutor = Input.scanString(
            "Deseja pesquiar por autor? (S/N) ", scan);
        List<Livro> livros;
        if (pesquisaAutor.toLowerCase().charAt(0) == 's'){
            String autor = Input.scanString("Digite o nome do autor: ", scan);
            livros = biblioteca.pesquisar(titulo, autor);
        } else {
            livros = biblioteca.pesquisar(titulo);
        }
        imprimirLista(livros);
    }

    private static void imprimirLista(List<Livro> acervo) {
    if (acervo == null || acervo.isEmpty())
        System.out.println("Nenhum Livro Encontrado");
    else {
        System.out.println("Livros Encontrados");
        for (int i = 0; i < acervo.size(); i++) {
            Livro l = acervo.get(i);
            System.out.println("Livro " + (i + 1) + " (" + l.getTipoLivro() + "): " + l);
        }
    }
}

     private static void removerLivro() {
        var acervo = biblioteca.pesquisar(); 
        if (acervo.isEmpty()) {
            System.out.println("Nenhum livro no acervo para remover.");
            return;
        }

        imprimirLista(acervo);

        int indice = Input.scanInt("Digite o número do livro que deseja remover: ", scan);
        if (indice < 1 || indice > acervo.size()) {
            System.out.println("Opção inválida!");
            return;
        }

        try {
            biblioteca.remover(indice - 1); 
            System.out.println("Livro removido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao remover: " + e.getMessage());
        }
    }

    private static void atualizarLivro() {
    String titulo = Input.scanString("Digite o título do livro que quer atualizar: ", scan);
    List<Livro> encontrados = biblioteca.pesquisar(titulo);

    if (encontrados.isEmpty()) {
        System.out.println("Nenhum livro encontrado com esse título.");
        return;
    }

    imprimirLista(encontrados);

    int escolha = Input.scanInt("Digite o número do livro que deseja atualizar: ", scan);
    if (escolha < 1 || escolha > encontrados.size()) {
        System.out.println("Opção inválida!");
        return;
    }

    Livro livroParaAtualizar = encontrados.get(escolha - 1);

    
    String novoTitulo = Input.scanString("Novo título: ", scan);
    if (!novoTitulo.isEmpty()) livroParaAtualizar.setTitulo(novoTitulo);

    String novoAutor = Input.scanString("Novo autor: ", scan);
    if (!novoAutor.isEmpty()) livroParaAtualizar.setAutor(novoAutor);

    String novoAno = Input.scanString("Novo ano de publicação: ", scan);
    if (!novoAno.isEmpty()) livroParaAtualizar.setAnoPublicacao(Integer.parseInt(novoAno));

    String novoPg = Input.scanString("Novo número de páginas: ", scan);
    if (!novoPg.isEmpty()) livroParaAtualizar.setNumeroPaginas(Integer.parseInt(novoPg));


    if (livroParaAtualizar instanceof LivroFisico fisico) {
        String novosExemplares = Input.scanString("Novo número de exemplares: ", scan);
        if (!novosExemplares.isEmpty()) fisico.setNumeroExemplares(Integer.parseInt(novosExemplares));

        String novasDimensoes = Input.scanString("Novas dimensões (LxAxP): ", scan);
        if (!novasDimensoes.isEmpty()) fisico.setDimensoes(novasDimensoes);

    } else if (livroParaAtualizar instanceof LivroDigital digital) {
        String novoFormato = Input.scanString("Novo formato do arquivo: ", scan);
        if (!novoFormato.isEmpty()) digital.setFormatoArquivo(novoFormato);

        String novoTam = Input.scanString("Novo tamanho do arquivo (MB): ", scan);
        if (!novoTam.isEmpty()) digital.setTamanhoArquivo(Double.parseDouble(novoTam));
    }

    System.out.println("Livro atualizado com sucesso!");
    System.out.println(livroParaAtualizar);
}
    
    private static void contarLivros() {
        int total = biblioteca.contarLivros();
        System.out.println("Total de livros no acervo: " + total);
    }

    private static void pesquisarPorAno() {
        int inicio = Input.scanInt("Digite o ano inicial: ", scan);
        int fim = Input.scanInt("Digite o ano final: ", scan);

        List<Livro> encontrados = biblioteca.pesquisarPorAno(inicio, fim);
        imprimirLista(encontrados);
    }

    
    private static void livroMaisAntigo() {
        Livro antigo = biblioteca.livroMaisAntigo();
        if (antigo == null) {
            System.out.println("Nenhum livro no acervo.");
        } else {
            System.out.println("Livro mais antigo: " + antigo);
        }
    }

    private static void livroMaisNovo() {
        Livro novo = biblioteca.livroMaisNovo();
        if (novo == null) {
            System.out.println("Nenhum livro no acervo.");
        } else {
            System.out.println("Livro mais novo: " + novo);
        }
    }

}

