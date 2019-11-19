import { Injectable } from '@angular/core';
import { Country } from '../model/country';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CountryService {
  selectCountry: Country;
  countries: {};
  readonly URL_API = 'http://localhost:8080/api/countries';

  constructor(private http: HttpClient) {
    this.selectCountry = new Country();
  }
  getCountries(){
    return this.http.get(this.URL_API);
  }
  createCountry(country: Country){
    return this.http.post(this.URL_API, country,{responseType: 'text'});
  }
  updateCountry(country: Country){
    return this.http.put(this.URL_API+`/${country.id}`,country,{responseType: 'text'});
  }
  removeCountry(id: number){
    return this.http.delete(this.URL_API+`${id}`,{responseType: 'text'});
  }
}
