package br.com.foursales.teste_candidato.helpers;

import org.springframework.http.ResponseEntity;

public interface Mensagens {
    ResponseEntity mensagemEmailDuplicado();
    ResponseEntity mensagemCpfDuplicado();
    ResponseEntity mensagemErroException();
    ResponseEntity mensagemSucessoCandidato();
    ResponseEntity mensagemSucessoCandidatoAtualizado();
    ResponseEntity mensagemSucessoCandidatoDeletado();
    ResponseEntity mensagemErroIdNaoExistente();
}
