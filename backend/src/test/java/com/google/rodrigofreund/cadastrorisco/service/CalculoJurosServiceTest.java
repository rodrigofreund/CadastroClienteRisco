package com.google.rodrigofreund.cadastrorisco.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.rodrigofreund.cadastrorisco.domain.TipoRisco;
import com.google.rodrigofreund.cadastrorisco.exception.BusinessException;

@RunWith(SpringJUnit4ClassRunner.class)
public class CalculoJurosServiceTest {
    
    @InjectMocks
    private CalculoJurosService service;

    @Test
    public void testeJurosRiscoA() throws BusinessException {
        Integer juros = service.calculaTaxaJuros(TipoRisco.A);
        Assert.assertEquals(null, juros);
    }

    @Test
    public void testeJurosRiscoB() throws BusinessException {
        Integer juros = service.calculaTaxaJuros(TipoRisco.B);
        Assert.assertEquals(10, juros.intValue());
    }

    @Test
    public void testeJurosRiscoC() throws BusinessException {
        Integer juros = service.calculaTaxaJuros(TipoRisco.C);
        Assert.assertEquals(20, juros.intValue());
    }

}
