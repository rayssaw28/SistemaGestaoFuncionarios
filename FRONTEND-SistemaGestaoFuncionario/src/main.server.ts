import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app';

const config = {
...appConfig
};

export default function bootstrap() {
  return bootstrapApplication(AppComponent, config);
}
