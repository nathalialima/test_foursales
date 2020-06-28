package br.com.foursales.teste_candidato.helpers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class MensagemImp implements Mensagens{
    private Map<String, Object> responseBody = new LinkedHashMap<>();

    @Override
    public ResponseEntity mensagemEmailDuplicado() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        responseBody.put("mensagem",ConstantesMensagem.EMAIL_DUPLICADO);
        return new ResponseEntity<>(responseBody, headers, HttpStatus.ACCEPTED.UNPROCESSABLE_ENTITY);
    }

    @Override
    public ResponseEntity mensagemCpfDuplicado() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        responseBody.put("mensagem",ConstantesMensagem.CPF_DUPLICADO);
        return new ResponseEntity<>(responseBody, headers, HttpStatus.ACCEPTED.UNPROCESSABLE_ENTITY);
    }

    @Override
    public ResponseEntity mensagemErroException() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        responseBody.put("mensagem",ConstantesMensagem.ERRO_EXCEPTION);
        return new ResponseEntity<>(responseBody, headers, HttpStatus.ACCEPTED.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity mensagemSucessoCandidato() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        responseBody.put("mensagem",ConstantesMensagem.CADASTRO_CANDIDATO_SUCESSO);
        return new ResponseEntity<>(responseBody, headers, HttpStatus.ACCEPTED.OK);
    }

    @Override
    public ResponseEntity mensagemSucessoCandidatoAtualizado() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        responseBody.put("mensagem",ConstantesMensagem.CADASTRO_CANDIDATO_ATUALIZADO_SUCESSO);
        return new ResponseEntity<>(responseBody, headers, HttpStatus.ACCEPTED.OK);
    }

    @Override
    public ResponseEntity mensagemSucessoCandidatoDeletado() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        responseBody.put("mensagem",ConstantesMensagem.CANDIDATO_DELETADO_SUCESSO);
        return new ResponseEntity<>(responseBody, headers, HttpStatus.ACCEPTED.OK);
    }

    @Override
    public ResponseEntity mensagemErroIdNaoExistente() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        responseBody.put("mensagem",ConstantesMensagem.ID_NAO_EXISTENTE);
        return new ResponseEntity<>(responseBody, headers, HttpStatus.ACCEPTED.UNPROCESSABLE_ENTITY);
    }
}
