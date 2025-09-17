import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    // ==== CAMADA DE NEGÓCIO ====

    public boolean cadastraLivro(Livro livro) {
        if (livro == null) return false;
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(livro.getTitulo()) &&
                l.getAutor().equalsIgnoreCase(livro.getAutor()) &&
                l.getAnoPublicacao() == livro.getAnoPublicacao()) {
                return false; // duplicado
            }
        }
        return livros.add(livro);
    }

    public boolean removeLivro(String titulo) {
        return livros.removeIf(l -> l.getTitulo().equalsIgnoreCase(titulo));
    }

    public boolean removeLivro(int indice) {
        if (indice >= 0 && indice < livros.size()) {
            livros.remove(indice);
            return true;
        }
        return false;
    }

    public Livro buscaLivro(String titulo) {
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                return l;
            }
        }
        return null;
    }

    public boolean atualizarLivro(int indice, Livro novosDados) {
        if (indice >= 0 && indice < livros.size()) {
            livros.set(indice, novosDados);
            return true;
        }
        return false;
    }

    public List<Livro> listaLivros() {
        return new ArrayList<>(livros);
    }

    public int contagemLivros() {
        return livros.size();
    }

    public List<Livro> pesquisarPorAno(int inicio, int fim) {
        List<Livro> encontrados = new ArrayList<>();
        for (Livro l : livros) {
            if (l.getAnoPublicacao() >= inicio && l.getAnoPublicacao() <= fim) {
                encontrados.add(l);
            }
        }
        return encontrados;
    }

    public Livro livroMaisAntigo() {
        return livros.stream()
                     .min(Comparator.comparingInt(Livro::getAnoPublicacao))
                     .orElse(null);
    }

    public Livro livroMaisNovo() {
        return livros.stream()
                     .max(Comparator.comparingInt(Livro::getAnoPublicacao))
                     .orElse(null);
    }

    // ==== CAMADA DE APRESENTAÇÃO (UI) ====

    public void mostrarMenu() {
        System.out.println("\n=== MENU BIBLIOTECA ===");
        System.out.println("1 - Cadastrar Livro");
        System.out.println("2 - Remover Livro (por título)");
        System.out.println("3 - Remover Livro (por índice)");
        System.out.println("4 - Atualizar Livro");
        System.out.println("5 - Buscar Livro");
        System.out.println("6 - Listar Livros");
        System.out.println("7 - Contagem de Livros");
        System.out.println("8 - Pesquisar por Ano");
        System.out.println("9 - Livro Mais Antigo e Mais Novo");
        System.out.println("0 - Sair");
    }

    public void mostrarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("\n=== LISTA DE LIVROS ===");
            for (int i = 0; i < livros.size(); i++) {
                System.out.println("[" + i + "] " + livros.get(i));
            }
        }
    }

    public void mostrarLivroEncontrado(Livro livro) {
        if (livro != null) {
            System.out.println("Livro encontrado: " + livro);
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    public void mostrarAntigoENovo() {
        Livro antigo = livroMaisAntigo();
        Livro novo = livroMaisNovo();

        if (antigo == null || novo == null) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("Livro mais antigo: " + antigo);
            System.out.println("Livro mais novo: " + novo);
        }
    }

    public void mostrarLivrosAno(List<Livro> encontrados) {
        if (encontrados.isEmpty()) {
            System.out.println("Nenhum livro encontrado nesse intervalo.");
        } else {
            System.out.println("\n=== LIVROS ENCONTRADOS ===");
            for (Livro l : encontrados) {
                System.out.println(l);
            }
        }
    }

    public void mostrarContagem() {
        System.out.println("Total de livros: " + contagemLivros());
    }

    public void mostrarMensagem(String msg) {
        System.out.println(msg);
    }
}
