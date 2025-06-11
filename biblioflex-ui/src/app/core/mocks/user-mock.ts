import { User } from "../models/user.model";

export const USERS_MOCK: User[] = [
    { id: 1, firstName: 'Alice', lastName: 'Martin', email: 'alice@example.com', role: 'USER', isActive: true },
    { id: 2, firstName: 'Bob', lastName: 'Dupont', email: 'bob@example.com', role: 'ADMIN', isActive: true },
    { id: 3, firstName: 'Charlie', lastName: 'Durand', email: 'charlie@example.com', role: 'USER', isActive: false },
    { id: 4, firstName: 'David', lastName: 'Bernard', email: 'david@example.com', role: 'USER', isActive: true },
    { id: 5, firstName: 'Eve', lastName: 'Petit', email: 'eve@example.com', role: 'USER', isActive: true }
];