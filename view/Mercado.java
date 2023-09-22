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
            Mercado.visualizarProduto();
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



}
