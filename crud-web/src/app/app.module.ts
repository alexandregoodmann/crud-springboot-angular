import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {ClienteFormComponent} from './cliente/cliente-form/cliente-form.component';
import {ClienteListComponent} from './cliente/cliente-list/cliente-list.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {HttpModule} from '@angular/http';
import {MessagesComponent} from './messages/messages.component';
import {ClienteItemComponent} from './cliente/cliente-item/cliente-item.component';
import {CurrencyMaskModule} from "ng2-currency-mask";


@NgModule({
  declarations: [
    AppComponent,
    ClienteFormComponent,
    ClienteListComponent,
    MessagesComponent,
    ClienteItemComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    HttpModule,
    FormsModule,
    ReactiveFormsModule,
    CurrencyMaskModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
