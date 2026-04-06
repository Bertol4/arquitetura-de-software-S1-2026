package com.fag.lucasmartins.arquitetura_software.application.service;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.PessoaUseCasePort;
import com.fag.lucasmartins.arquitetura_software.application.ports.out.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.domain.pessoa.Pessoa;
import com.fag.lucasmartins.arquitetura_software.dto.PessoaRequestDto;
import com.fag.lucasmartins.arquitetura_software.dto.PessoaResponseDto;
import org.springframework.stereotype.Service;

@Service
public class PessoaService implements PessoaUseCasePort {

    private final PessoaRepositoryPort pessoaRepositoryPort;

    public PessoaService(PessoaRepositoryPort pessoaRepositoryPort) {
        this.pessoaRepositoryPort = pessoaRepositoryPort;
        System.out.println("PessoaService created with repository: " + (pessoaRepositoryPort != null));
    }

    @Override
    public PessoaResponseDto createPessoa(PessoaRequestDto requestDto) {
        // Create and validate domain model (rich model handles validation)
        Pessoa pessoa = new Pessoa(
                requestDto.getNomeCompleto(),
                requestDto.getCpf(),
                requestDto.getDataNascimento(),
                requestDto.getEmail(),
                requestDto.getTelefone());

        // Persist via output port
        Pessoa savedPessoa = pessoaRepositoryPort.save(pessoa);

        // Return response DTO
        return new PessoaResponseDto(
                savedPessoa.getId(),
                savedPessoa.getNomeCompleto(),
                savedPessoa.getDataNascimento(),
                savedPessoa.getCpf(),
                savedPessoa.getEmail(),
                savedPessoa.getTelefone());
    }
}
