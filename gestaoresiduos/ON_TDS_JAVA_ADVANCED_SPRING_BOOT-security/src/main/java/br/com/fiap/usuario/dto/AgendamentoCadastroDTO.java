package br.com.fiap.usuario.dto;

import jakarta.validation.constraints.NotBlank;

public record AgendamentoCadastroDTO (
    Long id,

    @NotBlank(message = "O nome do usuário é obrigatório!")
    String usuario,

    @NotBlank(message = "O endereco é obrigatório!")
    String endereco,

    @NotBlank(message = "O tipo_lixo é obrigatório!")
    String tipoLixo,

    @NotBlank(message = "A data é obrigatório")
    String datahoraenvio
){}
