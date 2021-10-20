package br.com.cadastro.cliente.service;

import br.com.cadastro.cliente.domain.Cliente;
import br.com.cadastro.cliente.domain.Servico;
import br.com.cadastro.cliente.domain.StatusResponse;
import br.com.cadastro.cliente.repository.ClienteRepository;
import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> pesquisar(String nome) {
        return clienteRepository.findServicoByTitulo(nome);
    }

    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }

    public StatusResponse insertCliente(Cliente novoCliente) {
        List<Cliente> clientes = clienteRepository.findAll();

        for (Cliente cliente: clientes){
            if (cliente.equals(novoCliente)){
                return new StatusResponse("Cliente já existe", "erro");
            }
        }

        clienteRepository.save(novoCliente);
        return new StatusResponse("Cliente cadastrado com sucesso", "sucesso");

    }

    public StatusResponse dropCliente(long idCliente) {

        if (clienteRepository.findById(idCliente) == null){
            return new StatusResponse("Cliente não existe", "erro");
        }

        clienteRepository.deleteById(idCliente);
        return new StatusResponse("Cliente deletado com sucesso", "sucesso");
    }

    public StatusResponse updateCliente(Cliente novoCliente) {

        Cliente cliente = clienteRepository.findById(novoCliente.getId()).get();

        if (novoCliente.getNome() == "" || novoCliente.getEmail() == "" || novoCliente.getSobrenome() == ""){
            return new StatusResponse("Dados invalidos", "erro");
        }

        cliente.setNome(novoCliente.getNome());
        cliente.setSobrenome(novoCliente.getSobrenome());
        cliente.setEmail(novoCliente.getEmail());

        clienteRepository.save(cliente);
        return new StatusResponse("Cliente alterado com sucesso", "sucesso");
    }
}
