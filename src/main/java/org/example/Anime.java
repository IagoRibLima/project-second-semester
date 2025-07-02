package org.example;

public class Anime {
    private String nome;
    private String comentario;
    private String nota;

    public Anime(String nome, String nota, String comentario) {
        this.nome = nome;
        this.comentario = comentario;
        this.nota = nota;
    }

    public String getNome(){
        return nome;
    }

    public  void setNome(String nome){
        this.nome = nome;
    }

    public String getNota(){
        return nota;
    }

    public  void setNota(String nota){
        this.nota = nota;
    }

    public String getComentario(){
        return comentario;
    }

    public  void setComentario(String comentario){
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Nota: " + nota + " | Comentário: " + comentario;
    }
}