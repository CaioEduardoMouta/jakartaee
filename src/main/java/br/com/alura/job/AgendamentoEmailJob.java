package br.com.alura.job;

import br.com.alura.entidade.AgendamentoEmail;
import br.com.alura.servico.AgendamentoEmailServico;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class AgendamentoEmailJob {

    @Inject
    private AgendamentoEmailServico agendamentoEmailServico;

    @Schedule(hour = "*", minute = "*", second = "*/10")
    public void enviarEmail() {
       List<AgendamentoEmail> listarPorNaoAgendado
               = agendamentoEmailServico.listarPorNaoAgendado();
       listarPorNaoAgendado.forEach(emailNaoAgendado -> {
           agendamentoEmailServico.enviar(emailNaoAgendado);
           agendamentoEmailServico.alerar(emailNaoAgendado);
       });
    }
}
