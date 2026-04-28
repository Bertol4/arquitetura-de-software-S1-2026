package com.fag.lucasmartins.arquitetura_software.application.ports.in;

import com.fag.lucasmartins.arquitetura_software.dto.PessoaRequestDto;
import com.fag.lucasmartins.arquitetura_software.dto.PessoaResponseDto;
import java.util.UUID;

public interface PessoaUseCasePort {
    PessoaResponseDto createPessoa(PessoaRequestDto requestDto);
}
