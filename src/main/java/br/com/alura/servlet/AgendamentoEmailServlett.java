package br.com.alura.servlet;

import br.com.alura.servico.AgendamentoEmailServico;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("emails")
public class AgendamentoEmailServlett extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private AgendamentoEmailServico servico;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        servico.listar().forEach(resultado -> pw.print("Os e-mails disponiveis são" + resultado));
    }
}
