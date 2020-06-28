package br.com.foursales.teste_candidato.controllers;

import br.com.foursales.teste_candidato.models.Candidato;
import br.com.foursales.teste_candidato.models.CartaoCredito;
import br.com.foursales.teste_candidato.services.CartaoCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private CartaoCreditoService cartaoCreditoService;

    @GetMapping("{numero_cartao}/candidato")
    public ResponseEntity visualizarCandidatoPorCartao(@PathVariable String numero_cartao){
        return  this.cartaoCreditoService.cartaoCandidato(numero_cartao);
    }

    @GetMapping("{numero_cartao}/{id_candidato}/candidato")
    public ResponseEntity deletarCartaoPorCandidato(@PathVariable String numero_cartao, UUID id_candidato){
        return  this.cartaoCreditoService.deletarCartaoPorCandidato(numero_cartao, id_candidato);
    }

    @PostMapping(value = "{numero_cartao}/{id_candidato}/atualizar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity atualizar(@RequestBody CartaoCredito cartaoCredito, @PathVariable String numero_cartao, UUID id_candidato){
        return this.cartaoCreditoService.atualizarCartao(cartaoCredito, numero_cartao, id_candidato);
    }


}
