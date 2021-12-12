package br.com.alura.DAO;

import br.com.alura.entidade.AgendamentoEmail;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import java.util.List;


@Stateless
public class AgendamentoEmailDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<AgendamentoEmail> listar() {
        return entityManager.createQuery(
                        "SELECT ae FROM AgendamentoEmail ae",
                AgendamentoEmail.class).getResultList();
    }

    public void inserir(AgendamentoEmail agendamentoEmail) {
        entityManager.persist(agendamentoEmail);
    }
    
    public List<AgendamentoEmail> listarPorNaoAgendado() {
    	return entityManager
                .createQuery("SELECT ae FROM agendamentoEmail ae WHERE ae.agendado = false",
                        AgendamentoEmail.class).getResultList();
    }

    public void alterar(AgendamentoEmail agendamentoEmail) {
        entityManager.merge(agendamentoEmail);
    }


}
