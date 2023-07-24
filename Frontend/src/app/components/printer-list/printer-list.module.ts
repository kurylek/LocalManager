import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrinterListComponent } from './printer-list.component';
import { MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';

@NgModule({
  declarations: [PrinterListComponent],
  imports: [CommonModule, MatTableModule, MatSortModule, MatPaginatorModule],
  exports: [PrinterListComponent],
})
export class PrinterListModule {}
