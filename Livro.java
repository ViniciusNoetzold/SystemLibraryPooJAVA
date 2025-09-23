import java.time.LocalDate;

public abstract class Livro {
    private String nomeObra;
    private String escritor;
    private int totalPaginas;
    private int anoEdicao;

    public Livro(String nomeObra, String escritor, int anoEdicao, int totalPaginas) {
        this.nomeObra = nomeObra;
        this.escritor = escritor;
        this.anoEdicao = anoEdicao;
        this.totalPaginas = totalPaginas;
    }

    public Livro(){

    }
    
    public final int calcularTempoDesdePublicacao(){
        int anoCorrente = LocalDate.now().getYear();
        return anoCorrente - this.anoEdicao;
    }

    public abstract String getCategoriaObra();

    @Override
    public String toString() {
        return "Obra=" + nomeObra 
                + ", Escritor=" + escritor 
                + ", Ano da Edição=" + anoEdicao 
                + ", Total de Páginas=" + totalPaginas;
    }

    public String getNomeObra() {
        return nomeObra;
    }

    public void setNomeObra(String nomeObra) {
        this.nomeObra = nomeObra;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public int getAnoEdicao() {
        return anoEdicao;
    }

    public void setAnoEdicao(int anoEdicao) {
        this.anoEdicao = anoEdicao;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }
}