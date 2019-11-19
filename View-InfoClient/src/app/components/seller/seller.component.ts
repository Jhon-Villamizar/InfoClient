import { Component, OnInit } from '@angular/core';
import { SellerService } from 'src/app/service/seller.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-seller',
  templateUrl: './seller.component.html',
  styleUrls: ['./seller.component.sass']
})
export class SellerComponent implements OnInit {

  constructor(private sellerService: SellerService) { }

  ngOnInit() {
    this.getSellers();    
  }

  getSellers(){
    this.sellerService.getSellers()
      .subscribe(res =>{
        this.sellerService.sellers = res as {};
        console.log('seller',res);
      })
  }

  sendRegistry(form?: NgForm) {
    if (form.value.id) {
      this.sellerService.updateSeller(form.value)
      .subscribe(res => {
        console.log('seller',res);
        this.borrarForm(form);
        this.getSellers();
      })
    } else {
      this.sellerService.createSeller(form.value)
      .subscribe(res => {
        console.log('seller',res);
        this.getSellers();
        this.borrarForm(form);
      })
    }
  }
  borrarForm(form?: NgForm) {
    if(form) {
      form.reset();
    }
  }

}
