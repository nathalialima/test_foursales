package br.com.foursales.teste_candidato.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
@ToString
public class Telefone {

    private String numero;

    private String ddd;
}
