import { Component } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit-product',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './edit-product.component.html',
  styleUrl: './edit-product.component.css'
})
export class EditProductComponent {

  product: Product = new Product();
  id: number;

  constructor(private productService: ProductService, private route: ActivatedRoute, 
    private enrutable: Router) {}

  ngOnInit(){
    this.id = this.route.snapshot.params['id'];
    this.productService.getProductById(this.id).subscribe(
      {
        next: (data) => { this.product = data; },
        error: (error: any) => console.error('Error:', error)
      }
    );
  }

  onSubmit(){
   this.saveProduct()
  }
  saveProduct(){
    this.productService.editProduct(this.id, this.product).subscribe(
      {
        next: (data) => this.goListProduct(),
        error: (error) => console.error('Error:', error)
      }
    );
  }

  goListProduct(){
    this.enrutable.navigate(['/products']);
  }

}
