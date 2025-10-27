package com.senai.jonatas.funcionarios.service;

import com.senai.jonatas.funcionarios.dto.DepartamentoRequest;
import com.senai.jonatas.funcionarios.dto.DepartamentoResponse;
import com.senai.jonatas.funcionarios.entity.Departamento;
import com.senai.jonatas.funcionarios.exceptions.BusinessException;
import com.senai.jonatas.funcionarios.exceptions.ResourceNotFoundException;
import com.senai.jonatas.funcionarios.mapper.DepartamentoMapper;
import com.senai.jonatas.funcionarios.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository repository;

    public List<DepartamentoResponse> listarTodos() {
        return repository.findAll()
                .stream()
                .map(DepartamentoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<DepartamentoResponse> listarAtivos() {
        return repository.findByAtivoTrue()
                .stream()
                .map(DepartamentoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public DepartamentoResponse criar(DepartamentoRequest req) {
        if (repository.existsByNome(req.getNome())) {
            throw new BusinessException("Já existe um departamento com este nome.");
        }

        Departamento departamento = DepartamentoMapper.toEntity(req);
        repository.save(departamento);
        return DepartamentoMapper.toResponse(departamento);
    }

    public DepartamentoResponse atualizar(Long id, DepartamentoRequest req) {
        Departamento departamento = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Departamento não encontrado."));

        if (!departamento.getNome().equals(req.getNome()) && repository.existsByNome(req.getNome())) {
            throw new BusinessException("Já existe um departamento com este nome.");
        }

        DepartamentoMapper.copyToEntity(req, departamento);
        repository.save(departamento);

        return DepartamentoMapper.toResponse(departamento);
    }

    public void inativar(Long id) {
        Departamento departamento = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Departamento não encontrado."));
        departamento.setAtivo(false);
        repository.save(departamento);
    }
}