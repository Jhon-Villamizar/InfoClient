import { Component, OnInit } from '@angular/core';
import { VisitService } from 'src/app/service/visit.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-visit',
  templateUrl: './visit.component.html',
  styleUrls: ['./visit.component.sass']
})
export class VisitComponent implements OnInit {

  constructor(private visitService: VisitService) { }

  ngOnInit() {
    this.getVisits();    
  }

  getVisits(){
    this.visitService.getVisits()
      .subscribe(res =>{
        this.visitService.visits = res as {};
        console.log('visit',res);
      })
  }

  sendRegistry(form?: NgForm) {
    if (form.value.id) {
      this.visitService.updateVisit(form.value)
      .subscribe(res => {
        console.log('visit',res);
        this.borrarForm(form);
        this.getVisits();
      })
    } else {
      this.visitService.createVisit(form.value)
      .subscribe(res => {
        console.log('visit',res);
        this.getVisits();
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
