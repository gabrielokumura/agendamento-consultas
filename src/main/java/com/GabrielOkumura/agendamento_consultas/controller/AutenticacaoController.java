package com.GabrielOkumura.agendamento_consultas.controller;

import com.GabrielOkumura.agendamento_consultas.dto.DadosAutenticacao;
import com.GabrielOkumura.agendamento_consultas.dto.DadosTokenJWT;
import com.GabrielOkumura.agendamento_consultas.infra.TokenService;
import com.GabrielOkumura.agendamento_consultas.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping()
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados ) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

}
