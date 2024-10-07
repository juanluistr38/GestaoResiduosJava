package br.com.fiap.usuario.dto;

import br.com.fiap.usuario.model.Agendamento;

public record AgendamentoExibicaoDTO(
        Long id,
        String usuario,
        String endereco,
        String tipoLixo,
        String data_hora_envio) {
    public AgendamentoExibicaoDTO(Agendamento agendamento){
        this(
                agendamento.getId(),
                agendamento.getUsuario(),
                agendamento.getEndereco(),
                agendamento.getTipoLixo(),
                agendamento.getDatahoraenvio() );
    }
}
