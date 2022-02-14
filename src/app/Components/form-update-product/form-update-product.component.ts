import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Params, ActivatedRoute } from '@angular/router';

import { Category } from 'src/app/Model/Category';
import { Product } from 'src/app/Model/Product';

import { ProductModel } from 'src/app/Service/Product.model';
import { CategoryModel } from 'src/app/Service/Category.model';

@Component({
  selector: 'app-form-update-product',
  templateUrl: './form-update-product.component.html',
  styleUrls: ['./form-update-product.component.css']
})
export class FormUpdateProductComponent implements OnInit {

  categories: Array<Category> = [];
  products: Array<Product> = [];
  product = {} as Product;
  isDisabled: Boolean = true;

    productForm = new FormGroup({
      name: new FormControl({ value: '', disabled: this.isDisabled }, Validators.required),
      price: new FormControl({ value: '', disabled: this.isDisabled }, Validators.required),
      quantity: new FormControl({ value: '', disabled: this.isDisabled }, Validators.required),
      categoryId: new FormControl({ value: '', disabled: this.isDisabled }, Validators.required)
    });

    constructor(private categoryModel: CategoryModel, private productModel: ProductModel, private route:  ActivatedRoute) { }

    update(): void {
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

      this.productModel.update(this.product).subscribe(data => {
        alert('Code: ' + data.code + '\n' + 'Description: ' + data.description);
      });
    }

    ngOnInit(): void {
      this.categoryModel.findAll().subscribe(data => {
        this.categories = data;
      });
      this.productModel.findAll().subscribe(data => {
        this.products = data;

        this.route.queryParams.subscribe((params: any) => {
          if ( params != null && params != undefined)
            var prod = this.products.find(x => x.id == params.id);
            if (prod != null && prod != undefined) {
              this.productForm.setValue({
                name: prod.name,
                price: prod.price,
                quantity: prod.quantity,
                categoryId: prod.category.id
              });
            this.productForm.enable();
          }
        });
      });
    }

  onClick(event: any) : void {
    var prod = this.products.find(x => x.id == event.target.value);

    if (prod != null) {
      this.productForm.setValue({
        name: prod.name,
        price: prod.price,
        quantity: prod.quantity,
        categoryId: prod.category.id
      });
      this.productForm.enable();
    }
  }
}
