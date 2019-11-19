import { Injectable } from '@angular/core';
import { Client } from '../model/client';
import{ HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  selectClient: Client;
  clients: {};
  readonly URL_API = 'http://localhost:8080/api/clients';

  constructor(private http: HttpClient) {
    this.selectClient = new Client();
  }
  getClients(){
    return this.http.get(this.URL_API);
  }
  createClient(client: Client){
    return this.http.post(this.URL_API, client,{responseType: 'text'});
  }
  updateClient(client: Client){
    return this.http.put(this.URL_API+`/${client.id}`,client,{responseType: 'text'});
  }
  removeClient(id: number){
    return this.http.delete(this.URL_API+`${id}`,{responseType: 'text'});
  }
}
