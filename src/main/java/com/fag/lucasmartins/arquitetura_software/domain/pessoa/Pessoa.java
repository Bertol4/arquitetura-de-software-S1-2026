package com.fag.lucasmartins.arquitetura_software.domain.pessoa;

import java.time.LocalDate;
import java.util.UUID;

public class Pessoa {
    private final UUID id;
    private final String nomeCompleto;
    private final String cpf;
    private final LocalDate dataNascimento;
    private final String email;
    private final String telefone;

    public Pessoa(String nomeCompleto, String cpf, LocalDate dataNascimento, String email, String telefone) {
        this(UUID.randomUUID(), nomeCompleto, cpf == null ? null : cpf.replaceAll("[.\\-]", ""), dataNascimento, email, telefone);
    }

    private Pessoa(UUID id, String nomeCompleto, String cpf, LocalDate dataNascimento, String email, String telefone) {
        validate(nomeCompleto, cpf, dataNascimento, email, telefone);
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
    }

    private void validate(String nomeCompleto, String cpf, LocalDate dataNascimento, String email, String telefone) {
        if (nomeCompleto == null || nomeCompleto.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome completo é obrigatório.");
        }
        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF deve ter exatamente 11 caracteres.");
        }
        if (dataNascimento == null || java.time.Period.between(dataNascimento, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("Cliente deve ter no mínimo 18 anos.");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail deve ser obrigatório e conter '@'.");
        }
        if (telefone == null || telefone.length() != 11) {
            throw new IllegalArgumentException("Telefone deve ter exatamente 11 caracteres.");
        }
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
