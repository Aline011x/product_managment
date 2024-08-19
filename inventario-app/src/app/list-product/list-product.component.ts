import { Component } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrl: './list-product.component.css',
  standalone: true,
  imports: [CommonModule]
})
export class ListProductComponent {

  products: Product[];

  constructor(private productService: ProductService, private enrutable: Router) {}

  ngOnInit(){
    this.listProducts();
  }

  private listProducts(){
    this.productService.listProducts().subscribe(data => { this.products = data;});
  }

  editProduct(id: number){
    this.enrutable.navigate(['editProduct', id]);

  }

  delProduct(id: number){
    this.productService.delProduct(id).subscribe(
     { 
      next: (data) =>  this.listProducts(),
      error: (error) => console.error('Error: ', error)
      }  
    );
  }

}
