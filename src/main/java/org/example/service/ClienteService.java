package org.example.service;

import org.example.model.Cliente;
import org.example.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Indica que essa classe contém a lógica de negócio do sistema.
@Service
public class ClienteService {

    // Injeção de dependência do repositório
    @Autowired
    private ClienteRepository clienteRepository;

    // Retorna todos os clientes cadastrados no banco.
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    // Busca um cliente pelo ID (pode retornar vazio).
    public Optional<Cliente> buscaPorId(Long id) {
        return clienteRepository.findById(id);
    }

    // Salva ou atualiza um cliente no banco.
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Remove um cliente do banco pelo ID.
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}