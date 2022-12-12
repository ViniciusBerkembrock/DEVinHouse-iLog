package tech.devinhouse.m10s01copadomundo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "JOGADORES")
@Data
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_JOGADOR")
    private Integer id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Posicao posicao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sigla", referencedColumnName = "sigla")
    private Selecao selecao;

}