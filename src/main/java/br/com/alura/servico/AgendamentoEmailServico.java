package br.com.alura.servico;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class AgendamentoEmailServico {

    public List<String> listar() {
        return List.of("joao@alura.com.br");

    }

}