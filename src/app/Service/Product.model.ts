import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Product } from "../Model/Product";

@Injectable({
    providedIn: 'root'
})
export class ProductModel {

    baseUrl = 'http://localhost:8080/';

    constructor(private http: HttpClient) {
    }

    getProduts(): Observable<Array<Product>> {
       return this.http.get<Array<Product>>(this.baseUrl + 'findAllProduct');
    }

}