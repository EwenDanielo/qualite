import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Book } from '../../core/models/book.model';
import { BOOKS_MOCK } from '../../core/mocks/book-mock';

@Injectable({
  providedIn: 'root'
})
export class BookService {

    getBooks = (): Observable<Book[]> => 
      of(BOOKS_MOCK);

    getBookById = (id: number): Observable<Book | undefined> => 
      of(BOOKS_MOCK.find(book => book.id === id));

    deleteBookById = (id: number): void => {
      const index = BOOKS_MOCK.findIndex(book => book.id === id);
      if (index !== -1) {
        BOOKS_MOCK.splice(index, 1);
      }
    }
}