package org.example.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

// Classe usada para transferir os dados do cliente entre backend e frontend.
@Data
public class ClienteDTO {

    private String nome;
    // private String pago;
    private LocalDateTime dataHora;

    // Você pode incluir validações com @NotNull, @Email, etc.
    // Ex: @NotBlank, @Size, @Email
}