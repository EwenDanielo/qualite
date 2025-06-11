import { Book } from '../models/book.model';

export const BOOKS_MOCK: Book[] = [
	{ id: 1, title: 'Clean Code', author: 'Robert C. Martin', isbn: '9780132350884', stock: 3 },
	{ id: 2, title: 'The Pragmatic Programmer', author: 'Andrew Hunt', isbn: '9780201616224', stock: 5 },
	{ id: 3, title: 'Refactoring', author: 'Martin Fowler', isbn: '9780201485677', stock: 2 },
	{ id: 4, title: 'Design Patterns', author: 'Erich Gamma', isbn: '9780201633610', stock: 4 },
	{ id: 5, title: 'Domain-Driven Design', author: 'Eric Evans', isbn: '9780321125217', stock: 2 },
	{ id: 6, title: 'Working Effectively with Legacy Code', author: 'Michael Feathers', isbn: '9780131177055', stock: 1 },
	{ id: 7, title: 'Test-Driven Development', author: 'Kent Beck', isbn: '9780321146533', stock: 3 },
	{ id: 8, title: 'Continuous Delivery', author: 'Jez Humble', isbn: '9780321601919', stock: 2 },
	{ id: 9, title: 'You Don’t Know JS', author: 'Kyle Simpson', isbn: '9781491904244', stock: 6 },
	{ id: 10, title: 'Introduction to Algorithms', author: 'Thomas H. Cormen', isbn: '9780262033848', stock: 2 }
];