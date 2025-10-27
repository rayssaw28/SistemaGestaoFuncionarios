package com.senai.jonatas.funcionarios.dto;

import jakarta.validation.constraints.NotBlank;

public class DepartamentoRequest {

    @NotBlank(message = "O nome do departamento é obrigatório.")
    private String nome;

    @NotBlank(message = "A sigla do departamento é obrigatória.")
    private String sigla;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}