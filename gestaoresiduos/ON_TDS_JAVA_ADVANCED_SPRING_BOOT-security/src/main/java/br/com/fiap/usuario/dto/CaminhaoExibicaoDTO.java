package br.com.fiap.usuario.dto;

import br.com.fiap.usuario.model.Caminhao;

public record CaminhaoExibicaoDTO(
        Long caminhaoId,
        String placa,
        String modelo,
        Double capacidade,
        String status,
        String rotaAtual
) {

    public CaminhaoExibicaoDTO(Caminhao caminhao) {
        this(
                caminhao.getCaminhaoId(),
                caminhao.getPlaca(),
                caminhao.getModelo(),
                caminhao.getCapacidade(),
                caminhao.getStatus(),
                caminhao.getRotaAtual()
        );
    }

}
