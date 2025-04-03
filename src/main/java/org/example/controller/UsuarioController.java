package org.example.controller;  // Ajustado para org.example

import org.example.dto.LoginRequest;
import org.example.model.Usuario;
import org.example.repository.UsuarioRepository;
import org.example.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;  // Ajustado para jakarta.transaction

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        System.out.println("Recebendo login: " + loginRequest);

        Optional<Usuario> usuario = usuarioRepository.findByEmail(loginRequest.getEmail());

        if (usuario.isPresent() && usuario.get().getSenha().equals(loginRequest.getSenha())) {
            return ResponseEntity.ok(usuario.get()); // Retorna JSON válido
        }
            System.out.println("Usuários ou senha inválidas. ");
           // return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"erro\": \"Usuário ou senha inválidos\"}");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("erro", "Usuário ou senha inválidos"));
    }
}