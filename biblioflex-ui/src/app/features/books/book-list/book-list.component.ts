import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AgGridModule } from 'ag-grid-angular';
import { BookService } from '../book.service';
import { Book } from '../../../core/models/book.model';
import { ColDef } from 'ag-grid-community';

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [CommonModule, AgGridModule],
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {
  books: Book[] = [];

  columnDefs: ColDef[] = [
    { field: 'title', headerName: 'Titre' },
    { field: 'author', headerName: 'Auteur' },
    { field: 'isbn', headerName: 'ISBN' },
    { field: 'stock', headerName: 'Stock' }
  ];

  constructor(private bookService: BookService) {}

  ngOnInit(): void {
    this.bookService.getBooks().subscribe(books => this.books = books);
  }
}