
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    // Evita duplicidade: titulo + autor + ano
    public void adicionar(Livro livro) {
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(livro.getTitulo()) &&
                l.getAutor().equalsIgnoreCase(livro.getAutor()) &&
                l.getAno() == livro.getAno()) {
                System.out.println("Esse livro já está cadastrado!");
                return;
            }
        }
        livros.add(livro);
        System.out.println("Livro adicionado com sucesso!");
    }

    public void listar() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("\n--- Lista de livros ---");
            for (int i = 0; i < livros.size(); i++) {
                System.out.println(i + " - " + livros.get(i));
            }
        }
    }

    public void remover(int indice) {
        if (indice >= 0 && indice < livros.size()) {
            Livro removed = livros.remove(indice);
            System.out.println("Livro removido com sucesso: " + removed);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void atualizar(int indice, Livro novoLivro) {
        if (indice < 0 || indice >= livros.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        // Evita criar duplicidade ao atualizar (compara com os outros índices)
        for (int i = 0; i < livros.size(); i++) {
            if (i == indice) continue;
            Livro l = livros.get(i);
            if (l.getTitulo().equalsIgnoreCase(novoLivro.getTitulo()) &&
                l.getAutor().equalsIgnoreCase(novoLivro.getAutor()) &&
                l.getAno() == novoLivro.getAno()) {
                System.out.println("Atualização cancelada: já existe outro livro com mesmo título, autor e ano.");
                return;
            }
        }

        livros.set(indice, novoLivro);
        System.out.println("Livro atualizado com sucesso!");
    }

    public int contarLivros() {
        return livros.size();
    }

    public void pesquisarPorAno(int anoInicio, int anoFim) {
        if (anoInicio > anoFim) {
            int tmp = anoInicio;
            anoInicio = anoFim;
            anoFim = tmp;
        }

        boolean encontrado = false;
        for (int i = 0; i < livros.size(); i++) {
            Livro l = livros.get(i);
            if (l.getAno() >= anoInicio && l.getAno() <= anoFim) {
                System.out.println(i + " - " + l);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum livro encontrado nesse intervalo.");
        }
    }

    public Livro maisAntigo() {
        if (livros.isEmpty()) return null;
        Livro antigo = livros.get(0);
        for (Livro l : livros) {
            if (l.getAno() < antigo.getAno()) {
                antigo = l;
            }
        }
        return antigo;
    }

    public Livro maisNovo() {
        if (livros.isEmpty()) return null;
        Livro novo = livros.get(0);
        for (Livro l : livros) {
            if (l.getAno() > novo.getAno()) {
                novo = l;
            }
        }
        return novo;
    }
}
