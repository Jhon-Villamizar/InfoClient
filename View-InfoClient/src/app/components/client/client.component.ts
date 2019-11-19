import { Component, OnInit } from '@angular/core';
import { ClientService } from 'src/app/service/client.service';
import { NgForm } from '@angular/forms';
import { CountryService } from 'src/app/service/country.service';
import { StateService } from 'src/app/service/state.service';
import { CityService } from 'src/app/service/city.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.sass']
})
export class ClientComponent implements OnInit {

  constructor(private clientService: ClientService, private countryServer: CountryService,private stateService: StateService, private cityService: CityService) { }

  ngOnInit() {
    this.getClients();
    this.getContries();
    this.getStates(); 
    this.getCities();
  }

  getClients(){
    this.clientService.getClients()
      .subscribe(res =>{
        this.clientService.clients = res as {};
        console.log('client',res);
      })
  }

  getContries(){
    this.countryServer.getCountries()
      .subscribe(res => {
        this.countryServer.countries = res as {};
      })
  }

  getStates(){
    this.stateService.getStates()
      .subscribe(res =>{
        this.stateService.states = res as {};
        console.log('state',res);
      })
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
      this.clientService.updateClient(form.value)
      .subscribe(res => {
        console.log('client',res);
        this.borrarForm(form);
        this.getClients();
      })
    } else {
      this.clientService.createClient(form.value)
      .subscribe(res => {
        console.log('client',res);
        this.getClients();
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
