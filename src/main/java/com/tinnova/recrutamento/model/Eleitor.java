package com.tinnova.recrutamento.model;

import lombok.Data;

@Data
public class Eleitor {
    private Integer totalEleitores;
    private Integer validos;
    private Integer brancos;
    private Integer nulos;
}
