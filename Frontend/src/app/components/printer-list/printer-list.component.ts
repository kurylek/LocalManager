import { Component } from '@angular/core';
import { PrintersService } from '../../services/printers.service';
import { Printer } from '../../model/printer.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-printer-list',
  templateUrl: './printer-list.component.html',
  styleUrls: ['./printer-list.component.css'],
})
export class PrinterListComponent {
  printersList!: Printer[];

  constructor(private printerService: PrintersService) {}

  ngOnInit(): void {
    this.getPrintersList();
  }

  getPrintersList(): void {
    this.printerService.getPrinters().subscribe(
      (response) => {
        this.printersList = response;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  pingPrinter(printerId: number): void {
    this.printerService.pingPrinter(printerId).subscribe(
      (response) => {
        this.getPrintersList();
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
