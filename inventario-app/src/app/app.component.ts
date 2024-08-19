import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { ListProductComponent } from "./list-product/list-product.component";
import { AddProductComponent } from './add-product/add-product.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ListProductComponent, RouterLink, AddProductComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'app';
}

