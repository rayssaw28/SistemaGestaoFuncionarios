import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
// Importa o componente principal do ficheiro app.ts
import { AppComponent } from './app/app';

// Inicia a aplicação Angular com o componente principal e as configurações
bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));

