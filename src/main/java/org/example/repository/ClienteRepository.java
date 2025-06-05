package org.example.repository;

import org.example.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Indica que essa interface é um componente do Spring para acesso ao banco de dados.
@Repository
// JpaRepository fornece métodos prontos para CRUD (como save, findAll, findById, delete, etc.)
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Aqui você pode adicionar métodos personalizados se precisar, como:
    // List<Cliente> findByNome(String nome);
}