import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";

import { AppComponent } from './app.component';
import { NavComponent } from './components/nav/nav.component';
import { ClientsComponent } from './components/clients/clients.component';
import { RegistryComponent } from './components/registry/registry.component';
import { UpdateComponent } from './components/update/update.component';
import { ClientComponent } from './components/client/client.component';
import { CountryComponent } from './components/country/country.component';
import { SellerComponent } from './components/seller/seller.component';
import { StateComponent } from './components/state/state.component';
import { VisitComponent } from './components/visit/visit.component';
import { CityComponent } from './components/city/city.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    ClientsComponent,
    RegistryComponent,
    UpdateComponent,
    CityComponent,
    ClientComponent,
    CountryComponent,
    SellerComponent,
    StateComponent,
    VisitComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
