import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Task } from '../models/Task';

@Injectable({
  providedIn: 'root',
})

export class TaskService {
  private api = 'http://localhost:8080/tasks';
  
  constructor(private http: HttpClient) {}
   getAll(): Observable<Task[]> { 
      return this.http.get<Task[]>(this.api);
    }
    getPending(): Observable<Task[]> {
       return this.http.get<Task[]>(`${this.api}/pending`); 
      }
  getCompleted(): Observable<Task[]> {
     return this.http.get<Task[]>(`${this.api}/completed`); 
    }
  create(task: Partial<Task>): Observable<Task> {
     return this.http.post<Task>(this.api, task); 
    }
  complete(id: number): Observable<Task> { 
    return this.http.put<Task>(`${this.api}/${id}/complete`, {}); 
  }
  delete(id: number): Observable<void> { 
    return this.http.delete<void>(`${this.api}/${id}`); 
  }

}
