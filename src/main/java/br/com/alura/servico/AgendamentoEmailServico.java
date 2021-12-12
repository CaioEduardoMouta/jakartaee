package br.com.alura.servico;

import br.com.alura.DAO.AgendamentoEmailDAO;
import br.com.alura.entidade.AgendamentoEmail;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class AgendamentoEmailServico {

    @Inject
    private  AgendamentoEmailDAO dao;

    public List<AgendamentoEmail> listar() {
        return dao.listar();

    }

    public void inserir(AgendamentoEmail agendamentoEmail) {
        agendamentoEmail.setAgendado(false);
        dao.inserir(agendamentoEmail);
    }

}