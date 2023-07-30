import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Printer } from '../model/printer.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class PrintersService {
  constructor(private http: HttpClient) {}

  getPrinters(): Observable<Printer[]> {
    return this.http.get<Printer[]>(environment.apiURL + '/printer/all');
  }

  pingPrinter(printerId: number): Observable<Printer> {
    return this.http.get<Printer>(
      environment.apiURL + '/printer/ping/' + printerId
    );
  }

  savePrinter(printer: Printer): Observable<Printer> {
    return this.http.post<Printer>(
      environment.apiURL + '/printer/save',
      printer
    );
  }
}
