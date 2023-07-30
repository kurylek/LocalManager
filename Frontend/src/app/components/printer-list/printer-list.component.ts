import { Component, ViewChild } from '@angular/core';
import { PrintersService } from '../../services/printers.service';
import { Printer } from '../../model/printer.model';
import { MatTableDataSource } from '@angular/material/table';
import { LiveAnnouncer } from '@angular/cdk/a11y';
import { MatSort, Sort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

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
  printerFormGroup!: FormGroup;
  printerTypes: string[] = ['COLOR', 'BLACK'];
  manufacturers: string[] = ['HP', 'KONICA_MINOLTA'];

  constructor(
    private printerService: PrintersService,
    private _liveAnnouncer: LiveAnnouncer,
    private fb: FormBuilder,
    private modalService: NgbModal
  ) {}

  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatPaginator) paginator: any = MatPaginator;

  ngOnInit(): void {
    this.getPrintersList();
    this.printerFormGroup = this.fb.group({
      ipAddress: ['', Validators.required],
      serialNumber: ['', Validators.required],
      productNumber: ['', Validators.required],
      manufacturer: ['', Validators.required],
      description: [''],
      printerType: ['', Validators.required],
    });
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

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  getModal(content: any) {
    this.modalService.open(content, { size: 'xl' });
  }

  onCloseModal(modal: any) {
    modal.close();
    this.printerFormGroup.reset();
  }

  onSaveModal(modal: any) {
    if (this.printerFormGroup.invalid) return;
    this.printerService.savePrinter(this.printerFormGroup.value).subscribe({
      next: () => {
        this.getPrintersList();
        this.printerFormGroup.reset();
        modal.close();
      },
      error: (err) => {
        console.log(err.message);
      },
    });
  }
}
