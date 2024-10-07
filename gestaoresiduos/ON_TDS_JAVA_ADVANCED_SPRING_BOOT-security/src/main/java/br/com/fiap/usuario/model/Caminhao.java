package br.com.fiap.usuario.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_caminhoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Caminhao {

    @Getter
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_TBL_CAMINHAO"
    )
    @SequenceGenerator(
            name =  "SEQ_TBL_CAMINHAO",
            sequenceName = "SEQ_TBL_CAMINHAO",
            allocationSize = 1
    )
    @Column(name = "id_caminhao")
    private Long caminhaoId;

    @Getter
    @Column(name = "placa", nullable = false)
    private String placa;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "capacidade", nullable = false)
    private Double capacidade;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "rota_atual")
    private String rotaAtual;

}
