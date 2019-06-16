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

    @Autowired
    private CalculoJurosService calculoJurosService;

    public RiscoCliente salvarCadastroClienteRisco(@Valid CadastroClienteRiscoDto dto) throws BusinessException {
        return repository.save(RiscoCliente.builder().limiteCredito(dto.getLimiteCreditoCliente())
                .nome(dto.getNomeCliente()).risco(dto.getRiscoCliente()).juros(calculoJurosService.calculaTaxaJuros(dto.getRiscoCliente())).build());
    }
}
