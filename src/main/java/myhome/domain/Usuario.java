package myhome.domain;

import java.util.UUID;

public class Usuario {
    private final String id = UUID.randomUUID().toString();
    private final String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
}
