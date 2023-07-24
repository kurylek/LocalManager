import { Component, ViewChild } from '@angular/core';
import { PrintersService } from '../../services/printers.service';
import { Printer } from '../../model/printer.model';
import { MatTableDataSource } from '@angular/material/table';
import { LiveAnnouncer } from '@angular/cdk/a11y';
import { MatSort, Sort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';

@Component({
  selector: 'app-printer-list',
  templateUrl: './printer-list.component.html',
  styleUrls: ['./printer-list.component.css'],
})
export class PrinterListComponent {
  dataSource = new MatTableDataSource<Printer>();
  displayedColumns: string[] = [
    'deviceId',
    'ipAddress',
    'serialNumber',
    'productNumber',
    'manufacturer',
    'description',
    'printerType',
    'printerStatus',
    'actions',
  ];

  constructor(
    private printerService: PrintersService,
    private _liveAnnouncer: LiveAnnouncer
  ) {}

  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatPaginator) paginator: any = MatPaginator;

  ngOnInit(): void {
    this.getPrintersList();
  }

  getPrintersList(): void {
    this.printerService.getPrinters().subscribe(
      (response) => {
        this.dataSource = new MatTableDataSource<Printer>(response);
        this.dataSource.sort = this.sort;
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

  announceSortChange(sortState: Sort) {
    if (sortState.direction) {
      this._liveAnnouncer.announce(`Sorted ${sortState.direction}ending`);
    } else {
      this._liveAnnouncer.announce('Sorting cleared');
    }
  }
}
