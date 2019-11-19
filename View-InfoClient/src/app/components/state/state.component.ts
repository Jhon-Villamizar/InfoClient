import { Component, OnInit } from '@angular/core';
import { StateService } from 'src/app/service/state.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-state',
  templateUrl: './state.component.html',
  styleUrls: ['./state.component.sass']
})
export class StateComponent implements OnInit {

  constructor(private stateService: StateService) { }

  ngOnInit() {
    this.getStates();    
  }

  getStates(){
    this.stateService.getStates()
      .subscribe(res =>{
        this.stateService.states = res as {};
        console.log('state',res);
      })
  }

  sendRegistry(form?: NgForm) {
    if (form.value.id) {
      this.stateService.updateState(form.value)
      .subscribe(res => {
        console.log('state',res);
        this.borrarForm(form);
        this.getStates();
      })
    } else {
      this.stateService.createState(form.value)
      .subscribe(res => {
        console.log('state',res);
        this.getStates();
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
