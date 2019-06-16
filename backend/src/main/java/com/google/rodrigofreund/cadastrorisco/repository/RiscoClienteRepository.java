package com.google.rodrigofreund.cadastrorisco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.rodrigofreund.cadastrorisco.model.RiscoCliente;

public interface RiscoClienteRepository extends JpaRepository<RiscoCliente, Long> {

}
