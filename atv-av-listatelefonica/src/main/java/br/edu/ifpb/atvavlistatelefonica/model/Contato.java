/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atvavlistatelefonica.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author romulo
 */
@Entity
public class Contato implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String numero;

    public Contato() {

    }

    public Contato(int id, String nome, String numero) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Contato{" + "id=" + id + ", nome=" + nome
                + ", numero=" + numero + '}';
    }

}
