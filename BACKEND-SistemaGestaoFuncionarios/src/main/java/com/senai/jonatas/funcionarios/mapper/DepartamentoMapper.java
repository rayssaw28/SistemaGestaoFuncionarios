package com.senai.jonatas.funcionarios.mapper;

import com.senai.jonatas.funcionarios.dto.DepartamentoRequest;
import com.senai.jonatas.funcionarios.dto.DepartamentoResponse;
import com.senai.jonatas.funcionarios.entity.Departamento;

public final class DepartamentoMapper {

    private DepartamentoMapper() {
    }

    public static Departamento toEntity(DepartamentoRequest req) {
        return Departamento.builder()
                .nome(req.getNome())
                .sigla(req.getSigla())
                .ativo(true)
                .build();
    }

    public static void copyToEntity(DepartamentoRequest req, Departamento entity) {
        entity.setNome(req.getNome());
        entity.setSigla(req.getSigla());
    }

    public static DepartamentoResponse toResponse(Departamento entity) {
        return new DepartamentoResponse(entity);
    }
}
