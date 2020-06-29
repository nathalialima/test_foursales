package br.com.foursales.teste_candidato;

import br.com.foursales.teste_candidato.models.Candidato;
import br.com.foursales.teste_candidato.models.CartaoCredito;
import br.com.foursales.teste_candidato.repositories.CandidatoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.UUID;

@SpringBootTest
public class CandidatoTests {

    @Autowired
    CandidatoRepository candidatoRepository;

    @Test
    void createCandidato(){
        Candidato candidatoVO = new Candidato(UUID.randomUUID(), "teste0", "teste","11111111111", null, null, null, null);
        CartaoCredito cartaoCredito = new CartaoCredito();
        cartaoCredito.setBandeira("VISA");
        cartaoCredito.setDataEmissao("11/11");
        cartaoCredito.setDataValidade("10/10");
        cartaoCredito.setNumero("222222222222");
        ArrayList<CartaoCredito> cartoes = new ArrayList();
        cartoes.add(cartaoCredito);
        candidatoVO.setCartoes(cartoes);
        Candidato candidato =  candidatoRepository.save(candidatoVO);
        Assertions.assertThat(candidato.getId()).isNotNull();
    }

    @Test
    void createCandidatoError(){
        UUID uuid = null;
        Candidato candidatoVO = new Candidato(UUID.randomUUID(), "teste0", "teste2","11111111111", null, null, null, null);
        Candidato candidato =  candidatoRepository.save(candidatoVO);
        Assertions.assertThat(candidato.getNome()).isNotEqualTo("AAAAA");
    }


}
