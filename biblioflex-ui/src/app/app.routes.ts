import { Routes } from '@angular/router';
import { BookListComponent } from './features/books/book-list/book-list.component';
import { BookPageComponent } from './features/books/book-page/book-page.component';
import { UserListComponent } from './features/users/user-list/user-list.component';
import { UserPageComponent } from './features/users/user-page/user-page.component';

export const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'books' },
  { path: 'books', component: BookListComponent, pathMatch: 'full' },
  { path: 'books/:id', component: BookPageComponent },
  { path: 'users', component: UserListComponent, pathMatch: 'full' },
  { path: 'users/:id', component: UserPageComponent }
];