package br.com.foursales.teste_candidato.services;

import br.com.foursales.teste_candidato.helpers.Mensagens;
import br.com.foursales.teste_candidato.models.Candidato;
import br.com.foursales.teste_candidato.repositories.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class CandidatoServiceImp implements CandidatoService{

    @Autowired
    private Mensagens mensagem;

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Override
    public ResponseEntity criarCandidato(Candidato candidato) {
        try {

            if(this.candidatoRepository.countByEmail(candidato.getEmail()) != 0){
                return this.mensagem.mensagemEmailDuplicado();
            }

            if(this.candidatoRepository.countByCpf(candidato.getCpf()) != 0){
                return this.mensagem.mensagemCpfDuplicado();
            }

            this.candidatoRepository.save(candidato);
            return this.mensagem.mensagemSucessoCandidato();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return this.mensagem.mensagemErroException();
        }
    }

    @Override
    public ResponseEntity atualizarCandidato(Candidato candidato) {
        try {
            if(candidato.getId() == null){
                return this.mensagem.mensagemErroIdNaoExistente();
            }

            if(this.candidatoRepository.countById(candidato.getId()) == 0){
                return this.mensagem.mensagemErroIdNaoExistente();
            }

            this.candidatoRepository.save(candidato);
            return this.mensagem.mensagemSucessoCandidatoAtualizado();
        }catch (Exception e){
            return this.mensagem.mensagemErroException();
        }
    }

    @Override
    public ResponseEntity listarCandidatos() {
        try{
            return  new ResponseEntity<>(this.candidatoRepository.findAll(), HttpStatus.ACCEPTED);
        } catch (NullPointerException n){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return this.mensagem.mensagemErroException();
        }
    }

    @Override
    public ResponseEntity deletarCandidato(UUID id) {
        try {
            if(id == null){
                return this.mensagem.mensagemErroIdNaoExistente();
            }

            if(this.candidatoRepository.countById(id) == 0 ){
                return this.mensagem.mensagemErroIdNaoExistente();
            }

            this.candidatoRepository.deleteById(id);
            return this.mensagem.mensagemSucessoCandidatoDeletado();
        }catch (Exception e){
            return this.mensagem.mensagemErroException();
        }
    }

    @Override
    public ResponseEntity perfilCandidato(UUID id) {
        try {
            if(id == null){
                return this.mensagem.mensagemErroIdNaoExistente();
            }

            if(this.candidatoRepository.countById(id) == 0 ){
                return this.mensagem.mensagemErroIdNaoExistente();
            }

            return  new ResponseEntity<>(this.candidatoRepository.findById(id).orElse(new Candidato()), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return this.mensagem.mensagemErroException();
        }
    }
}
