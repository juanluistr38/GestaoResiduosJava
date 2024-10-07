package br.com.fiap.usuario.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_agendamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AGENDAMENTO")
    @SequenceGenerator(name = "SEQ_AGENDAMENTO", sequenceName = "SEQ_AGENDAMENTO", allocationSize = 1)

    @Column(name = "id_agendamento")
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private String usuario;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "tipo_lixo")
    private String tipoLixo;

    @Column(name = "dataHoraEnvio", nullable = false)
    private String datahoraenvio;
}
