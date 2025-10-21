import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FuncionarioService } from '../../services/funcionario.service';
import { Funcionario } from '../../models/funcionario';

// Imports do PrimeNG
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { TagModule } from 'primeng/tag';
import { ProgressSpinnerModule } from 'primeng/progressspinner';
import { SelectModule } from 'primeng/select';
import { SelectButtonModule } from 'primeng/selectbutton';

@Component({
selector: 'app-funcionario-list',
standalone: true,
imports: [
CommonModule,
TableModule,
ButtonModule,
TagModule,
ProgressSpinnerModule,
SelectModule,
SelectButtonModule
],
// CORREÇÃO: Removido o '.component' para corresponder ao nome do seu arquivo
templateUrl: './funcionario-list.html',
styleUrl: './funcionario-list.css'
})
export class FuncionarioListComponent implements OnInit {

funcionarios: Funcionario[] = [];
carregando: boolean = false;

constructor(private funcionarioService: FuncionarioService) {}

  ngOnInit(): void {
    this.carregarFuncionarios();
  }

  carregarFuncionarios(): void {
    console.log("Carregando funcionários...");
    this.carregando = true;

    this.funcionarioService.getFuncionarios().subscribe({
      // CORREÇÃO: Adicionado o tipo 'Funcionario[]' ao parâmetro 'dados'
      next: (dados: Funcionario[]) => {
        this.funcionarios = dados;
        this.carregando = false;
        console.log("Funcionários carregados:", this.funcionarios);
      },
      // CORREÇÃO: Adicionado o tipo 'any' ao parâmetro 'erro'
      error: (erro: any) => {
        console.error("Erro ao carregar funcionários:", erro);
        this.carregando = false;
      }
    });
  }

  inativarFuncionario(id: number): void {
    if (confirm("Tem certeza que deseja inativar este funcionário?")) {
      this.funcionarioService.inativar(id).subscribe({
        next: () => {
          console.log("Funcionário inativado com sucesso.");
          this.carregarFuncionarios();
        },
        // CORREÇÃO: Adicionado o tipo 'any' ao parâmetro 'erro'
        error: (erro: any) => {
          console.error("Erro ao inativar funcionário:", erro);
        }
      });
    }
  }

  editarFuncionario(id: number): void {
    console.log("Editar funcionário com ID:", id);
    // TODO: Implementar navegação para o formulário de edição
  }
}
