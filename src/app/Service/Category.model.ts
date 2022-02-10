import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../Model/Category';

@Injectable({
    providedIn: 'root'
})
export class CategoryModel {

    baseUrl = 'http://localhost:8080/category/';

    constructor(private http: HttpClient) {
    }

    findAll(): Observable<Array<Category>> {
       return this.http.get<Array<Category>>(this.baseUrl + 'findAll');
    }

}
