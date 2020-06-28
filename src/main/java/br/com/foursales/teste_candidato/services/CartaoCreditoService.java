package br.com.foursales.teste_candidato.services;

import br.com.foursales.teste_candidato.models.CartaoCredito;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface CartaoCreditoService {
    public ResponseEntity cartaoCandidato(String numero_cartao);
    public ResponseEntity deletarCartaoPorCandidato(String numero_cartao, UUID id_candidato);
    public ResponseEntity atualizarCartao(CartaoCredito cartaoCredito, String numero_cartao, UUID id_candidato);
}
