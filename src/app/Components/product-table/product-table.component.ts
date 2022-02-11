import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/Model/Product';
import { ProductModel } from 'src/app/Service/Product.model';

@Component({
  selector: 'app-product-table',
  templateUrl: './product-table.component.html',
  styleUrls: ['./product-table.component.css']
})
export class ProductTableComponent implements OnInit {

  products: Array<Product> = [];

  constructor(private productModel: ProductModel) {}

  delete(prd: any): void {
    this.productModel.delete(prd.id).subscribe(data => {
      alert('Code: ' + data.code + '\n' + 'Description: ' + data.description);
      if (data.code.includes('ok_')) {
        this.populateTable();
      }
    });
  }

  ngOnInit(): void {
    this.populateTable();
  }

  populateTable(): void {
    this.productModel.findAll().subscribe(data => {
      this.products = data;
    });
  }

}
