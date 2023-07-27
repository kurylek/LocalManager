import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PrinterListComponent } from './components/printer-list/printer-list.component';
import { OrdersComponent } from './components/orders/orders.component';
import { ComputerListComponent } from './components/computer-list/computer-list.component';

const routes: Routes = [
  { path: '', component: OrdersComponent },
  { path: 'printers', component: PrinterListComponent },
  { path: 'computers', component: ComputerListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
