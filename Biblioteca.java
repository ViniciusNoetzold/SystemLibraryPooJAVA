import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {
    private List<Livro> colecaoDeObras;
    private static final int ANO_MINIMO_PUBLICACAO = 1900;

    public Biblioteca() {
        this.colecaoDeObras = new ArrayList<>();
    }
    
    public Livro incluirItem(Livro obra) throws Exception {
        if (obra == null)
            throw new Exception("O item não pode ser nulo.");

        obra.setNomeObra(obra.getNomeObra().trim());
        if (obra.getNomeObra() == null || obra.getNomeObra().isEmpty())
            throw new Exception("O nome da obra não pode ser vazio.");

        obra.setEscritor(obra.getEscritor().trim());
        if (obra.getEscritor() == null || obra.getEscritor().isEmpty())
            throw new Exception("O nome do escritor não pode ser vazio.");

        int anoCorrente = LocalDate.now().getYear();
        if (obra.getAnoEdicao() < ANO_MINIMO_PUBLICACAO || obra.getAnoEdicao() > anoCorrente)
            throw new Exception("O ano da edição deve ser entre 1900 e o ano atual.");

        if (obra.getTotalPaginas() <= 0)
            throw new Exception("A quantidade de páginas deve ser positiva.");

        for (Livro item : colecaoDeObras) {
            if (item.getNomeObra().equalsIgnoreCase(obra.getNomeObra()) &&
                item.getEscritor().equalsIgnoreCase(obra.getEscritor()) &&
                item.getAnoEdicao() == obra.getAnoEdicao()) {
                throw new Exception("Obra já existente na coleção (mesmo nome, escritor e ano).");
            }
        }

        colecaoDeObras.add(obra);
        return obra;
    }

    public List<Livro> listarTodos() {
        return colecaoDeObras;
    }

    public List<Livro> buscar(String nomeObra) {
        return buscar(nomeObra, null);
    }

    public List<Livro> buscar(String nomeObra, String escritor) {
        List<Livro> obrasEncontradas = new ArrayList<>();
        for (Livro obra : colecaoDeObras) {
            if (obra.getNomeObra().toLowerCase().contains(nomeObra.toLowerCase())) {
                if (escritor == null || 
                    obra.getEscritor().toLowerCase().contains(escritor.toLowerCase())) {
                    obrasEncontradas.add(obra);
                }
            }
        }
        return obrasEncontradas;
    }

    public void removerItem(int indice) {
        if (indice < 0 || indice >= colecaoDeObras.size()) {
            throw new IndexOutOfBoundsException("Índice de remoção fora dos limites!");
        }
        colecaoDeObras.remove(indice);
    }

    public List<Livro> buscarPorIntervaloDeAnos(int anoInicial, int anoFinal) {
        List<Livro> encontrados = new ArrayList<>();
        for (Livro obra : colecaoDeObras) {
            if (obra.getAnoEdicao() >= anoInicial && obra.getAnoEdicao() <= anoFinal) {
                encontrados.add(obra);
            }
        }
        return encontrados;
    }
    
    public Livro obterObraMaisAntiga() {
        if (colecaoDeObras.isEmpty()) return null;
        return colecaoDeObras.stream()
                     .min(Comparator.comparingInt(Livro::getAnoEdicao))
                     .orElse(null);
    }

    public Livro obterObraMaisRecente() {
        if (colecaoDeObras.isEmpty()) return null;
        return colecaoDeObras.stream()
                     .max(Comparator.comparingInt(Livro::getAnoEdicao))
                     .orElse(null);
    }

    public int getQuantidadeTotal() {
        return colecaoDeObras.size();
    }
}