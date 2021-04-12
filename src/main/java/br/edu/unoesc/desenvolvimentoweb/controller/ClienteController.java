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
@WebServlet("/cliente")
public class ClienteController extends HttpServlet {

    ClienteResources clienteResources = new ClienteResources();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Cliente cliente = new Cliente();
       if(req.getParameter("codigo") != null){
           cliente = clienteResources.buscarClientePeloCodigo(Long.valueOf(req.getParameter("codigo"))).orElse(new Cliente());
           }
       req.setAttribute("cliente", cliente);
        RequestDispatcher view = req.getRequestDispatcher("/view/cliente/cadastro.jsp");
        view.forward(req, resp);
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cliente cliente = new Cliente();
        cliente.setCodigo(converteCodigoParaLog(req.getParameter("codigo")));
        cliente.setNome(req.getParameter("nome"));
        cliente.setCpf(req.getParameter("cpf"));
        cliente.setEmail(req.getParameter("email"));
        cliente.setTelefone(req.getParameter("telefone"));
        clienteResources.inserirAlterarCliente(cliente);
        resp.sendRedirect("/listarcliente");



    }

    private Long converteCodigoParaLog(String codigo) {
        try{
            return Long.parseLong(codigo);
            }catch (NumberFormatException e){
            return null;
        }
    }
}
