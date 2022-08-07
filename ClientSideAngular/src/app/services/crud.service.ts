import { Injectable } from '@angular/core';
import { catchError, map } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Customer } from 'src/app/models/customer';

@Injectable({
  providedIn: 'root'
})
export class CrudService {

	host = 'http://localhost:8080/';
	customersParam = 'customers/';
	
	httpHeaders = new HttpHeaders().set('Content-Type', 'application/json');
	
  constructor(private httpClient: HttpClient) { }
  
  //getAll
  getCustomers() {
	return this.httpClient.get(this.host + this.customersParam);
  }
  
  //get one
  GetCustomer (id: any): Observable<any> {
    let URL = `${this.host + this.customersParam}/${id}`;
    return this.httpClient.get(URL, { headers: this.httpHeaders })
      .pipe(map((res: any) => {
        return res || {}
      }),
        catchError(this.handleError)
      )
  }
  
  //add
  AddCustomer (data: Customer): Observable<any> {
    return this.httpClient.post(this.host + this.customersParam, data)
      .pipe(
        catchError(this.handleError)
      )
  }
  
  //update
  updateCustomer (id: string, data: any): Observable<any> {
    let URL = `${this.host + this.customersParam}/${id}`;
    return this.httpClient.put(URL, data, { headers: this.httpHeaders })
      .pipe(
        catchError(this.handleError)
      )
  }
  
  //delete
  deleteCustomer (id: string): Observable<any> {
    let URL = `${this.host + this.customersParam}/${id}`;
    return this.httpClient.delete(URL, { headers: this.httpHeaders }).pipe(
      catchError(this.handleError)
    )
  }
  
  
  //error
  handleError (error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Handle client error
      errorMessage = error.error.message;
    } else {
      // Handle server error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }
}
