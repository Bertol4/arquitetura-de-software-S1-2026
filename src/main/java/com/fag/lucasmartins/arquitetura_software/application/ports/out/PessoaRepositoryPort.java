package com.fag.lucasmartins.arquitetura_software.application.ports.out;

import com.fag.lucasmartins.arquitetura_software.domain.pessoa.Pessoa;

import java.util.UUID;

public interface PessoaRepositoryPort {
    Pessoa save(Pessoa pessoa);
}
