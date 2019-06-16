package com.google.rodrigofreund.cadastrorisco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.rodrigofreund.cadastrorisco.dto.CadastroClienteRiscoDto;
import com.google.rodrigofreund.cadastrorisco.model.RiscoCliente;
import com.google.rodrigofreund.cadastrorisco.repository.RiscoClienteRepository;

@Service
public class CadastroClienteRiscoService {

    @Autowired
    private RiscoClienteRepository repository;

    public void salvarCadastroClienteRisco(CadastroClienteRiscoDto dto) {
        repository.save(RiscoCliente.builder()
                .limiteCredito(dto.getLimiteCreditoCliente())
                .nome(dto.getNomeCliente())
                .risco(dto.getRiscoCliente())
                .juros(calculaTaxaJuros(dto))
                .build());
    }

    private Integer calculaTaxaJuros(CadastroClienteRiscoDto dto) {
        switch (dto.getRiscoCliente()) {
        case A:
            return null;
        case B:
            return 10;
        case C:
            return 20;
        default:
            return null;

        }
    }
}
