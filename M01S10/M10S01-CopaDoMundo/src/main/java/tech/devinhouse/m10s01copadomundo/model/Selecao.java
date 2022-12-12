package tech.devinhouse.m10s01copadomundo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "SELECOES")
@Data
public class Selecao {

    @Id
    private String sigla;
    private String nome;
    private String grupo;
    private LocalDateTime dataCadastro;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "selecao")
    private List<Jogador> jogadores;

}