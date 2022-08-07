import { Component, NgZone, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Customer } from 'src/app/models/customer';
import { CrudService } from 'src/app/services/crud.service';


@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.css']
})
export class CustomersListComponent implements OnInit {
	
	CustomersList: any = [];
	searchText;

  constructor(
  private router: Router,
  private ngZone: NgZone,
  private crudService: CrudService
  ) { }

  ngOnInit(): void {
	  this.crudService.getCustomers().subscribe(res => {
      console.log(res);
      this.CustomersList = res;
    });
  }
  
  delete(id:string, i:number) {
    console.log(id);
    if(window.confirm('Delete?')) {
      this.crudService.deleteCustomer(id).subscribe((res) => {
		  console.log('Deleted!')
		  window.location.reload();
		  this.ngZone.run(() => this.router.navigateByUrl('/customers-list'))
    },(err) => {
        console.log(err);
    });
  }
  }
}
