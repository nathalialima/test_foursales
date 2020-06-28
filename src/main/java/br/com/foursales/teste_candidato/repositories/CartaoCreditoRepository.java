package br.com.foursales.teste_candidato.repositories;

import br.com.foursales.teste_candidato.models.Candidato;
import br.com.foursales.teste_candidato.models.CartaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, UUID> {
    Long countByNumero(String numero);
    void deleteByNumeroAndCandidato_Id(String numero, UUID id);
    CartaoCredito findByNumero(String numero);
}
