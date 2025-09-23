public final class LivroDigital extends Livro {
    private double tamanhoEmMB;
    private String tipoDeArquivo;

    public LivroDigital(String nomeObra, String escritor, int anoEdicao, int totalPaginas, String tipoDeArquivo, double tamanhoEmMB) {
        super(nomeObra, escritor, anoEdicao, totalPaginas);
        this.tipoDeArquivo = tipoDeArquivo;
        this.tamanhoEmMB = tamanhoEmMB;
    }

    public LivroDigital() {
    }
    
    @Override
    public String getCategoriaObra() {
        return "Obra Digital";
    }

    @Override
    public String toString() {
        return "Nome da Obra = " + getNomeObra() +
           ", Escritor = " + getEscritor() +
           ", Ano da Edição = " + getAnoEdicao() +
           ", Qtd. Páginas = " + getTotalPaginas() +
           ", Formato = " + tipoDeArquivo +
           ", Tamanho (MB) = " + tamanhoEmMB;
    }

    public String getTipoDeArquivo() {
        return tipoDeArquivo;
    }

    public void setTipoDeArquivo(String tipoDeArquivo) {
        this.tipoDeArquivo = tipoDeArquivo;
    }

    public double getTamanhoEmMB() {
        return tamanhoEmMB;
    }

    public void setTamanhoEmMB(double tamanhoEmMB) {
        this.tamanhoEmMB = tamanhoEmMB;
    }
}