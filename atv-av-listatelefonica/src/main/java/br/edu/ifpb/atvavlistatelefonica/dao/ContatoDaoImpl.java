/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atvavlistatelefonica.dao;

import br.edu.ifpb.atvavlistatelefonica.abstraction.ContatoDao;
import br.edu.ifpb.atvavlistatelefonica.model.Contato;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author romulo
 */
@Stateless
@Local(ContatoDao.class)
public class ContatoDaoImpl implements ContatoDao {

    @PersistenceContext(unitName = "listatelefonica")
    private EntityManager entityManager;

    @Override
    public void cadastrarContato(Contato contato) {
        entityManager.persist(contato);
    }

    @Override
    public void atualizarContato(int idAtuliazacao, Contato novoEstado) {
        Contato contato = entityManager.find(Contato.class, idAtuliazacao);
        novoEstado.setId(contato.getId());
        entityManager.merge(novoEstado);
    }

    @Override
    public void removerContato(Contato contato) {
        Contato contatoRemove = entityManager.find(Contato.class, contato.getId());
        entityManager.remove(contatoRemove);
    }
    
    @Override
    public List<Contato> listarContatos() {
        String querySql = "SELECT c FROM Contato c ORDER BY c.nome ASC";
//        String querySql = "SELECT c.id, c.nome, c.numero \n"
//                + "FROM Contato c \n"
//                + "GROUP BY SUBSTRing(c.nome, 1, 1), c.nome, c.numero, c.id \n"
//                + "ORDER BY c.nome";
        TypedQuery<Contato> query = entityManager
                .createQuery(querySql, Contato.class);
        return query.getResultList();
    }

    @Override
    public List<Contato> buscarContato(String nome) {
        String querySql = "SELECT c FROM Contato c "
                + "WHERE c.nome= :nome ORDER BY c.nome ASC";
        TypedQuery<Contato> query = entityManager
                .createQuery(querySql, Contato.class);
        query.setParameter("nome", nome);
        return query.getResultList();
    }

}
