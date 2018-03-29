/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atvavlistatelefonica.abstraction;

import br.edu.ifpb.atvavlistatelefonica.model.Contato;
import java.util.List;

/**
 *
 * @author romulo
 */
public interface ContatoDao {

    public void cadastrarContato(Contato contato);

    public void atualizarContato(int idAtuliazacao, Contato novoEstado);

    public void removerContato(Contato contato);

    public List<Contato> buscarContato(String nome);

    public List<Contato> listarContatos();

}
