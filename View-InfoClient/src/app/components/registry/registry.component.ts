import { Component, OnInit } from '@angular/core';
import { ClientService } from 'src/app/service/client.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-registry',
  templateUrl: './registry.component.html',
  styleUrls: ['./registry.component.sass']
})
export class RegistryComponent implements OnInit {

  constructor(private clientService: ClientService) { }

  ngOnInit() {
  }

  sendRegistry(form?: NgForm) {
    console.log(form.value);
    this.clientService.createClient(form.value)
      .subscribe(res => {
        console.log(form.value);
      });
  }
}
