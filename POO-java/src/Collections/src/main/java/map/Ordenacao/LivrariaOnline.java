package main.java.map.Ordenacao;

import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> livros;

    public LivrariaOnline() {
        this.livros = new HashMap<>();
    }

    public void adicionarLivro(String link, Livro livro) {
        livros.put(link, livro);
    }

    public void removerLivro(String titulo){
        List<String> chavesPararemover = new ArrayList<>();
        if (!livros.isEmpty()){
            for (Map.Entry<String, Livro> entry: livros.entrySet()){
                if(entry.getValue().getTitulo().equalsIgnoreCase(titulo)){
                    chavesPararemover.add(entry.getKey());
                }
            }
            for(String chave: chavesPararemover){
                livros.remove(chave);
            }
        }else{
            System.out.println("O Map está vazio.");
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco(){
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livros.entrySet());
        Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());
        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

        for(Map.Entry<String, Livro> entry: livrosParaOrdenarPorPreco){
            livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
        }
        return livrosOrdenadosPorPreco;
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livros.entrySet());

        Collections.sort(livrosParaOrdenarPorAutor, new ComparatorPorAutor());

        Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorAutor) {
            livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorAutor;
    }

    //public Map<String, Livro> pesquisarLivrosPorAutor(String autor){
    public List<Livro> pesquisarLivrosPorAutor(String autor){
        /*Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();
        for(Map.Entry<String, Livro> entry: livros.entrySet()){
            Livro livro = entry.getValue();
            if(livro.getAutor().equalsIgnoreCase(autor)){
                livrosPorAutor.put(entry.getKey(), livro);
            }
        }*/

        List<Livro> livrosPorAutor = new ArrayList<>();
        for(Map.Entry<String, Livro> entry: livros.entrySet()){
            Livro livro = entry.getValue();
            if(livro.getAutor().equalsIgnoreCase(autor)){
                livrosPorAutor.add(livro);
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> obterLivroMaisCaro(){
        List<Livro> livrosMaisCaros = new ArrayList<>();
        double maiorValor = Double.MIN_VALUE;

        if(!livros.isEmpty()){
            for(Livro livro: livros.values()){
                if(livro.getPreco() > maiorValor ){
                    maiorValor = livro.getPreco();
                }
            }
        }else{
            throw new NoSuchElementException("A livraria está vazia!");
        }

        for(Map.Entry<String, Livro> entry: livros.entrySet()){
            if(entry.getValue().getPreco() == maiorValor){
                Livro livro = livros.get(entry.getKey());
                livrosMaisCaros.add(livro);
            }
        }
        return livrosMaisCaros;
    }
    public List<Livro> exibirLivroMaisBarato(){
        List<Livro> livrosMaisBarato = new ArrayList<>();
        double menorValor = Double.MAX_VALUE;

        if(!livros.isEmpty()){
            for(Livro livro: livros.values()){
                if(livro.getPreco() < menorValor){
                    menorValor = livro.getPreco();
                }
            }
        }else{
            throw new NoSuchElementException("A livraria está vazia!");
        }

        for(Map.Entry<String, Livro> entry: livros.entrySet()){
            if(entry.getValue().getPreco() == menorValor){
                Livro livro = livros.get(entry.getKey());
                livrosMaisBarato.add(livro);
            }
        }
        return livrosMaisBarato;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();
        // Adiciona os livros à livraria online
        livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", new Livro("1984", "George Orwell", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", new Livro("A Revolução dos Bichos", "George Orwell", 7.05d));
        livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", new Livro("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
        livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", new Livro("Malorie", "Josh Malerman", 5d));
        livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", new Livro("E Não Sobrou Nenhum", "Agatha Christie", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", new Livro("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));

        // Exibe todos os livros ordenados por preço
        System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

        //Exibe todos os livros ordenados por autor
        System.out.println();
        System.out.println("Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorAutor());

        // Pesquisa livros por autor
        String autorPesquisa = "Josh Malerman";
        System.out.println();
        System.out.println("livros por autor: " + livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa));

        // Obtém e exibe o livro mais caro
        System.out.println();
        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

        // Obtém e exibe o livro mais barato
        System.out.println();
        System.out.println("Livro mais barato: " + livrariaOnline.exibirLivroMaisBarato());

        // Remover um livro pelo título
        System.out.println();
        livrariaOnline.removerLivro("1984");
        System.out.println(livrariaOnline.livros);

    }

}
