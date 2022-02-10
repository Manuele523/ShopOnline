import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../Model/Product';

@Injectable({
    providedIn: 'root'
})
export class ProductModel {

    baseUrl = 'http://localhost:8080/product/';

    constructor(private http: HttpClient) {
    }

    findAll(): Observable<Array<Product>> {
       return this.http.get<Array<Product>>(this.baseUrl + 'findAll');
    }

    insert(product: Product): Observable<any> {
      return this.http.post<any>(this.baseUrl + 'insert', product);
    }

    update(product: Product): Observable<any> {
      return this.http.post<any>(this.baseUrl + 'update', product);
    }

}
