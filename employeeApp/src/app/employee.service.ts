import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})

export class EmployeeService {
  private baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }

  // connect to backend and set GET request
  public getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.baseUrl}/employees`);
  }
}
