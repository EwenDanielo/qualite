export interface User {
    id?: number;
    firstName?: string;
    lastName?: string;
    email?: string;
    password?: string;
    phone?: string;
    address?: string;
    city?: string;
    postalCode?: string;
    country?: string;
    role?: 'USER' | 'ADMIN';
    isActive?: boolean;
    createdAt?: Date;
    updatedAt?: Date;
    lastLogin?: Date;
    profilePicture?: string;
    bio?: string;
}