import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrinterListComponent } from './printer-list.component';

@NgModule({
  declarations: [PrinterListComponent],
  imports: [CommonModule],
  exports: [PrinterListComponent],
})
export class PrinterListModule {}
