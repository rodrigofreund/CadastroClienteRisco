package com.google.rodrigofreund.cadastrorisco.service;

import org.springframework.stereotype.Service;

import com.google.rodrigofreund.cadastrorisco.domain.TipoRisco;
import com.google.rodrigofreund.cadastrorisco.exception.BusinessException;

@Service
public class CalculoJurosService {
    public Integer calculaTaxaJuros(TipoRisco risco) throws BusinessException {
        switch (risco) {
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
