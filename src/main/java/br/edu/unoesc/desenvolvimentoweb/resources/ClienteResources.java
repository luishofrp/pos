package br.edu.unoesc.desenvolvimentoweb.resources;

import br.edu.unoesc.desenvolvimentoweb.domain.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteResources {

    private static final List<Cliente> CLIENTES = new ArrayList<>();

       public void inserirAlterarCliente(final Cliente cliente){
        if (cliente.getCodigo() != null && buscarClientePeloCodigo(cliente.getCodigo()).isPresent()){
            CLIENTES.replaceAll(c -> c.getCodigo().equals(cliente.getCodigo()) ? cliente : c);
        }else {
            cliente.setCodigo(gerarCodigoCliente());
            CLIENTES.add(cliente);

        }
    }

    public List<Cliente> listarCliente(){
        return CLIENTES;
    }

    private Long gerarCodigoCliente() {
        return CLIENTES.stream().mapToLong(Cliente::getCodigo).max().orElse(0)+1;

    }

    public Optional<Cliente> buscarClientePeloCodigo(final Long codigo) {
        return CLIENTES.stream().filter(c -> c.getCodigo().equals(codigo)).findFirst();
    }

    public void removerClientePeloCodigo(Long codigo){
        CLIENTES.removeIf(p -> p.getCodigo().equals(codigo));
    }

}
