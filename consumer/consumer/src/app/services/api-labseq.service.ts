import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiLabseqService {

  constructor(private http: HttpClient) { }

  // server url
  private URL: string = 'http://localhost:8080/labseq/';

  // send the request to the server
  submitNumber(value: number){
    return this.http.get(this.URL + value);
  }
}
