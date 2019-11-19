import { Injectable } from '@angular/core';
import { State } from '../model/state';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StateService {
  selectState: State;
  states: {};
  readonly URL_API = 'http://localhost:8080/api/states';

  constructor(private http: HttpClient) {
    this.selectState = new State();
  }
  getStates(){
    return this.http.get(this.URL_API);
  }
  createState(state: State){
    return this.http.post(this.URL_API, state,{responseType: 'text'});
  }
  updateState(state: State){
    return this.http.put(this.URL_API+`/${state.id}`,state,{responseType: 'text'});
  }
  removeState(id: number){
    return this.http.delete(this.URL_API+`${id}`,{responseType: 'text'});
  }

}
