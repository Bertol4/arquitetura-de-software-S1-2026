package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out;

import com.fag.lucasmartins.arquitetura_software.application.ports.out.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.domain.pessoa.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.UUID;

@Repository
public class PessoaRepositoryAdapter implements PessoaRepositoryPort {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PessoaRepositoryAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (id, nome_completo, cpf, data_nascimento, email, telefone) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pessoa.getId().toString());
            ps.setString(2, pessoa.getNomeCompleto());
            ps.setDate(3, java.sql.Date.valueOf(pessoa.getDataNascimento()));
            ps.setString(4, pessoa.getCpf());
            ps.setString(5, pessoa.getEmail());
            ps.setString(6, pessoa.getTelefone());
            return ps;
        });
        return pessoa;
    }
}
