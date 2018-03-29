/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atvavlistatelefonica.controller;

import br.edu.ifpb.atvavlistatelefonica.abstraction.ContatoDao;
import br.edu.ifpb.atvavlistatelefonica.model.Contato;
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

    public ControladorContato() {
        this.contato = new Contato();
    }
    
    public String cadastrarContato() {
        if (contato.getId() != 0) {
            contatoDao.atualizarContato(contato.getId(), contato);
        } else {
            contatoDao.cadastrarContato(contato);
        }
        contato = new Contato();
        return null;
    }

    public String buscar() {
        return null;
    }
    
    public String atualizarContato(Contato novoEstado) {
        this.contato = novoEstado;
        return null;
    }

    public String removerContato(Contato contato) {
        contatoDao.removerContato(contato);
        return null;
    }
    
    public List<Contato> listarContatos() {
        return contatoDao.listarContatos();
    }
    
    public List<Contato> listarContatosBusca() {
        return contatoDao.buscarContato(nomeBusca);
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

}
