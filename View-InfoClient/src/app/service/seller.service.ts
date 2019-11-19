import { Injectable } from '@angular/core';
import { Seller } from '../model/seller';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SellerService {

  selectSeller: Seller;
  sellers: {};
  readonly URL_API = 'http://localhost:8080/api/sellers';

  constructor(private http: HttpClient) {
    this.selectSeller = new Seller();
  }
  getSellers(){
    return this.http.get(this.URL_API);
  }
  createSeller(seller: Seller){
    return this.http.post(this.URL_API, seller,{responseType: 'text'});
  }
  updateSeller(seller: Seller){
    return this.http.put(this.URL_API+`/${seller.id}`,seller,{responseType: 'text'});
  }
  removeSeller(id: number){
    return this.http.delete(this.URL_API+`${id}`,{responseType: 'text'});
  }
}
