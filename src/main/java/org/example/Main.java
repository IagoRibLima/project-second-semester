package org.example;

import java.util.ArrayList;
import java.util.Scanner;

import static org.example.Anime.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Anime> listaAnime = new ArrayList<>();
        boolean exe = true;

        while (exe){
            System.out.println("1- Cadastrar Anime");
            System.out.println("2- Pesquisar Anime");
            System.out.println("3- Alterar Anime");
            System.out.println("4- Mostrar Lista de Anime");
            System.out.println("5- Sair");

            String op = sc.next();

            switch (op.toLowerCase()){
                case "1", "cadastrar":
                    Anime novoAnime = Anime.cadastrarAnime(sc);
                    listaAnime.add(novoAnime);
                    System.out.println();
                    break;

                case "2", "pesquisar":
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
                    break;

                case "3", "alterar":
                    System.out.print("Qual Anime deseja alterar: ");
                    sc.nextLine();
                    String busca2 = sc.nextLine();
                    System.out.println();

                    boolean ver2 = false;

                    for (Anime animes : listaAnime){
                        String[] palavras = animes.nome.split(" ");
                        for (String nome : palavras){
                            if (removerAcentos(nome).equalsIgnoreCase(busca2)) {
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

                                ver2 = true;
                                break;
                            }
                        }
                    }
                    if (!ver2){
                        System.out.println("Anime não encontrado");
                        System.out.println();
                    }
                    break;

                case "4", "mostrar":
                    for (Anime mostrar : listaAnime){
                        mostrar.mostrarAnime();
                        System.out.println();
                    }
                    break;

                case "5", "sair":
                    System.out.println("Saindo...");
                    exe = false;
                    break;

                default: System.out.println("Opção invalida");
            }
        }
        System.out.println("Programa Finalizado");
    }
}