import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { BookService } from '../book.service';
import { Book } from '../../../core/models/book.model';
import { HeaderComponent } from '../../../shared/header/header.component';

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {
  books: Book[] = [];
  search: string = '';

  constructor(private bookService: BookService, private router: Router) {}

  ngOnInit(): void {
    this.bookService.getBooks().subscribe(books => this.books = books);
  }

  get filteredBooks(): Book[] {
    if (!this.search) return this.books;
    const s = this.search.toLowerCase();
    return this.books.filter(
      b =>
        b.title.toLowerCase().includes(s) ||
        b.author.toLowerCase().includes(s) ||
        b.isbn.toLowerCase().includes(s)
    );
  }

  goToBook(book: Book) {
    this.router.navigate(['/books', book.id]);
  }

  // Not used
  deleteBook(book: Book) {
    this.bookService.deleteBookById(book.id!);
    this.books = this.books.filter(b => b.id !== book.id);
  }
}