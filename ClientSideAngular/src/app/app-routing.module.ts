import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomersListComponent } from './components/customers-list/customers-list.component';
import { CustomerDetailComponent } from './components/customer-detail/customer-detail.component';
import { CustomerAddComponent } from './components/customer-add/customer-add.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'customers-list' },
  { path: 'customers-list', component: CustomersListComponent },
  { path: 'customer-add', component: CustomerAddComponent },
  { path: 'customer-edit/:id', component: CustomerDetailComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
