package br.com.foursales.teste_candidato.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Candidato {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;


    private String nome;

    @Column(unique = true)
    private String email;

    private String cpf;

    @ElementCollection
    private List<Telefone> telefones;

    @OneToMany(targetEntity = CartaoCredito.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_candidato")
    private List<CartaoCredito> cartoes;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime modified;
}
