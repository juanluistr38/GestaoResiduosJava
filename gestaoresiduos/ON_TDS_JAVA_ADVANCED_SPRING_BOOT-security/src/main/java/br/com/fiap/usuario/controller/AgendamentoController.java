package br.com.fiap.usuario.controller;

import br.com.fiap.usuario.dto.*;
import br.com.fiap.usuario.service.AgendamentoService;
import br.com.fiap.usuario.service.CaminhaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public AgendamentoExibicaoDTO salvar(
            @RequestBody AgendamentoCadastroDTO agendamento){
        return agendamentoService.salvarAgendamento(agendamento);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public Page<AgendamentoExibicaoDTO> listarTodos(
            @PageableDefault(size = 20, page = 0) Pageable paginacao
    ){
        return agendamentoService.listarTodos(paginacao);
    }


}
