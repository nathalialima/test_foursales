package br.com.foursales.teste_candidato.repositories;

import br.com.foursales.teste_candidato.models.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, UUID> {
    Long countByEmail(String email);
    Long countByCpf(String cpf);
    Long countById(UUID id);
    void deleteById(UUID id);
    Optional<Candidato> findById(UUID id);

}
