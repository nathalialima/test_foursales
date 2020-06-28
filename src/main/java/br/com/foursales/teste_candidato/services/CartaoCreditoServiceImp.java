package br.com.foursales.teste_candidato.services;

import br.com.foursales.teste_candidato.helpers.Mensagens;
import br.com.foursales.teste_candidato.repositories.CartaoCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CartaoCreditoServiceImp implements CartaoCreditoService{

    @Autowired
    private CartaoCreditoRepository cartaoCreditoRepository;

    @Autowired
    private Mensagens mensagem;

    @Override
    public ResponseEntity cartaoCandidato(String numero_cartao) {
        try {
            return  new ResponseEntity<>(this.cartaoCreditoRepository.findByNumero(numero_cartao).getCandidato(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return this.mensagem.mensagemErroException();

        }
    }
}
