package br.com.alura.servico;

import br.com.alura.DAO.AgendamentoEmailDAO;
import br.com.alura.entidade.AgendamentoEmail;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class AgendamentoEmailServico {

    private static final Logger LOGGER =
            Logger.getLogger(AgendamentoEmailServico.class.getName());


    @Inject
    private  AgendamentoEmailDAO dao;

    public List<AgendamentoEmail> listar() {
        return dao.listar();

    }

    public void inserir(AgendamentoEmail agendamentoEmail) {
        agendamentoEmail.setAgendado(false);
        dao.inserir(agendamentoEmail);
    }

    public List<AgendamentoEmail> listarPorNaoAgendado() {
        return dao.listarPorNaoAgendado();
    }

    public void alerar(AgendamentoEmail agendamentoEmail) {
        agendamentoEmail.setAgendado(true);
        dao.alterar(agendamentoEmail);
    }

    public void enviar(AgendamentoEmail agendamentoEmail) {
            try {
                Thread.sleep(5000);
                LOGGER.info("O email do usuario" + agendamentoEmail.getEmail()
                        + "foi enviado");
            } catch (Exception e) {
                LOGGER.warning(e.getMessage());
            }

    }

}