package org.example.monitoramento;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Usuario {

    private final SimpleStringProperty nome;
    private final SimpleStringProperty email;
    private final SimpleDoubleProperty imc;

    public Usuario(String nome, String email, double imc) {
        this.nome = new SimpleStringProperty(nome);
        this.email = new SimpleStringProperty(email);
        this.imc = new SimpleDoubleProperty(imc);
    }

    public String getNome() {
        return nome.get();
    }

    public String getEmail() {
        return email.get();
    }

    public double getImc() {
        return imc.get();
    }
}