import { Component, OnInit } from '@angular/core';
import { CityService } from 'src/app/service/city.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.sass']
})
export class CityComponent implements OnInit {

  constructor(private cityService: CityService) { }

  ngOnInit() {
    this.getCities();    
  }

  getCities(){
    this.cityService.getCities()
      .subscribe(res =>{
        this.cityService.cities = res as {};
        console.log('city',res);
      })
  }

  sendRegistry(form?: NgForm) {
    if (form.value.id) {
      this.cityService.updateCity(form.value)
      .subscribe(res => {
        console.log('city',res);
        this.borrarForm(form);
        this.getCities();
      })
    } else {
      this.cityService.createCity(form.value)
      .subscribe(res => {
        console.log('city',res);
        this.getCities();
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
