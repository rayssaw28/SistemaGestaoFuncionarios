package com.sistemaGestao.sistemaGestaoFuncionario.repository;

import com.sistemaGestao.sistemaGestaoFuncionario.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findByEmail(String email);
    List<Funcionario> findByCargoContainingIgnoreCase(String cargo);
    List<Funcionario> findByAtivo(Boolean ativo);
    List<Funcionario> findByCargoContainingIgnoreCaseAndAtivo(String cargo, Boolean ativo);
}
