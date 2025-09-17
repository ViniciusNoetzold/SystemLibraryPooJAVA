public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        int opcao;

        do {
            biblioteca.mostrarMenu();
            opcao = Input.lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> {
                    String titulo = Input.lerTexto("Título: ");
                    String autor = Input.lerTexto("Autor: ");
                    int ano = Input.lerInteiro("Ano de publicação: ");
                    int paginas = Input.lerInteiro("Número de páginas: ");

                    Livro livro = new Livro(titulo, autor, ano, paginas);
                    if (biblioteca.cadastraLivro(livro)) {
                        biblioteca.mostrarMensagem("Livro cadastrado com sucesso!");
                    } else {
                        biblioteca.mostrarMensagem("Erro: Livro duplicado ou inválido!");
                    }
                }
                case 2 -> {
                    String titulo = Input.lerTexto("Digite o título do livro para remover: ");
                    if (biblioteca.removeLivro(titulo)) {
                        biblioteca.mostrarMensagem("Livro removido com sucesso!");
                    } else {
                        biblioteca.mostrarMensagem("Livro não encontrado!");
                    }
                }
                case 3 -> {
                    int indice = Input.lerInteiro("Digite o índice do livro para remover: ");
                    if (biblioteca.removeLivro(indice)) {
                        biblioteca.mostrarMensagem("Livro removido com sucesso!");
                    } else {
                        biblioteca.mostrarMensagem("Índice inválido!");
                    }
                }
                case 4 -> {
                    biblioteca.mostrarLivros();
                    int indice = Input.lerInteiro("Digite o índice do livro a atualizar: ");

                    String titulo = Input.lerTexto("Novo título: ");
                    String autor = Input.lerTexto("Novo autor: ");
                    int ano = Input.lerInteiro("Novo ano de publicação: ");
                    int paginas = Input.lerInteiro("Novo número de páginas: ");

                    Livro novo = new Livro(titulo, autor, ano, paginas);

                    if (biblioteca.atualizarLivro(indice, novo)) {
                        biblioteca.mostrarMensagem("Livro atualizado com sucesso!");
                    } else {
                        biblioteca.mostrarMensagem("Erro ao atualizar livro!");
                    }
                }
                case 5 -> {
                    String titulo = Input.lerTexto("Digite o título do livro para buscar: ");
                    Livro livro = biblioteca.buscaLivro(titulo);
                    biblioteca.mostrarLivroEncontrado(livro);
                }
                case 6 -> biblioteca.mostrarLivros();
                case 7 -> biblioteca.mostrarContagem();
                case 8 -> {
                    int inicio = Input.lerInteiro("Ano inicial: ");
                    int fim = Input.lerInteiro("Ano final: ");
                    biblioteca.mostrarLivrosAno(biblioteca.pesquisarPorAno(inicio, fim));
                }
                case 9 -> biblioteca.mostrarAntigoENovo();
                case 0 -> biblioteca.mostrarMensagem("Saindo...");
                default -> biblioteca.mostrarMensagem("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
