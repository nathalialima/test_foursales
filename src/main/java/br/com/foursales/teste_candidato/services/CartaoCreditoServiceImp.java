package br.com.foursales.teste_candidato.services;

import br.com.foursales.teste_candidato.helpers.Mensagens;
import br.com.foursales.teste_candidato.models.CartaoCredito;
import br.com.foursales.teste_candidato.repositories.CandidatoRepository;
import br.com.foursales.teste_candidato.repositories.CartaoCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CartaoCreditoServiceImp implements CartaoCreditoService{

    @Autowired
    private CartaoCreditoRepository cartaoCreditoRepository;

    @Autowired
    private CandidatoRepository candidatoRepository;

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

    @Override
    public ResponseEntity deletarCartaoPorCandidato(String numero_cartao, UUID id_candidato) {
        try {
            if(id_candidato == null){
                return this.mensagem.mensagemErroIdNaoExistente();
            }

            if(numero_cartao == null){
                return this.mensagem.mensagemErroCartaoNaoExistente();
            }

            if(this.cartaoCreditoRepository.countByNumero(numero_cartao) == 0){
                return this.mensagem.mensagemErroCartaoNaoExistente();
            }

            if(this.candidatoRepository.countById(id_candidato) == 0){
                return this.mensagem.mensagemErroIdNaoExistente();
            }

            this.cartaoCreditoRepository.deleteByNumeroAndCandidato_Id(numero_cartao, id_candidato);
            return this.mensagem.mensagemSucessoCartaoDeletado();
        }catch (Exception e){
            return this.mensagem.mensagemErroException();
        }
    }

    @Override
    public ResponseEntity atualizarCartao(CartaoCredito cartaoCredito, String numero_cartao, UUID id_candidato) {
        try {
            if(id_candidato == null){
                return this.mensagem.mensagemErroIdNaoExistente();
            }

            if(numero_cartao == null){
                return this.mensagem.mensagemErroCartaoNaoExistente();
            }

            if(this.cartaoCreditoRepository.countByNumero(numero_cartao) == 0){
                return this.mensagem.mensagemErroCartaoNaoExistente();
            }

            if(this.candidatoRepository.countById(id_candidato) == 0){
                return this.mensagem.mensagemErroIdNaoExistente();
            }

            if (cartaoCredito == null){
                return this.mensagem.mensagemErroCartaoNaoExistente();
            }

            CartaoCredito cartaoCreditoAtual = this.cartaoCreditoRepository.findByNumero(numero_cartao);

            if(cartaoCreditoAtual.getCandidato().getId() != id_candidato){
                return this.mensagem.mensagemErroCartaoNaoPertenceAoUsuarioInformado();
            }

            cartaoCredito.setId(cartaoCreditoAtual.getId());
            this.cartaoCreditoRepository.save(cartaoCredito);
            return this.mensagem.mensagemSucessoCartaoAtualizado();
        }catch (Exception e){
            return this.mensagem.mensagemErroException();
        }
    }
}
