import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { Category } from 'src/app/Model/Category';
import { Product } from 'src/app/Model/Product';

import { ProductModel } from 'src/app/Service/Product.model';
import { CategoryModel } from 'src/app/Service/Category.model';

@Component({
  selector: 'app-form-new-product',
  templateUrl: './form-new-product.component.html',
  styleUrls: ['./form-new-product.component.css']
})
export class FormNewProductComponent implements OnInit {

  categories: Array<Category> = [];
  product = {} as Product;
  productForm = new FormGroup({
    name: new FormControl('', Validators.required),
    price: new FormControl('', Validators.required),
    quantity: new FormControl('', Validators.required),
    categoryId: new FormControl('', Validators.required),
  });

  constructor(private categoryModel: CategoryModel, private productModel: ProductModel) {}

  insert(){
    var formVal = this.productForm.value;
    var categ = this.categories.find((element: any) => element.id == formVal.categoryId);

    if (categ != null || categ!= undefined) {
      this.product = {
        name: formVal.name,
        price: formVal.price,
        quantity: formVal.quantity,
        category: {
            id: categ.id,
            name: categ.name
          }
      }
    }

    this.productModel.insert(this.product).subscribe(data => {
      console.log(data);
    });
  }

  ngOnInit(): void {
    this.categoryModel.findAll().subscribe(data => {
      this.categories = data;
    });
  }
}

