package com.senai.jonatas.funcionarios.dto;

import com.senai.jonatas.funcionarios.entity.Departamento;

public class DepartamentoResponse {

    private Long id;
    private String nome;
    private String sigla;
    private Boolean ativo;

    public DepartamentoResponse() {}

    public DepartamentoResponse(Departamento d) {
        this.id = d.getId();
        this.nome = d.getNome();
        this.sigla = d.getSigla();
        this.ativo = d.getAtivo();
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getSigla() { return sigla; }
    public Boolean getAtivo() { return ativo; }
}