import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Pages/home/home.component';
import { PageProductComponent } from './Pages/page-product/page-product.component';
import { FormNewProductComponent } from './Components/form-new-product/form-new-product.component';
import { FormUpdateProductComponent } from './Components/form-update-product/form-update-product.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'product', component: PageProductComponent,  children: [
    { path: 'insert', component: FormNewProductComponent, outlet: 'product' },
    { path: 'update', component: FormUpdateProductComponent, outlet: 'product' }
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
