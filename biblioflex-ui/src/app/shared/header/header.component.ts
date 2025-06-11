import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterModule],
  template: `
    <header class="app-header">
      <nav class="nav-bar">
        <span class="logo">📚 BiblioFlex</span>
        <a routerLink="/books" routerLinkActive="active-link">Livres</a>
        <a routerLink="/users" routerLinkActive="active-link">Clients</a>
      </nav>
    </header>
  `,
  styleUrls: ['./header.component.scss']
})

export class HeaderComponent {}