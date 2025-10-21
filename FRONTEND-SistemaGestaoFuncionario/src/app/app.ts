import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';

@Component({
selector: 'app-root',
standalone: true,
imports: [CommonModule, RouterOutlet],
// O template contém apenas o router-outlet, que renderiza os componentes da rota
template: '<router-outlet></router-outlet>',
// Aponta para o ficheiro de estilo correto
styleUrl: './app.css'
})
export class AppComponent {
title = 'frontend';
}

