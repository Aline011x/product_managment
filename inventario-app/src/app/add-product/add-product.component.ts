import { ChangeDetectionStrategy, Component } from '@angular/core';
import { Product } from '../product';
import { Router } from '@angular/router';
import { ProductService } from '../product.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrl: './add-product.component.css',
  standalone: true,
  imports: [FormsModule],
})
export class AddProductComponent {
  product: Product = new Product();

  constructor(private productService : ProductService, 
    private enrutable: Router){}

  onSubmit(){
    this.saveProduct();
  }

  saveProduct(){
    this.productService.addProduct(this.product).subscribe(
      {
        next: (data) => {
          this.goListProduct();
        },
        error: (err: any ) => { console.log(err)}}
    );}

    goListProduct(){
    this.enrutable.navigate(['/products']);
  }

}
