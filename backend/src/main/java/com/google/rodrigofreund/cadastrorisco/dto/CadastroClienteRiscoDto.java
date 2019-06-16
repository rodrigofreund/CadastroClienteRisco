package com.google.rodrigofreund.cadastrorisco.dto;

import java.math.BigDecimal;

import com.google.rodrigofreund.cadastrorisco.domain.TipoRisco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastroClienteRiscoDto {
    private String nomeCliente;
    private BigDecimal limiteCreditoCliente;
    private TipoRisco riscoCliente;
}
