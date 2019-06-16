package com.google.rodrigofreund.cadastrorisco.service;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.rodrigofreund.cadastrorisco.domain.TipoRisco;
import com.google.rodrigofreund.cadastrorisco.dto.CadastroClienteRiscoDto;
import com.google.rodrigofreund.cadastrorisco.exception.BusinessException;
import com.google.rodrigofreund.cadastrorisco.model.RiscoCliente;
import com.google.rodrigofreund.cadastrorisco.repository.RiscoClienteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class CadastroClienteRiscoServiceTest {

    @Mock
    private RiscoClienteRepository repository;

    @InjectMocks
    private CadastroClienteRiscoService service;

    @Test(expected = BusinessException.class)
    public void testeSemInformacoes() throws BusinessException {
        CadastroClienteRiscoDto dto = Mockito.mock(CadastroClienteRiscoDto.class);
        service.salvarCadastroClienteRisco(dto);
    }

    @Test(expected = BusinessException.class)
    public void testeCadastroRisco() throws BusinessException {
        Mockito.when(repository.save(Mockito.any(RiscoCliente.class))).thenReturn(RiscoCliente.builder().id(1l)
                .limiteCredito(new BigDecimal("1000")).nome("Nome do Cliente").juros(20).build());
        CadastroClienteRiscoDto dto = CadastroClienteRiscoDto.builder().nomeCliente("Nome do Cliente")
                .limiteCreditoCliente(new BigDecimal("520")).riscoCliente(TipoRisco.C).build();

        RiscoCliente result = service.salvarCadastroClienteRisco(dto);

        Assert.assertEquals(dto.getNomeCliente(), result.getNome());
    }

}
