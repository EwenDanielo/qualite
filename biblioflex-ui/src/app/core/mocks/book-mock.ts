import { Book } from '../models/book.model';

export const BOOKS_MOCK: Book[] = [
	{ id: 1, title: 'Clean Code', author: 'Robert C. Martin', isbn: '9780132350884', publishedDate: new Date('2008-08-01'), available: true },
	{ id: 2, title: 'The Pragmatic Programmer', author: 'Andrew Hunt', isbn: '9780201616224', publishedDate: new Date('1999-10-20'), available: true },
	{ id: 3, title: 'Refactoring', author: 'Martin Fowler', isbn: '9780201485677', publishedDate: new Date('1999-07-08'), available: false },
	{ id: 4, title: 'Design Patterns', author: 'Erich Gamma', isbn: '9780201633610', publishedDate: new Date('1994-10-31'), available: true },
	{ id: 5, title: 'Domain-Driven Design', author: 'Eric Evans', isbn: '9780321125217', publishedDate: new Date('2003-08-30'), available: false },
	{ id: 6, title: 'Working Effectively with Legacy Code', author: 'Michael Feathers', isbn: '9780131177055', publishedDate: new Date('2004-09-22'), available: true },
	{ id: 7, title: 'Test-Driven Development', author: 'Kent Beck', isbn: '9780321146533', publishedDate: new Date('2002-11-08'), available: true },
	{ id: 8, title: 'Continuous Delivery', author: 'Jez Humble', isbn: '9780321601919', publishedDate: new Date('2010-07-27'), available: false },
	{ id: 9, title: 'You Don’t Know JS', author: 'Kyle Simpson', isbn: '9781491904244', publishedDate: new Date('2015-12-27'), available: true },
	{ id: 10, title: 'Introduction to Algorithms', author: 'Thomas H. Cormen', isbn: '9780262033848', publishedDate: new Date('2009-07-31'), available: true },
	{ id: 11, title: 'The Clean Coder', author: 'Robert C. Martin', isbn: '9780137081073', publishedDate: new Date('2011-05-13'), available: true },
	{ id: 12, title: 'Patterns of Enterprise Application Architecture', author: 'Martin Fowler', isbn: '9780321127426', publishedDate: new Date('2002-11-15'), available: false },
	{ id: 13, title: 'Structure and Interpretation of Computer Programs', author: 'Harold Abelson', isbn: '9780262510875', publishedDate: new Date('1996-07-25'), available: true },
	{ id: 14, title: 'Code Complete', author: 'Steve McConnell', isbn: '9780735619678', publishedDate: new Date('2004-06-09'), available: true },
	{ id: 15, title: 'The Mythical Man-Month', author: 'Frederick P. Brooks Jr.', isbn: '9780201835953', publishedDate: new Date('1995-08-12'), available: false },
	{ id: 16, title: 'Head First Design Patterns', author: 'Eric Freeman', isbn: '9780596007126', publishedDate: new Date('2004-10-25'), available: true },
	{ id: 17, title: 'JavaScript: The Good Parts', author: 'Douglas Crockford', isbn: '9780596517748', publishedDate: new Date('2008-05-01'), available: true },
	{ id: 18, title: 'Effective Java', author: 'Joshua Bloch', isbn: '9780134685991', publishedDate: new Date('2018-01-06'), available: false },
	{ id: 19, title: 'Programming Pearls', author: 'Jon Bentley', isbn: '9780201657883', publishedDate: new Date('1999-10-01'), available: true },
	{ id: 20, title: 'Algorithms', author: 'Robert Sedgewick', isbn: '9780321573513', publishedDate: new Date('2011-03-19'), available: true }
];