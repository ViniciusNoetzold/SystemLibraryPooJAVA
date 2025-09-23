public final class LivroFisico extends Livro {
    private int numeroExemplares;
    private String dimensoes;

    public LivroFisico() {
    }

    
    public LivroFisico(String titulo, String autor, int anoPublicacao, int numeroPaginas, int numeroExemplares,
            String dimensoes) {
        super(titulo, autor, anoPublicacao, numeroPaginas);
        this.numeroExemplares = numeroExemplares;
        this.dimensoes = dimensoes;
    }


    public int getNumeroExemplares() {
        return numeroExemplares;
    }
    public void setNumeroExemplares(int numeroExemplares) {
        this.numeroExemplares = numeroExemplares;
    }
    public String getDimensoes() {
        return dimensoes;
    }
    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }
    
           @Override
        public String toString() {
        return "Título = " + getTitulo() +
           ", Autor = " + getAutor() +
           ", Ano de Publicação = " + getAnoPublicacao() +
           ", Número de Páginas = " + getNumeroPaginas() +
           ", Número de Exemplares = " + numeroExemplares +
           ", Dimensões = " + dimensoes;
}

    @Override
    public String getTipoLivro() {
        return "Livro Físico";
    }

}
