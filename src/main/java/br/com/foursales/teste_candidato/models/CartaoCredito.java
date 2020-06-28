package br.com.foursales.teste_candidato.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
@ToString
public class CartaoCredito {


    @Column(unique = true)
    private String numero;

    private String dataValidade;

    private String dataEmissao;

    private String bandeira;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime modified;
}
