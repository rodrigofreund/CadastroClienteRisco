package com.google.rodrigofreund.cadastrorisco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.rodrigofreund.cadastrorisco.dto.CadastroClienteRiscoDto;
import com.google.rodrigofreund.cadastrorisco.service.CadastroClienteRiscoService;

@RestController
@RequestMapping(path = "CadastroRisco")
public class CadastroRiscoController {

    @Autowired
    private CadastroClienteRiscoService service;

    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping(value = "cadastrarClienteRisco")
    public void cadastrarClienteRisco(@RequestBody CadastroClienteRiscoDto cadastroClienteRiscoDto) {
        service.salvarCadastroClienteRisco(cadastroClienteRiscoDto);
    }
}
