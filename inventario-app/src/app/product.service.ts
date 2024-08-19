import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  //private urlbase = 'http://localhost:8080/inventario-app/products';
  private urlbase = 'http://localhost:8080/app/products';

  constructor(private httpclient: HttpClient) { }
  listProducts(): Observable<Product[]> {
      return this.httpclient.get<Product[]>(this.urlbase);
  }

  addProduct(product: Product): Observable<Object>{
    return this.httpclient.post(this.urlbase, product);
  }

  getProductById(id: number) {
    return this.httpclient.get<Product>(`${this.urlbase}/${id}`);
  }

  editProduct(id: number, product: Product): Observable<Object>{
    return this.httpclient.put(`${this.urlbase}/${id}`, product);
  }

  delProduct(id: number): Observable<Object>{
    return this.httpclient.delete(`${this.urlbase}/${id}`);
  }

}
