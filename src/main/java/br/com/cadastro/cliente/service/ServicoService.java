package br.com.cadastro.cliente.service;

import br.com.cadastro.cliente.domain.Cliente;
import br.com.cadastro.cliente.domain.Servico;
import br.com.cadastro.cliente.domain.StatusResponse;
import br.com.cadastro.cliente.repository.ClienteRepository;
import br.com.cadastro.cliente.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    ServicoRepository servicoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public List<Servico> getServicos(){
        return servicoRepository.findAll();
    }

    public StatusResponse insertServico(Servico novoServico){

        Cliente cliente = clienteRepository.getById(novoServico.getCliente().getId());
        List<Servico> servicos = servicoRepository.findAll();

        for (Servico servico: servicos){
            if (servico.equals(novoServico)){
                return new StatusResponse("Serviço já existe", "erro");
            }
        }

        novoServico.setCliente(cliente);

        servicoRepository.save(novoServico);
        return new StatusResponse("Serviço cadastrado com sucesso", "sucesso");

    }

    public StatusResponse dropServico(long idServico){
        List<Servico> servicos = servicoRepository.findAll();

        if (servicoRepository.findById(idServico) == null){
            return new StatusResponse("Serviço não existe", "erro");
        }

        servicoRepository.deleteById(idServico);
        return new StatusResponse("Serviço deletado com sucesso", "sucesso");
    }

    public StatusResponse updateServico(Servico novoServico) {
        Servico servico = servicoRepository.findById(novoServico.getId()).get();

        if (novoServico.getTitulo() == "" || novoServico.getDescricao() == "" || novoServico.getValor() == null){
            return new StatusResponse("Dados invalidos", "erro");
        }

        servico.setTitulo(novoServico.getTitulo());
        servico.setDescricao(novoServico.getDescricao());
        servico.setValor(novoServico.getValor());

        servicoRepository.save(servico);
        return new StatusResponse("Serviço alterado com sucesso", "sucesso");
    }
}
