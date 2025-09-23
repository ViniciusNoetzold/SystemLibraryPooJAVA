public final class LivroDigital extends Livro {
    private String formatoArquivo;
    private double tamanhoArquivo;

    public LivroDigital(String titulo, String autor, int anoPublicacao, int numeroPaginas, String formatoArquivo, double tamanhoArquivo) {
         
        super(titulo, autor, anoPublicacao, numeroPaginas);
        this.formatoArquivo = formatoArquivo;
        this.tamanhoArquivo = tamanhoArquivo;
    }

    public LivroDigital() {
    }

    public String getFormatoArquivo() {
        return formatoArquivo;
    }

    public void setFormatoArquivo(String formatoArquivo) {
        this.formatoArquivo = formatoArquivo;
    }

    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(double tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }

    @Override
    public String toString() {
    return "Título = " + getTitulo() +
           ", Autor = " + getAutor() +
           ", Ano de Publicação = " + getAnoPublicacao() +
           ", Número de Páginas = " + getNumeroPaginas() +
           ", Formato do Arquivo = " + formatoArquivo +
           ", Tamanho do Arquivo = " + tamanhoArquivo + " MB";
}

    @Override
    public String getTipoLivro() {
        return "Livro Digital";
    }

}
