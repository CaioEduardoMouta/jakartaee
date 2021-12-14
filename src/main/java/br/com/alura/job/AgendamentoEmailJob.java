package br.com.alura.job;

import br.com.alura.entidade.AgendamentoEmail;
import br.com.alura.servico.AgendamentoEmailServico;

import javax.ejb.*;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import java.util.List;

@Singleton
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AgendamentoEmailJob {



    @Inject
    private AgendamentoEmailServico agendamentoEmailServico;

    @Inject
    @JMSConnectionFactory("java:jboss/DefaultJMSConnectionFactory")
    private JMSContext context;

    @Resource(mappedName = "java:/jms/queue/EmailQueue")
    private Queue queue;

    @Schedule(hour = "*", minute = "*", second = "*/10")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void enviarEmail() {
       List<AgendamentoEmail> listarPorNaoAgendado
               = agendamentoEmailServico.listarPorNaoAgendado();
       listarPorNaoAgendado.forEach(emailNaoAgendado -> {
           context.createProducer().send(queue,emailNaoAgendado);
           agendamentoEmailServico.alerar(emailNaoAgendado);
       });
    }
}
