package org.example;

import java.util.Scanner;
import java.text.Normalizer;

public class Anime {
    //Cadastro dos animes
    public String nome;
    public String comentario;
    public String nota;
    public String numero;

    //Construtor para acessar a classe
    public Anime(String nome, String comentario, String nota, String numero) {
        this.nome = nome;
        this.comentario = comentario;
        this.nota = nota;
        this.numero = numero;
    }

    //Métodos
    public static Anime cadastrarAnime(Scanner sc) {
        System.out.print("Nome: ");
        sc.nextLine(); //Limpa Buffer
        String nome = sc.nextLine();

        System.out.print("Comentário: ");
        String comentario = sc.nextLine();

        System.out.print("Nota: ");
        String nota = sc.next();

        System.out.print("Numero: ");
        String numero = sc.next();
        sc.nextLine(); //Limpa Buffer (até aqui tem que limpar essa merda)


        return new Anime(nome, comentario, nota, numero);
    }

    public void mostrarAnime() {
        System.out.println("Nome: " + nome);
        System.out.println("Comentário: " + comentario);
        System.out.println("Nota: " + nota);
        System.out.println("Número: " + numero);
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println();
    }

    public static String alterarNome(String nome){
        Scanner sc = new Scanner(System.in);
        System.out.print("Infome o nome: ");
        nome = sc.nextLine();
        return nome;
    }

    public static String alterarComentario(String comentario){
        Scanner sc = new Scanner(System.in);
        System.out.print("Infome o comentário: ");
        comentario = sc.nextLine();
        return comentario;
    }

    public static String alterarNota(String nota){
        Scanner sc = new Scanner(System.in);
        System.out.print("Infome a nota: ");
        nota = sc.next();
        return nota;
    }

    public static String removerAcentos(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }
}