package org.example;

import java.util.ArrayList;
import java.util.Scanner;

import static org.example.Anime.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Anime> listaAnime = new ArrayList<>();

        while (true){
            System.out.println("1- Cadastrar Anime");
            System.out.println("2- Pesquisar Anime");
            System.out.println("3- Alterar Anime");
            System.out.println("4- Mostrar Lista de Anime");
            System.out.println("5- Sair");

            String op = sc.next();

            if (op.equalsIgnoreCase("1") || op.equalsIgnoreCase("cadastrar")){

                Anime novoAnime = Anime.cadastrarAnime(sc);
                listaAnime.add(novoAnime);
                System.out.println();

            }else if (op.equalsIgnoreCase("2") || op.equalsIgnoreCase("pesquisar")){
                System.out.print("Qual Anime deseja buscar: ");
                sc.nextLine();
                String busca = sc.nextLine();
                System.out.println();

                boolean ver = false;

                for (Anime animes : listaAnime){
                    String[] palavras = animes.nome.split(" ");
                    for (String nome : palavras){
                        if (removerAcentos(nome).equalsIgnoreCase(busca)) {
                            animes.mostrarAnime();
                            ver = true;
                            break;
                        }
                    }
                }
                if (!ver){
                    System.out.println("Anime não encontrado");
                    System.out.println();
                }

            }else if (op.equalsIgnoreCase("3") || op.equalsIgnoreCase("alterar")){
                System.out.print("Qual Anime deseja alterar: ");
                sc.nextLine();
                String busca = sc.nextLine();
                System.out.println();

                boolean ver = false;

                for (Anime animes : listaAnime){
                    String[] palavras = animes.nome.split(" ");
                    for (String nome : palavras){
                        if (removerAcentos(nome).equalsIgnoreCase(busca)) {
                            System.out.print("Escolha a opção que deseja alterar: ");
                            System.out.println();

                            System.out.println("1- Nome");
                            System.out.println("2- Comentário");
                            System.out.println("3- Nota");

                            String opc = sc.next();

                            if (opc.equalsIgnoreCase("1") || removerAcentos(opc).equalsIgnoreCase("nome")){
                                animes.nome = alterarNome(animes.nome);
                                System.out.println();
                                System.out.println("Nome alterado com sucesso");
                            } else if (opc.equalsIgnoreCase("2") || removerAcentos(opc).equalsIgnoreCase("comentario")) {
                                animes.comentario = alterarComentario(animes.comentario);
                                System.out.println();
                                System.out.println("Comentário alterado com sucesso");
                            } else if (opc.equalsIgnoreCase("3") || removerAcentos(opc).equalsIgnoreCase("nota")) {
                                animes.nota = alterarNota(animes.nota);
                                System.out.println();
                                System.out.println("Nota alterada com sucesso");
                            }else System.out.println("Opção inválida");

                            System.out.println();
                            animes.mostrarAnime();

                            ver = true;
                            break;
                        }
                    }
                }
                if (!ver){
                    System.out.println("Anime não encontrado");
                    System.out.println();
                }


            }else if (op.equalsIgnoreCase("4") || op.equalsIgnoreCase("mostrar")){
                for (Anime mostrar : listaAnime){
                    mostrar.mostrarAnime();
                    System.out.println();
                }
            }else if (op.equalsIgnoreCase("5") || op.equalsIgnoreCase("sair")){
                System.out.println("Saindo...");
                break;
            }else System.out.println("Opção invalida");
        }
    }
}