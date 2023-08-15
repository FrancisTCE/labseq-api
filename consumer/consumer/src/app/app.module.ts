import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { CheckboxModule } from 'primeng/checkbox';
import { FormsModule }    from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { AccordionModule } from 'primeng/accordion';
import { DividerModule } from 'primeng/divider';
import { InputTextModule } from 'primeng/inputtext';


import { HttpClientModule } from '@angular/common/http';





@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CheckboxModule,
    FormsModule,
    AccordionModule,
    ButtonModule,
    DividerModule,
    InputTextModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
