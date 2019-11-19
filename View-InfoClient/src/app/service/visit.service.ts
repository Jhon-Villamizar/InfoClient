import { Injectable } from '@angular/core';
import { Visit } from '../model/visit';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VisitService {
  selectVisit: Visit;
  visits: {};
  readonly URL_API = 'http://localhost:8080/api/clients';

  constructor(private http: HttpClient) {
    this.selectVisit = new Visit();
  }
  getVisits(){
    return this.http.get(this.URL_API);
  }
  createVisit(visit: Visit){
    return this.http.post(this.URL_API, visit,{responseType: 'text'});
  }
  updateVisit(visit: Visit){
    return this.http.put(this.URL_API+`/${visit.clientId}`,visit,{responseType: 'text'});
  }
  removeVisit(id: number){
    return this.http.delete(this.URL_API+`${id}`,{responseType: 'text'});
  }
}
