import { Component, OnInit } from '@angular/core';
import { CountryService } from 'src/app/service/country.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-country',
  templateUrl: './country.component.html',
  styleUrls: ['./country.component.sass']
})
export class CountryComponent implements OnInit {

  constructor(private countryService: CountryService) { }

  ngOnInit() {
    this.getCountries();    
  }

  getCountries(){
    this.countryService.getCountries()
      .subscribe(res =>{
        this.countryService.countries = res as {};
        console.log('country',res);
      })
  }

  sendRegistry(form?: NgForm) {
    if (form.value.id) {
      this.countryService.updateCountry(form.value)
      .subscribe(res => {
        console.log('country',res);
        this.borrarForm(form);
        this.getCountries();
      })
    } else {
      this.countryService.createCountry(form.value)
      .subscribe(res => {
        console.log('country',res);
        this.getCountries();
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
