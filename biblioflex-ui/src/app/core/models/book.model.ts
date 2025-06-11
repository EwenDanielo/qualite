export interface Book {
	id?: number;
	title: string;
	author: string;
	isbn: string;
	stock: number;
	description?: string;
	publishedDate?: Date;
	available?: boolean;
}