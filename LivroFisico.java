public final class LivroFisico extends Livro {
    private String medidasFisicas;
    private int quantidadeCopias;

    public LivroFisico(String nomeObra, String escritor, int anoEdicao, int totalPaginas, int quantidadeCopias, String medidasFisicas) {
        super(nomeObra, escritor, anoEdicao, totalPaginas);
        this.quantidadeCopias = quantidadeCopias;
        this.medidasFisicas = medidasFisicas;
    }
    
    public LivroFisico() {
    }

    @Override
    public String getCategoriaObra() {
        return "Obra Impressa";
    }

    @Override
    public String toString() {
        return "Nome da Obra = " + getNomeObra() +
           ", Escritor = " + getEscritor() +
           ", Ano da Edição = " + getAnoEdicao() +
           ", Qtd. Páginas = " + getTotalPaginas() +
           ", Qtd. de Cópias = " + quantidadeCopias +
           ", Medidas = " + medidasFisicas;
    }

    public int getQuantidadeCopias() {
        return quantidadeCopias;
    }

    public void setQuantidadeCopias(int quantidadeCopias) {
        this.quantidadeCopias = quantidadeCopias;
    }

    public String getMedidasFisicas() {
        return medidasFisicas;
    }

    public void setMedidasFisicas(String medidasFisicas) {
        this.medidasFisicas = medidasFisicas;
    }
}