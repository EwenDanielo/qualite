import { ComponentFixture, TestBed } from '@angular/core/testing';
import { BookListComponent } from './book-list.component';
import { FormsModule } from '@angular/forms';
import { By } from '@angular/platform-browser';

describe('BookListComponent', () => {
  let component: BookListComponent;
  let fixture: ComponentFixture<BookListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BookListComponent, FormsModule]
    }).compileComponents();

    fixture = TestBed.createComponent(BookListComponent);
    component = fixture.componentInstance;
    // Mock data
    component.books = [
      { id: 1, title: 'Livre 1', author: 'Auteur 1', isbn: '123', publishedDate: new Date(), available: true },
      { id: 2, title: 'Livre 2', author: 'Auteur 2', isbn: '456', publishedDate: new Date(), available: false }
    ];
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display a list of books', () => {
    const cards = fixture.debugElement.queryAll(By.css('.book-card'));
    expect(cards.length).toBe(2);
    expect(cards[0].nativeElement.textContent).toContain('Livre 1');
    expect(cards[1].nativeElement.textContent).toContain('Livre 2');
  });

  it('should display "Aucun livre à afficher." when list is empty', () => {
    component.books = [];
    fixture.detectChanges();
    const emptyMsg = fixture.debugElement.query(By.css('.empty-list'));
    expect(emptyMsg).toBeTruthy();
    expect(emptyMsg.nativeElement.textContent).toContain('Aucun livre à afficher.');
  });

  it('should filter books by search', () => {
    component.search = 'Livre 1';
    fixture.detectChanges();
    const cards = fixture.debugElement.queryAll(By.css('.book-card'));
    expect(cards.length).toBe(1);
    expect(cards[0].nativeElement.textContent).toContain('Livre 1');
  });

  it('should call goToBook when a book card is clicked', () => {
    spyOn(component, 'goToBook');
    const card = fixture.debugElement.query(By.css('.book-card'));
    card.triggerEventHandler('click', null);
    expect(component.goToBook).toHaveBeenCalled();
  });
});
