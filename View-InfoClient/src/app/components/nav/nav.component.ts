import { Component, OnInit } from '@angular/core';
import { SellerService } from 'src/app/service/seller.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.sass']
})
export class NavComponent implements OnInit {

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

}
