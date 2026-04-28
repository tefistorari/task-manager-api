export type Priority = 'LOW' | 'MEDIUM' | 'HIGH';

export interface Task {
    id?: number;
    title: string;
    description?: string;
    completed?: boolean;
    priority: Priority;
    createdAt?: string;
}