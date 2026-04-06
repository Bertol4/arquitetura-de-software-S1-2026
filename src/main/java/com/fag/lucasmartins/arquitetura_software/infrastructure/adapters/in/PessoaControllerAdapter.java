package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.PessoaUseCasePort;
import com.fag.lucasmartins.arquitetura_software.dto.PessoaRequestDto;
import com.fag.lucasmartins.arquitetura_software.dto.PessoaResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
public class PessoaControllerAdapter {

    private final PessoaUseCasePort pessoaUseCasePort;

    public PessoaControllerAdapter(PessoaUseCasePort pessoaUseCasePort) {
        this.pessoaUseCasePort = pessoaUseCasePort;
    }

    @PostMapping
    public ResponseEntity<PessoaResponseDto> cadastrarPessoa(@RequestBody PessoaRequestDto requestDto) {
        try {
            PessoaResponseDto response = pessoaUseCasePort.createPessoa(requestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
