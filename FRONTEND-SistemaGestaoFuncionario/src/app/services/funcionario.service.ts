import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Funcionario } from '../models/funcionario';

@Injectable({
providedIn: 'root'
})
export class FuncionarioService {

private readonly apiUrl = 'http://localhost:8080/api/funcionarios';

constructor(private http: HttpClient) { }

  getFuncionarios(cargo?: string, status?: boolean): Observable<Funcionario[]> {
    let params = new HttpParams();
    if (cargo) {
      params = params.set('cargo', cargo);
    }
    if (status !== undefined && status !== null) {
      params = params.set('ativo', status.toString());
    }
    return this.http.get<Funcionario[]>(this.apiUrl, { params });
  }

  getFuncionarioById(id: number): Observable<Funcionario> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<Funcionario>(url);
  }

  salvar(funcionario: Funcionario): Observable<Funcionario> {
    return this.http.post<Funcionario>(this.apiUrl, funcionario);
  }

  atualizar(id: number, funcionario: Funcionario): Observable<Funcionario> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.put<Funcionario>(url, funcionario);
  }

  inativar(id: number): Observable<void> {
    const url = `${this.apiUrl}/${id}/inativar`;
    return this.http.patch<void>(url, null);
  }
}

