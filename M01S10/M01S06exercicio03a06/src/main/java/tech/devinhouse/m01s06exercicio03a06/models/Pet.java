package tech.devinhouse.m01s06exercicio03a06.models;

import lombok.Data;
import lombok.Builder;
@Data
@Builder
public class Pet {

    private Integer id;
    private String nome;
    private String tipo;
    private String raca;
    private Integer idade;
    private String alimentoPreferido;
    private Tutor tutor;

}