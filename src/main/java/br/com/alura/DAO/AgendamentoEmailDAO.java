package br.com.alura.DAO;

import br.com.alura.entidade.AgendamentoEmail;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
}
