package br.com.fiap.usuario.controller;

import br.com.fiap.usuario.dto.CaminhaoCadastroDTO;
import br.com.fiap.usuario.dto.CaminhaoExibicaoDTO;
import br.com.fiap.usuario.service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caminhao")
public class CaminhaoController {

    @Autowired
    private CaminhaoService caminhaoService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public CaminhaoExibicaoDTO salvar(
            @RequestBody CaminhaoCadastroDTO caminhao){
        return caminhaoService.salvarCaminhao(caminhao);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public Page<CaminhaoExibicaoDTO> listarTodos(
            @PageableDefault(size = 20, page = 0) Pageable paginacao
    ){
        return caminhaoService.listarTodos(paginacao);
    }

    @RequestMapping(value = "/listar", params = "placa")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CaminhaoExibicaoDTO> buscarPorPlaca(
            @RequestParam String placa){
        try {
            return ResponseEntity.ok(caminhaoService.buscarPorPlaca(placa));
        } catch(Exception e){
            return ResponseEntity.notFound().build();
        }
        }


    @PutMapping(value ="/atualizar")
    public ResponseEntity<CaminhaoExibicaoDTO> atualizar(
            @RequestBody CaminhaoCadastroDTO caminhaoDTO){
        try {
            CaminhaoExibicaoDTO caminhaoExibicaoDTO =
                    caminhaoService.atualizar(caminhaoDTO);
            return ResponseEntity.ok(caminhaoExibicaoDTO);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{caminhaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long caminhaoId){
        caminhaoService.excluir(caminhaoId);
    }

    /*
    @RequestMapping(value = "/alimentos", params = {"caloriasMinima", "caloriasMaxima"})
    @ResponseStatus(HttpStatus.OK)
    public List<CaminhaoExibicaoDTO> litarAlimentosPorFaixaDeCalorias(
            @RequestParam Double caloriasMinima,
            @RequestParam Double caloriasMaxima
    ){
        return caminhaoService.listarAlimentosPorFaixaDeCalorias(caloriasMinima, caloriasMaxima);
    }

    @RequestMapping(value = "/alimentos", params = "caloriasMenorQue")
    @ResponseStatus(HttpStatus.OK)
    public List<CaminhaoExibicaoDTO> litarTotalCaloriasMenorQue(
            @RequestParam Double caloriasMenorQue
    ){
        return caminhaoService.listarTotalCaloriasMenorQue(caloriasMenorQue);
    }*/

}
