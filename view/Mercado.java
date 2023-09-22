package view;

import java.util.Scanner;

import helper.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;


import model.Produto;


public class Mercado {

    private static Scanner teclado = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static Map<Produto, Integer> carrinho;

    public static void main(String[] args) {
        produtos = new ArrayList<Produto>();
        carrinho = new HashMap<Produto, Integer>();
        Mercado.menu();
 }

    private static void menu() {
        System.out.println("========================");
        System.out.println("======Bem-vindo(a)======");
        System.out.println("=====ByteCodes Shop=====");
        System.out.println("========================");

        System.out.println("Selecione uma opção abaixo: ");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Listar produtos");
        System.out.println("3 - Comprar produto");
        System.out.println("4 - Visualizar carrinho");
        System.out.println("5 - Sair do sistema");
        
        int opcao = 0;

        try{
            opcao = Integer.parseInt(Mercado.teclado.nextLine());
        }catch(InputMismatchException e){
            Mercado.menu();
        }catch(NumberFormatException f){
            Mercado.menu();
        }

        switch(opcao){
            case 1:
            Mercado.cadastrarProduto();
            break;
            case 2:
            Mercado.listarProduto();
            break;
            case 3:
            Mercado.comprarProduto();
            break;
            case 4:
            Mercado.visualizarCarrinho();
            break;
            case 5:
            System.out.println("Volte sempre!");
            Utils.pausar(2);
            System.exit(0);

            default:
            System.out.println("Opção inválida.");
            Utils.pausar(2);
            Mercado.menu();
            break;
        }

    }

    private static void cadastrarProduto() {
        System.out.println("Cadastrando de produto...");
        System.out.println("===========================");

        System.out.println("Informe o nome do produto: ");
        String nome = Mercado.teclado.nextLine();

        System.out.println("Informe o preço do produto: ");
        Double preco = Mercado.teclado.nextDouble();

        Produto produto = new Produto(nome, preco);

        Mercado.produtos.add(produto);

        System.out.println("O produto " + produto.getNome() + " foi cadastrado com sucesso.");
        Utils.pausar(2);
        Mercado.menu();
    }

    private static void listarProduto(){
       if(Mercado.produtos.size() > 0) {
            System.out.println("Listagem de produtos");
            System.out.println();

            for(Produto p : Mercado.produtos){
                System.out.println(p);
                System.out.println();
            }

       }else {
        System.out.println("Ainda não existem produtos cadastrados.");
       }

        Utils.pausar(2);
        Mercado.menu();
       
    }
    private static void comprarProduto(){
        if(Mercado.produtos.size() > 0) {}
        System.out.println("Informe o código do produto que deseja comprar: ");
        System.out.println();

        System.out.println("============== Produtos Disponíveis ==============");
        for(Produto p : Mercado.produtos) {
            System.out.println(p);
            System.out.println("-------------------------");
        }
        int codigo = Integer.parseInt(Mercado.teclado.nextLine());
        boolean tem = false;

        for (Produto p : Mercado.produtos) {
        if (p.getCodigo() == codigo) {
        int quant = Mercado.carrinho.getOrDefault(p, 0);
        // Se o produto não estiver no carrinho, a quantidade será 0
        // Caso contrário, a quantidade atual será obtida
        Mercado.carrinho.put(p, quant + 1);

        System.out.println("O produto " + p.getNome() + " foi adicionado ao carrinho.");
        tem = true;
    }
}

if (tem) {
    System.out.println("Deseja adicionar outros produtos ao carrinho?");
    System.out.println("Informe 1 para sim ou 0 para não: ");
    int op = Integer.parseInt(Mercado.teclado.nextLine());

    if (op == 1) {
        comprarProduto();
    } else {
        System.out.println("Por favor, aguarde enquanto fechamos seu pedido...");
        Utils.pausar(2);
        fecharPedido();
    }
} else {
    System.out.println("Não foi encontrado o produto com o código " + codigo);
    Utils.pausar(2);
    menu();
}

        
    }
     private static void visualizarCarrinho(){
        if(Mercado.carrinho.size() > 0) {
            System.out.println("Produtos no carrinho: ");

            for(Produto p : Mercado.carrinho.keySet()){
                System.out.println("Produto: " + p + "\nQuantidade: " + Mercado.carrinho.get(p));
            }

        }else {
        System.out.println("Ainda não existem produtos no carrinho.");
       }

        Utils.pausar(2);
        Mercado.menu();
        
    } 

    private static void fecharPedido() {
        Double valorTotal = 0.0;
        System.out.println("Produtos do Carrinho");
        System.out.println("--------------------------");
    
        for (Produto p : Mercado.carrinho.keySet()) {
            int quant = Mercado.carrinho.get(p);
            valorTotal += p.getPreco() * quant;
            System.out.println(p);
            System.out.println("Quantidade: " + quant);
            System.out.println("--------------------------");
        }
    
        String valorTotalFormatted = String.format("%.2f", valorTotal); // Formata o valor total com 2 casas decimais
    
        System.out.println("Sua fatura é R$" + valorTotalFormatted); // Altere a moeda conforme necessário
        Mercado.carrinho.clear();
        System.out.println("Obrigado pela preferência. ");
        Utils.pausar(5);
        Mercado.menu();
    }
}
