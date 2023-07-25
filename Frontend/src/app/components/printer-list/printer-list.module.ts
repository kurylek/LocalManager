import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrinterListComponent } from './printer-list.component';
import { MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';

@NgModule({
  declarations: [PrinterListComponent],
  imports: [
    CommonModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    MatInputModule,
    MatFormFieldModule,
  ],
  exports: [PrinterListComponent],
})
export class PrinterListModule {}
