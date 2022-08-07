import { Component, NgZone, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CrudService } from 'src/app/services/crud.service';
import { FormGroup, FormBuilder } from "@angular/forms";

@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.css']
})
export class CustomerAddComponent implements OnInit {

	customerForm: FormGroup;

  constructor(
	public formBuilder: FormBuilder,
    private router: Router,
    private ngZone: NgZone,
    private crudService: CrudService) {
    this.customerForm = this.formBuilder.group({
      name: [''],
      surname: [''],
	  birthDate: [''],
	  telNumber: [''],
      email: ['']
    });
	}

  ngOnInit(): void {
  }

  onSubmit(): any {
    this.crudService.AddCustomer(this.customerForm.value)
    .subscribe(() => {
        console.log('Data added successfully!')
        this.ngZone.run(() => this.router.navigateByUrl('/customers-list'))
      }, (err) => {
        console.log(err);
    });
  }
  
}
