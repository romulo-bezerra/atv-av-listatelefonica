/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atvavlistatelefonica.controller;

import br.edu.ifpb.atvavlistatelefonica.abstraction.ContatoDao;
import br.edu.ifpb.atvavlistatelefonica.model.Contato;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author romulo
 */
@Named
@RequestScoped
public class ControladorContato {

    @Inject
    private ContatoDao contatoDao;
    private Contato contato;
    private String nomeBusca;
    private List<Contato> nomesBusca;

    public ControladorContato() {
        this.contato = new Contato();
        this.nomesBusca = new ArrayList<>();
    }

    public String cadastrarContato() {
        contatoDao.cadastrarContato(contato);
        contato = new Contato();
        return null;
    }

    public String atualizarContato(int idAtualizacao, Contato novoEstado) {
        contatoDao.atualizarContato(idAtualizacao, novoEstado);
        return null;
    }

    public String removerContato(Contato contato) {
        contatoDao.removerContato(contato);
        return null;
    }

    public String buscarContato() {
        nomesBusca = contatoDao.buscarContato(nomeBusca); 
        this.nomeBusca = null;
        return null;
    }

    public List<Contato> listarContatos() {
        return contatoDao.listarContatos();
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String getNomeBusca() {
        return nomeBusca;
    }

    public void setNomeBusca(String nomeBusca) {
        this.nomeBusca = nomeBusca;
    }

    public List<Contato> getNomesBusca() {
        return nomesBusca;
    }

    public void setNomesBusca(List<Contato> nomesBusca) {
        this.nomesBusca = nomesBusca;
    }
    
}
