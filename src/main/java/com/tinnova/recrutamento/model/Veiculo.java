package com.tinnova.recrutamento.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "VEICULO")
public class Veiculo {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name="ID_VEICULO")
    private Long id;

    @Column(name = "VEICULO")
    private String veiculo;

    @Column(name = "MARCA")
    private String marca;

    @Column(name = "ANO")
    private Integer ano;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "VENDIDO")
    private Boolean vendido;

    @Column(name = "CREATED")
    private LocalDateTime created;

    @Column(name = "UPDATED")
    private LocalDateTime updated;

}
