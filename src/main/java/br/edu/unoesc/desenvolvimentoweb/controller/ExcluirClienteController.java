package br.edu.unoesc.desenvolvimentoweb.controller;

import br.edu.unoesc.desenvolvimentoweb.resources.ClienteResources;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/excluircliente")
public class ExcluirClienteController extends HttpServlet {
    ClienteResources clienteResources = new ClienteResources();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        clienteResources.removerClientePeloCodigo(Long.parseLong(req.getParameter("codigo")));
        resp.sendRedirect("/listarcliente");
    }
}
