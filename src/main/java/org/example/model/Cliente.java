package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

// Indica que a classe será uma tabela no banco.
@Entity

// Apontando para a nova tabela
@Table(name = "agendamento_pet")

// Lombok, gera getters/setters, toString, equals, etc.
@Data

public class Cliente {
    // Define a chave primária
    @Id
    // gera o ID automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    // private String pago;
    @Column(name = "data_hora")
    private LocalDateTime dataHora;
}