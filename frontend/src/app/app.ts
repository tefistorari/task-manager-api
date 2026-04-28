import { CommonModule } from '@angular/common';
import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { Priority, Task } from './models/Task';
import { TaskService } from './services/task-service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CommonModule, FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
  tasks: Task[] = [];
  filter: 'ALL' | 'PENDING' | 'COMPLETED' = 'ALL';
  showForm = false;
  newTask: Partial<Task> = { title: '', description: '', priority: 'MEDIUM' };
  priorities: Priority[] = ['LOW', 'MEDIUM', 'HIGH'];

  constructor(private taskService: TaskService) {}

  ngOnInit() { this.load(); }

  load() {
    const obs = this.filter === 'ALL' ? this.taskService.getAll()
      : this.filter === 'PENDING' ? this.taskService.getPending()
      : this.taskService.getCompleted();
    obs.subscribe(t => this.tasks = t);
  }

  setFilter(f: string) { this.filter = f as typeof this.filter;
    this.load();
   }

  submit() {
    if (!this.newTask.title?.trim()) return;
    this.taskService.create(this.newTask).subscribe(() => {
      this.newTask = { title: '', description: '', priority: 'MEDIUM' };
      this.showForm = false;
      this.load();
    });
  }

  complete(id: number) { this.taskService.complete(id).subscribe(() => this.load()); }
  delete(id: number) { this.taskService.delete(id).subscribe(() => this.load()); }

  priorityClass(p?: Priority) {
    return { LOW: 'low', MEDIUM: 'med', HIGH: 'high' }[p ?? 'LOW'];
  }
}

