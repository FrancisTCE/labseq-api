import { Component } from '@angular/core';
import {ApiLabseqService} from '../app/services/api-labseq.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  // this array stores the received payloads in the session
  payloadsArray: any[] = [];

  constructor(private apiservice: ApiLabseqService) {}
  value: number = 0
  labseqValue: number = 0
  serverPTime: number = 0
  title = 'Labseq Altice Labs'
  payload: any

  // function in the component responsible to send the number to the spring server
  sendRequest() {
    console.log('sending request')
    this.apiservice.submitNumber(this.value).subscribe(response => {
      this.payload = JSON.parse(JSON.stringify(response))
      this.labseqValue = this.payload['LabseqN']
      this.serverPTime = this.payload['processingTime']
      this.payloadsArray.push(this.payload)
  });
    
  }
}
