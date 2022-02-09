import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Pages/home/home.component';
import { NewProductComponent } from './Pages/new-product/new-product.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'newProduct', component: NewProductComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
