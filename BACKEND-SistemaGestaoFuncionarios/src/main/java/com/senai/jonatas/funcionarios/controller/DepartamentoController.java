package com.senai.jonatas.funcionarios.controller;

import com.senai.jonatas.funcionarios.dto.DepartamentoRequest;
import com.senai.jonatas.funcionarios.dto.DepartamentoResponse;
import com.senai.jonatas.funcionarios.service.DepartamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @GetMapping
    public ResponseEntity<List<DepartamentoResponse>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<DepartamentoResponse>> listarAtivos() {
        return ResponseEntity.ok(service.listarAtivos());
    }

    @PostMapping
    public ResponseEntity<DepartamentoResponse> criar(@RequestBody @Valid DepartamentoRequest request) {
        DepartamentoResponse response = service.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoResponse> atualizar(@PathVariable Long id,
                                                          @RequestBody @Valid DepartamentoRequest request) {
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @PatchMapping("/{id}/inativar")
    public ResponseEntity<Void> inativar(@PathVariable Long id) {
        service.inativar(id);
        return ResponseEntity.noContent().build();
    }
}