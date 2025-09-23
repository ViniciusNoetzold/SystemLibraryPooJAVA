import java.util.List;
import java.util.Scanner;

public class Main {
    private static Biblioteca acervo = new Biblioteca();
    private static Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) {
        String opcoesMenu = """
                *** Gerenciador de Acervo Cultural ***
                Selecione a operação desejada:
                1 - Listar todas as obras
                2 - Adicionar nova obra
                3 - Buscar por obra específica
                4 - Excluir uma obra
                5 - Modificar dados de uma obra
                6 - Consultar por período de publicação
                7 - Ver obra mais antiga
                8 - Ver obra mais recente
                9 - Mostrar quantidade total de obras
                0 - Finalizar programa
                """;
        int escolha;
        do {
            System.out.println(opcoesMenu);
            escolha = Input.lerInt("Digite sua opção: ", leitor);
            switch (escolha) {
                case 1:
                    listarColecao();
                    pausar();
                    break;
                case 2:
                    registrarNovaObra();
                    pausar();
                    break;
                case 3:
                    consultarObra();
                    pausar();
                    break;
                case 4:
                    removerObra();
                    pausar();
                    break;
                case 5:
                    atualizarObra();
                    pausar();
                    break;
                case 6:
                    pesquisarPorPeriodo();
                    pausar();
                    break;
                case 7:
                    mostrarObraMaisAntiga();
                    pausar();
                    break;
                case 8:
                    mostrarObraMaisRecente();
                    pausar();
                    break;
                case 9:
                    exibirContagemObras();
                    pausar();
                    break;
                case 0:
                    System.out.println("Sistema finalizado.");
                    break;
                default:
                    System.out.println("Opção não reconhecida!");
                    break;
            }
        } while (escolha != 0);
    }
    
    private static void pausar(){
        System.out.println("Pressione Enter para prosseguir...");
        leitor.nextLine();
    }

    private static void registrarNovaObra() {
        String nomeObra = Input.lerString("Informe o nome da obra: ", leitor);
        String escritor = Input.lerString("Informe o escritor(a): ", leitor);
        int anoEdicao = Input.lerInt("Informe o ano da edição: ", leitor);
        int totalPaginas = Input.lerInt("Informe o total de páginas: ", leitor);
        int tipoObra = Input.lerInt("Tipo: (1) Impressa ou (2) Digital: ", leitor);
        
        Livro novaObra;
        if (tipoObra == 1){
            int quantidadeCopias = Input.lerInt("Informe a quantidade de cópias: ", leitor);
            String medidas = Input.lerString("Informe as medidas (ex: 15x23cm): ", leitor);
            novaObra = new LivroFisico(nomeObra, escritor, anoEdicao, totalPaginas, quantidadeCopias, medidas);
        } else {
            String formato = Input.lerString("Informe o formato do arquivo (ex: PDF, EPUB): ", leitor);
            double tamanho = Input.lerDouble("Informe o tamanho do arquivo (em MB): ", leitor);
            novaObra = new LivroDigital(nomeObra, escritor, anoEdicao, totalPaginas, formato, tamanho);
        }
        
        try {
            acervo.incluirItem(novaObra);
            System.out.println("Obra registrada com sucesso!");
        } catch (Exception e) {
            System.out.println("Falha ao registrar: " + e.getMessage());
        }
    }

    private static void listarColecao() {
        var colecao = acervo.listarTodos();
        exibirResultados(colecao);
    }

    private static void consultarObra() {
        String nomeObra = Input.lerString("Digite o nome da obra para buscar: ", leitor);
        String buscarPorEscritor = Input.lerString(
            "Filtrar por escritor? (S/N) ", leitor);
            
        List<Livro> obras;
        if (buscarPorEscritor.equalsIgnoreCase("s")){
            String escritor = Input.lerString("Digite o nome do escritor: ", leitor);
            obras = acervo.buscar(nomeObra, escritor);
        } else {
            obras = acervo.buscar(nomeObra);
        }
        exibirResultados(obras);
    }

    private static void exibirResultados(List<Livro> colecao) {
        if (colecao == null || colecao.isEmpty()) {
            System.out.println("Nenhuma obra foi encontrada.");
        } else {
            System.out.println("--- Obras Encontradas ---");
            for (int i = 0; i < colecao.size(); i++) {
                Livro obra = colecao.get(i);
                System.out.println("Item " + (i + 1) + " (" + obra.getCategoriaObra() + "): " + obra);
            }
            System.out.println("-------------------------");
        }
    }

     private static void removerObra() {
        var colecao = acervo.listarTodos(); 
        if (colecao.isEmpty()) {
            System.out.println("O acervo está vazio. Nenhuma obra para remover.");
            return;
        }

        exibirResultados(colecao);

        int indice = Input.lerInt("Digite o número do item que deseja excluir: ", leitor);
        if (indice < 1 || indice > colecao.size()) {
            System.out.println("Seleção inválida!");
            return;
        }

        try {
            acervo.removerItem(indice - 1); 
            System.out.println("Obra excluída com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }

    private static void atualizarObra() {
        String nomeObra = Input.lerString("Digite o nome da obra que deseja modificar: ", leitor);
        List<Livro> encontradas = acervo.buscar(nomeObra);

        if (encontradas.isEmpty()) {
            System.out.println("Nenhuma obra encontrada com este nome.");
            return;
        }

        exibirResultados(encontradas);

        int escolha = Input.lerInt("Digite o número do item para atualizar: ", leitor);
        if (escolha < 1 || escolha > encontradas.size()) {
            System.out.println("Seleção inválida!");
            return;
        }

        Livro obraParaAtualizar = encontradas.get(escolha - 1);
        
        System.out.println("Deixe em branco para manter a informação atual.");
        String novoNome = Input.lerString("Novo nome: ", leitor);
        if (!novoNome.isEmpty()) obraParaAtualizar.setNomeObra(novoNome);

        String novoEscritor = Input.lerString("Novo escritor: ", leitor);
        if (!novoEscritor.isEmpty()) obraParaAtualizar.setEscritor(novoEscritor);

        String novoAno = Input.lerString("Novo ano da edição: ", leitor);
        if (!novoAno.isEmpty()) obraParaAtualizar.setAnoEdicao(Integer.parseInt(novoAno));

        String novasPgs = Input.lerString("Novo total de páginas: ", leitor);
        if (!novasPgs.isEmpty()) obraParaAtualizar.setTotalPaginas(Integer.parseInt(novasPgs));

        if (obraParaAtualizar instanceof LivroFisico impressa) {
            String novasCopias = Input.lerString("Nova quantidade de cópias: ", leitor);
            if (!novasCopias.isEmpty()) impressa.setQuantidadeCopias(Integer.parseInt(novasCopias));

            String novasMedidas = Input.lerString("Novas medidas (ex: 15x23cm): ", leitor);
            if (!novasMedidas.isEmpty()) impressa.setMedidasFisicas(novasMedidas);

        } else if (obraParaAtualizar instanceof LivroDigital digital) {
            String novoFormato = Input.lerString("Novo formato do arquivo: ", leitor);
            if (!novoFormato.isEmpty()) digital.setTipoDeArquivo(novoFormato);

            String novoTamanho = Input.lerString("Novo tamanho do arquivo (MB): ", leitor);
            if (!novoTamanho.isEmpty()) digital.setTamanhoEmMB(Double.parseDouble(novoTamanho));
        }

        System.out.println("Obra atualizada com sucesso!");
        System.out.println("Resultado: " + obraParaAtualizar);
    }
    
    private static void exibirContagemObras() {
        int total = acervo.getQuantidadeTotal();
        System.out.println("O acervo possui um total de: " + total + " obras.");
    }

    private static void pesquisarPorPeriodo() {
        int inicio = Input.lerInt("Informe o ano inicial da busca: ", leitor);
        int fim = Input.lerInt("Informe o ano final da busca: ", leitor);

        List<Livro> encontradas = acervo.buscarPorIntervaloDeAnos(inicio, fim);
        exibirResultados(encontradas);
    }
    
    private static void mostrarObraMaisAntiga() {
        Livro antiga = acervo.obterObraMaisAntiga();
        if (antiga == null) {
            System.out.println("O acervo está vazio.");
        } else {
            System.out.println("Obra mais antiga do acervo: " + antiga);
        }
    }

    private static void mostrarObraMaisRecente() {
        Livro recente = acervo.obterObraMaisRecente();
        if (recente == null) {
            System.out.println("O acervo está vazio.");
        } else {
            System.out.println("Obra mais recente do acervo: " + recente);
        }
    }
}