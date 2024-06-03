package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhodeCompra {
    List<Item> itens;

    public CarrinhodeCompra() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        itens.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> itensParaRemover = new ArrayList<>();
        if(!itens.isEmpty()){
            for(Item i: itens){
                if(i.getNome().equalsIgnoreCase(nome)){
                    itensParaRemover.add(i);
                }
            }
            itens.removeAll(itensParaRemover);
        }else{
            System.out.println("A lista está vazia!");
        }

    }

    public double calcularValorTotal(){
        double soma = 0d;
        if(!itens.isEmpty()){
            for(Item i: itens){
                soma += (i.getPreco()*i.getQuantidade());
            }
        }else{
            System.out.println("A lista está vazia!");
        }
        return soma;
    }

    public void exibirItens(){
        if(!itens.isEmpty()){
            System.out.println(itens);
        }else{
            System.out.println("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        // Criando uma instância do carrinho de compras
        CarrinhodeCompra carrinhoDeCompras = new CarrinhodeCompra();

        // Adicionando itens ao carrinho
        carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItem("Caderno", 35d, 1);
        carrinhoDeCompras.adicionarItem("Borracha", 2d, 2);

        // Exibindo os itens no carrinho
        carrinhoDeCompras.exibirItens();

        // Removendo um item do carrinho
        carrinhoDeCompras.removerItem("Lápis");

        // Exibindo os itens atualizados no carrinho
        carrinhoDeCompras.exibirItens();

        // Calculando e exibindo o valor total da compra
        System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal());
    }
}
