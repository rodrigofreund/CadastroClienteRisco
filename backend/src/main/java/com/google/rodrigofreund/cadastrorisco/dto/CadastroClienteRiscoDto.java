package com.google.rodrigofreund.cadastrorisco.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.google.rodrigofreund.cadastrorisco.domain.TipoRisco;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CadastroClienteRiscoDto {
    @NotNull(message = "Nome do cliente não informado")
    private String nomeCliente;
    @NotNull(message = "Limite de crédito não informado")
    private BigDecimal limiteCreditoCliente;
    @NotNull(message = "Risco do cliente não informado")
    private TipoRisco riscoCliente;
}
