import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrinterListComponent } from './printer-list.component';
import { MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';

@NgModule({
  declarations: [PrinterListComponent],
  imports: [CommonModule, MatTableModule, MatSortModule],
  exports: [PrinterListComponent],
})
export class PrinterListModule {}
