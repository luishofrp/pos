package br.edu.unoesc.desenvolvimentoweb.controller;

import br.edu.unoesc.desenvolvimentoweb.domain.Cliente;
import br.edu.unoesc.desenvolvimentoweb.resources.ClienteResources;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listarcliente")
public class ListarClienteController extends HttpServlet {
    ClienteResources clienteResources = new ClienteResources();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cliente> clientes = clienteResources.listarCliente();
        req.setAttribute("clientes", clientes);
        RequestDispatcher view = req.getRequestDispatcher("/view/cliente/lista.jsp");
        view.forward(req, resp);

    }
}
