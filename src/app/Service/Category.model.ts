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

    insert(category: Category): Observable<any> {
      return this.http.post<any>(this.baseUrl + 'insert', category);
    }

    update(category: Category): Observable<any> {
      return this.http.put<any>(this.baseUrl + 'update', category);
    }

    delete(idCategory: any): Observable<any> {
      return this.http.delete<any>(this.baseUrl + 'delete', idCategory);
    }

}
