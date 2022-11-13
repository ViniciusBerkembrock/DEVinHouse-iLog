package tech.devinhouse.exerciciosemanal_lojautil.service;

import org.springframework.stereotype.Service;
import tech.devinhouse.exerciciosemanal_lojautil.model.Cliente;
import tech.devinhouse.exerciciosemanal_lojautil.model.Produto;
import tech.devinhouse.exerciciosemanal_lojautil.repository.ClienteRepository;
import tech.devinhouse.exerciciosemanal_lojautil.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> buscar() {
        return clienteRepository.findAll();
    }

    public Cliente salvar(Cliente cliente) throws Exception {

        if (cliente.getCpfCnpj() == null || cliente.getCpfCnpj().isEmpty()) {

            throw new Exception("Entrada CPF/CNPJ não fornecida");
        }

        if (cliente.getId() != null) {
            if (clienteRepository.existsByIdNotAndCpfCnpj(cliente.getId(), cliente.getCpfCnpj())) {

                throw new Exception("CPF/CNPJ já cadastrado");
            } else {
                if (clienteRepository.existsByCpfCnpj(cliente.getCpfCnpj())) {

                    throw new Exception("CPF/CNPJ já cadastrado");
                }
            }
        }

        return clienteRepository.save(cliente);
    }

    public boolean apagar (Integer id) {

        try {
            clienteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
