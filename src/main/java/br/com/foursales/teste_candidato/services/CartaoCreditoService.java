package br.com.foursales.teste_candidato.services;

import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface CartaoCreditoService {
    public ResponseEntity cartaoCandidato(String numero_cartao);
    public ResponseEntity deletarCartaoPorCandidato(String numero_cartao, UUID id_candidato);
}
