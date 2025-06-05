package org.example.controller;

import org.example.dto.ClienteDTO;
import org.example.model.Cliente;
import org.example.repository.ClienteRepository;
import org.example.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Define que essa classe é um controlador REST e que todas as respostas serão no formato JSON.
@RestController
// Mapeia a URL base para acessar os endpoints (ex: /api/clientes).
@RequestMapping("/api/clientes")
public class ClienteController {

    // Injeção de dependência do serviço.
    @Autowired
    private ClienteService clienteService;
    private ClienteRepository clienteRepository;

    // Retorna a lista de todos os clientes.
    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        List<Cliente> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);
    }


    // Retorna um cliente pelo ID.
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.buscaPorId(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Salva um novo cliente.
    @PostMapping
    public Cliente salvarCliente(@RequestBody ClienteDTO clienteDTO) {
        System.out.println("Recebido no backend: " + clienteDTO);
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
        return clienteService.salvar(cliente);
    }

    // Atualiza os dados de um cliente existente.
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        cliente.setId(id); // Garante que o ID enviado na URL seja aplicado no objeto.
        Cliente clienteAtualizado = clienteService.salvar(cliente);
        return ResponseEntity.ok(clienteAtualizado);
    }

    // Remove um cliente pelo ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable("id") Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}