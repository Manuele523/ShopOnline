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

  ngOnInit(): void {
    this.productModel.getProduts().subscribe(data => {
      this.products = data;
    });
  }

}
