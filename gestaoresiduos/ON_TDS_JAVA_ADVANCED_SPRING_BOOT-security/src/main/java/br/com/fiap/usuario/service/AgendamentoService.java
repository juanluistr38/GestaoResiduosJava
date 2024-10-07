package br.com.fiap.usuario.service;


import br.com.fiap.usuario.dto.AgendamentoCadastroDTO;
import br.com.fiap.usuario.dto.AgendamentoExibicaoDTO;
import br.com.fiap.usuario.dto.CaminhaoExibicaoDTO;
import br.com.fiap.usuario.model.Agendamento;
import br.com.fiap.usuario.repository.AgendamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {


    @Autowired
    private AgendamentoRepository agendamentoRepository;


    public AgendamentoExibicaoDTO salvarAgendamento(AgendamentoCadastroDTO agendamentoDTO){
        Agendamento agendamento = new Agendamento();

        BeanUtils.copyProperties(agendamentoDTO, agendamento);

        Agendamento agendamentoSalvo = agendamentoRepository.save(agendamento);
        return new AgendamentoExibicaoDTO(agendamentoSalvo);
    }

    public Page<AgendamentoExibicaoDTO> listarTodos(Pageable paginacao){
        return agendamentoRepository
                .findAll(paginacao)
                .map(AgendamentoExibicaoDTO::new);
    }
}
