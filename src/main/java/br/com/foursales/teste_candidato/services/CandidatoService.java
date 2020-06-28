package br.com.foursales.teste_candidato.services;

import br.com.foursales.teste_candidato.models.Candidato;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface CandidatoService {
    public ResponseEntity criarCandidato(Candidato candidato);
    public ResponseEntity atualizarCandidato(Candidato candidato);
    public ResponseEntity listarCandidatos();
    public ResponseEntity deletarCandidato(UUID id);
    public ResponseEntity perfilCandidato(UUID id);
}
