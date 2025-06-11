import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AgGridModule } from 'ag-grid-angular';
import { UserService } from '../user.service';
import { User } from '../../../core/models/user.model';
import { ColDef } from 'ag-grid-community';

@Component({
  selector: 'app-user-list',
  standalone: true,
  imports: [CommonModule, AgGridModule],
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {
  users: User[] = [];

  columnDefs: ColDef[] = [
    { field: 'firstName', headerName: 'Prénom' },
    { field: 'lastName', headerName: 'Nom' },
    { field: 'email', headerName: 'Email' },
    { field: 'phone', headerName: 'Téléphone' }
  ];

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.userService.getUsers().subscribe(users => this.users = users);
  }
}