import { Component, OnInit } from '@angular/core';
import { ClientService } from 'src/app/service/client.service';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.sass']
})
export class ClientsComponent implements OnInit {

  constructor(private clientService: ClientService) { }

  ngOnInit() {
    this.getClients();    
  }

  getClients(){
    this.clientService.getClients()
      .subscribe(res =>{
        this.clientService.clients = res as {};
      })
  }
}
