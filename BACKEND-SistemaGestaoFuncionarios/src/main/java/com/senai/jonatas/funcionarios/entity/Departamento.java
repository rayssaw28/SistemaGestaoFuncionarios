package com.senai.jonatas.funcionarios.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String sigla;

    @Column(nullable = false)
    private Boolean ativo = true;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Funcionario> funcionarios = new ArrayList<>();
}