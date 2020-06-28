package br.com.foursales.teste_candidato.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parent;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Data
public class CartaoCredito {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(unique = true)
    private String numero;

    @OneToOne(targetEntity = Candidato.class)
    @JoinColumn(name = "id_candidato", referencedColumnName = "id")
    @JsonIgnore
    private Candidato candidato;

    private String dataValidade;

    private String dataEmissao;

    private String bandeira;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime modified;
}
