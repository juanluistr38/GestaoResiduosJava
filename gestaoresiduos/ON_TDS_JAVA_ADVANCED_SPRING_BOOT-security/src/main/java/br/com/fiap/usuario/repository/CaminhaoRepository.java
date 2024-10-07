package br.com.fiap.usuario.repository;

import br.com.fiap.usuario.dto.CaminhaoExibicaoDTO;
import br.com.fiap.usuario.model.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {

    @Query("SELECT a FROM Caminhao a WHERE a.placa = :placa")
    Optional<Caminhao> buscarPorPlaca(@Param("placa") String placa);
}

