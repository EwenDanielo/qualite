import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookService } from '../book.service';
import { Book } from '../../../core/models/book.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-book-page',
  templateUrl: './book-page.component.html',
  standalone: true,
  imports: [CommonModule],
  styleUrls: ['./book-page.component.scss'],
})
export class BookPageComponent implements OnInit {
  book$!: Observable<Book | undefined>;
  private bookId!: number;

  constructor(
    private route: ActivatedRoute,
    private bookService: BookService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.bookId = id;
    this.book$ = this.bookService.getBookById(id);
  }

  deleteBook(): void {
    this.bookService.deleteBookById(this.bookId);
    this.router.navigate(['/books']);
  }
}