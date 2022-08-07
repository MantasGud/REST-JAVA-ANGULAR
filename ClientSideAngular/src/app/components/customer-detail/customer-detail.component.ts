import { Component, NgZone, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CrudService } from 'src/app/services/crud.service';
import { FormGroup, FormBuilder } from "@angular/forms";
import { Customer } from 'src/app/models/customer';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {

  getId: any;
  updateForm: FormGroup;
  customer : Customer;
  

  constructor(
   public formBuilder: FormBuilder,
    private router: Router,
	private ngZone: NgZone,
    private activatedRoute: ActivatedRoute,
    private crudService: CrudService
  ) { 
  this.getId = this.activatedRoute.snapshot.paramMap.get('id');

      this.crudService.GetCustomer(this.getId).subscribe(res => {
        this.updateForm.setValue({
          name: res['name'],
          surname: res['surname'],
		  birthDate: res['birthDate'],
		  telNumber: res['telNumber'],
          email: res['email']
        });
      });

      this.updateForm = this.formBuilder.group({
        name: [''],
        surname: [''],
		birthDate: [''],
		telNumber: [''],
        email: ['']
      });
	  
	this.customer = new Customer();
  }

  ngOnInit(): void {
  }
  
  onUpdate(): any {
    this.crudService.updateCustomer(this.getId, this.updateForm.value)
    .subscribe(() => {
        console.log('Data updated successfully!')
        this.ngZone.run(() => this.router.navigateByUrl('/customers-list'))
      }, (err) => {
        console.log(err);
    });
  }

}
