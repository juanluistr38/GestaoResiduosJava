package br.com.fiap.usuario.service;

import br.com.fiap.usuario.dto.CaminhaoCadastroDTO;
import br.com.fiap.usuario.dto.CaminhaoExibicaoDTO;
import br.com.fiap.usuario.dto.UsuarioExibicaoDTO;
import br.com.fiap.usuario.exception.UsuarioNaoEncontradoException;
import br.com.fiap.usuario.model.Caminhao;
import br.com.fiap.usuario.model.Usuario;
import br.com.fiap.usuario.repository.CaminhaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    public CaminhaoExibicaoDTO salvarCaminhao(CaminhaoCadastroDTO caminhaoDTO){

        Caminhao caminhao = new Caminhao();
        BeanUtils.copyProperties(caminhaoDTO, caminhao);

        Caminhao caminhaoSalvo = caminhaoRepository.save(caminhao);
        return new CaminhaoExibicaoDTO(caminhaoSalvo);

    }

    public Page<CaminhaoExibicaoDTO> listarTodos(Pageable paginacao){
        return caminhaoRepository
                .findAll(paginacao)
                .map(CaminhaoExibicaoDTO::new);
    }

    public CaminhaoExibicaoDTO buscarPorPlaca(String placa){
        Optional<Caminhao> caminhaoOptional =
                caminhaoRepository.buscarPorPlaca(placa);

        if (caminhaoOptional.isPresent()){
            return new CaminhaoExibicaoDTO(caminhaoOptional.get());
        } else {
            throw new UsuarioNaoEncontradoException("Caminhao não existe no banco de dados!");
        }
    }

    public CaminhaoExibicaoDTO atualizar(CaminhaoCadastroDTO caminhaoDTO){
        Optional<Caminhao> caminhaoOptional =
                caminhaoRepository.findById(caminhaoDTO.caminhaoId());

        if (caminhaoOptional.isPresent()){
            Caminhao caminhao = new Caminhao();
            BeanUtils.copyProperties(caminhaoDTO, caminhao);

            return new CaminhaoExibicaoDTO(caminhaoRepository.save(caminhao));
        } else {
            throw new RuntimeException("Alimento não encontrado!");
        }
    }

    public void excluir(Long caminhaoId){
        Optional<Caminhao> caminhaoOptional =
                caminhaoRepository.findById(caminhaoId);

        if (caminhaoOptional.isPresent()){
            caminhaoRepository.delete(caminhaoOptional.get());
        } else {
            throw new RuntimeException("Caminhao não encontrado!");
        }
    }
}
