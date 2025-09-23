📚 Gerenciador de Acervo Cultural
Este é um sistema simples de gerenciamento de biblioteca, desenvolvido em Java, que opera via console. Ele permite ao usuário realizar operações básicas de cadastro, consulta, atualização e remoção de livros em um acervo, diferenciando entre obras físicas e digitais.

✨ Funcionalidades
O sistema oferece um menu interativo com as seguintes opções:

Listar Obras: Exibe todos os livros cadastrados no acervo, com seus respectivos detalhes.

Adicionar Nova Obra: Permite o cadastro de um novo livro, solicitando se é uma obra física (com número de cópias e dimensões) ou digital (com formato de arquivo e tamanho em MB).

Buscar por Obra: Realiza uma busca por título e, opcionalmente, filtra os resultados pelo nome do autor.

Excluir uma Obra: Remove um livro do acervo a partir de uma lista numerada.

Modificar Dados: Permite atualizar as informações de um livro já cadastrado.

Consultar por Período: Filtra e exibe os livros publicados dentro de um intervalo de anos especificado.

Ver Obra Mais Antiga/Recente: Mostra qual é o livro com o ano de publicação mais antigo e o mais recente no acervo.

Contagem Total: Informa a quantidade total de livros cadastrados.

💻 Tecnologias Utilizadas
Java: O projeto é inteiramente construído em Java puro, sem a necessidade de bibliotecas ou frameworks externos.

JDK 11 (ou superior): Compilado e testado com versões modernas do Java Development Kit.

🚀 Como Executar o Projeto
Para compilar e executar o projeto, você precisará ter o JDK (Java Development Kit) instalado em sua máquina.

Clone ou Baixe o Repositório
Coloque todos os arquivos .java na mesma pasta. A estrutura deve ser a seguinte:

/seu-projeto
├── Biblioteca.java
├── Input.java
├── Livro.java
├── LivroDigital.java
├── LivroFisico.java
└── Main.java
Abra o Terminal ou Prompt de Comando
Navegue até o diretório onde você salvou os arquivos.

Bash

cd caminho/para/seu-projeto
Compile os Arquivos Java
Execute o seguinte comando para compilar todos os arquivos .java de uma vez:

Bash

javac *.java
Isso irá gerar os arquivos .class correspondentes.

Execute o Programa
Após a compilação bem-sucedida, execute a classe principal (Main):

Bash

java Main
Pronto! O menu do sistema aparecerá no console e você poderá começar a usar as funcionalidades.

📂 Estrutura do Código
Main.java: Classe principal que contém o método main. Responsável por exibir o menu, interagir com o usuário e chamar os métodos apropriados.

Biblioteca.java: O "coração" do sistema. Gerencia a lista de livros (o acervo) e contém toda a lógica para adicionar, remover, pesquisar e manipular os dados.

Input.java: Classe utilitária para capturar e validar as entradas do usuário (strings, inteiros, doubles), tratando possíveis erros.

Livro.java: Classe abstrata que serve como modelo base para todos os tipos de livros, definindo atributos e métodos comuns.

LivroFisico.java: Subclasse que herda de Livro e representa um livro físico, com atributos específicos como quantidade de cópias e dimensões.

LivroDigital.java: Subclasse que herda de Livro e representa um livro digital, com atributos como formato do arquivo e tamanho.