import { Routes } from '@angular/router';
import { FuncionarioListComponent } from './components/funcionario-list/funcionario-list';

export const routes: Routes = [
// Quando o utilizador acede à rota raiz (''), redireciona para '/funcionarios'
{
path: '',
redirectTo: '/funcionarios',
pathMatch: 'full'
},
// Quando acede a '/funcionarios', carrega o FuncionarioListComponent
{
path: 'funcionarios',
component: FuncionarioListComponent
}
// TODO: Adicionar rotas para o formulário de criação e edição aqui
];

