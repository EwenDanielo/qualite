export interface User {
    id?: number;
    firstName?: string;
    lastName?: string;
    email?: string;
    phone?: string;
    // Not used
    password?: string;
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