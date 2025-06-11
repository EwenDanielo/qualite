import { Book } from '../models/book.model';

export const BOOKS_MOCK: Book[] = [
	{ id: 1, title: 'Clean Code', author: 'Robert C. Martin', isbn: '9780132350884', stock: 3 },
	{ id: 2, title: 'The Pragmatic Programmer', author: 'Andrew Hunt', isbn: '9780201616224', stock: 5 },
	{ id: 3, title: 'Refactoring', author: 'Martin Fowler', isbn: '9780201485677', stock: 2 }
];