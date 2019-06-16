package com.google.rodrigofreund.cadastrorisco.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.rodrigofreund.cadastrorisco.domain.TipoRisco;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class RiscoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 200)
    private String nome;

    @Column(nullable = false)
    private BigDecimal limiteCredito;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 1)
    private TipoRisco risco;

    private Integer juros;
}
