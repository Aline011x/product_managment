import { Routes } from '@angular/router';
import { Component } from '@angular/core';
import { ListProductComponent } from './list-product/list-product.component';
import { AddProductComponent } from './add-product/add-product.component';
import { EditProductComponent } from './edit-product/edit-product.component';

export const routes: Routes = [
    {path: 'products', component: ListProductComponent }, 
    {path: '', redirectTo: 'products', pathMatch: 'full'},
    {path: 'addProduct', component: AddProductComponent},
    {path: 'editProduct/:id', component: EditProductComponent}
];
