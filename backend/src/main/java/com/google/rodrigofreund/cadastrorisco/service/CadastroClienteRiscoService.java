package com.google.rodrigofreund.cadastrorisco.service;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.google.rodrigofreund.cadastrorisco.dto.CadastroClienteRiscoDto;
import com.google.rodrigofreund.cadastrorisco.exception.BusinessException;
import com.google.rodrigofreund.cadastrorisco.model.RiscoCliente;
import com.google.rodrigofreund.cadastrorisco.repository.RiscoClienteRepository;

@Service
@Validated
public class CadastroClienteRiscoService {

    @Autowired
    private RiscoClienteRepository repository;

    public RiscoCliente salvarCadastroClienteRisco(@Valid CadastroClienteRiscoDto dto) throws BusinessException {
        return repository.save(RiscoCliente.builder()
                .limiteCredito(dto.getLimiteCreditoCliente())
                .nome(dto.getNomeCliente())
                .risco(dto.getRiscoCliente())
                .juros(calculaTaxaJuros(dto))
                .build());
    }

    private Integer calculaTaxaJuros(CadastroClienteRiscoDto dto) throws BusinessException {
        switch (dto.getRiscoCliente()) {
        case A:
            return null;
        case B:
            return 10;
        case C:
            return 20;
        default:
            throw new BusinessException("Risco do cliente inválido!");
        }
    }
}
