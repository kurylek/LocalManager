import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PrinterListComponent } from './components/printer-list/printer-list.component';
import { OrdersComponent } from './components/orders/orders.component';

const routes: Routes = [
  { path: '', component: OrdersComponent },
  { path: 'printers', component: PrinterListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
