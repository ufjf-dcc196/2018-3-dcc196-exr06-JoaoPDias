package com.example.exercicio6.model;

import java.io.Serializable;

public class Servidor implements Serializable {
    private String nome;
    private String siape;

    public Servidor(String nome, String siape) {
        this.nome = nome;
        this.siape = siape;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }
}
