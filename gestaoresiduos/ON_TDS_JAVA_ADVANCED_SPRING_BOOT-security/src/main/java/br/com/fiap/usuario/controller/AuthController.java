package br.com.fiap.usuario.controller;

import br.com.fiap.usuario.config.security.TokenService;
import br.com.fiap.usuario.dto.LoginDTO;
import br.com.fiap.usuario.dto.TokenDTO;
import br.com.fiap.usuario.dto.UsuarioCadastroDTO;
import br.com.fiap.usuario.dto.UsuarioExibicaoDTO;
import br.com.fiap.usuario.model.Usuario;
import br.com.fiap.usuario.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(
            @RequestBody
            @Valid
            LoginDTO usuarioDto
    ){
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        usuarioDto.email(),
                        usuarioDto.senha());

        Authentication auth = authenticationManager.authenticate(usernamePassword);

        System.out.println(auth.getPrincipal());

        String token = tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(token));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDTO registrar(@RequestBody @Valid UsuarioCadastroDTO usuarioCadastroDTO){

        UsuarioExibicaoDTO usuarioSalvo = null;
        usuarioSalvo = usuarioService.salvarUsuario(usuarioCadastroDTO);

        return usuarioSalvo;

    }
}
