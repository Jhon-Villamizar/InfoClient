import { Injectable } from '@angular/core';
import { City } from '../model/city';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CityService {

  selectCity: City;
  cities: {};
  readonly URL_API = 'http://localhost:8080/api/cities';

  constructor(private http: HttpClient) {
    this.selectCity = new City();
  }
  getCities(){
    return this.http.get(this.URL_API);
  }
  createCity(city: City){
    return this.http.post(this.URL_API, city,{responseType: 'text'});
  }
  updateCity(city: City){
    return this.http.put(this.URL_API+`/${city.id}`,city,{responseType: 'text'});
  }
  removeCity(id: number){
    return this.http.delete(this.URL_API+`${id}`,{responseType: 'text'});
  }
}
