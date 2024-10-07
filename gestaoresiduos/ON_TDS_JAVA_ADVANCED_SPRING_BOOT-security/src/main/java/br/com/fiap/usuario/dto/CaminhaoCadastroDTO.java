package br.com.fiap.usuario.dto;

import jakarta.persistence.Column;

public record CaminhaoCadastroDTO(
        Long caminhaoId,
        String placa,
        String modelo,
        Double capacidade,
        String status,
        String rotaAtual){
}
