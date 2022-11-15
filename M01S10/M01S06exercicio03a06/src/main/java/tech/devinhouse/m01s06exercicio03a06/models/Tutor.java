package tech.devinhouse.m01s06exercicio03a06.models;

import lombok.Data;
import lombok.Builder;
@Data
@Builder
public class Tutor {

    private Integer id;
    private String nome;
    private Integer idade;
}