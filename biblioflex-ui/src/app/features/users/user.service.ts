import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { User } from '../../core/models/user.model';
import { USERS_MOCK } from '../../core/mocks/user-mock';

@Injectable({
  providedIn: 'root'
})
export class UserService {

    getUsers = (): Observable<User[]> => 
      of(USERS_MOCK);

    getUserById = (id: number): Observable<User | undefined> => 
      of(USERS_MOCK.find(user => user.id === id));

}