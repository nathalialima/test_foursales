package br.com.foursales.teste_candidato.controllers;

import br.com.foursales.teste_candidato.models.Candidato;
import br.com.foursales.teste_candidato.services.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;


    @PostMapping(value = "/novo", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity novo(@RequestBody Candidato candidato){
        return  this.candidatoService.criarCandidato(candidato);
    }

    @GetMapping("/listar")
    public ResponseEntity listar(){
        return this.candidatoService.listarCandidatos();
    }

    @PostMapping(value = "/atualizar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity atualizar(@RequestBody Candidato candidato){
        return this.candidatoService.atualizarCandidato(candidato);
    }

    @GetMapping("/{uuid}/deletar")
    public ResponseEntity deletar(@PathVariable UUID uuid){
        return this.candidatoService.deletarCandidato(uuid);
    }

    @GetMapping("/{uuid}/visualizar")
    public ResponseEntity visualizar(@PathVariable UUID uuid){
        return this.candidatoService.perfilCandidato(uuid);
    }
}
