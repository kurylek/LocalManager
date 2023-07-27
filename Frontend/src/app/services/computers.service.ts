import { Injectable } from '@angular/core';
import { Computer } from '../model/computer.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ComputersService {
  constructor(private http: HttpClient) {}

  getComputers(): Observable<Computer[]> {
    return this.http.get<Computer[]>(environment.apiURL + '/computer/all');
  }
}
