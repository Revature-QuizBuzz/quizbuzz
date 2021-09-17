import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class QuestionAnswerService {
  
  private header = new HttpHeaders({'content-type': 'application/json'});

  constructor(private http: HttpClient) { }

  ngOnInit(){}

  // sendAnswerData(formData: any){
  //   return this.http.post("http://localhosst:8080/answer/answerstoquestion", formData, (headers: this.header: any));
  // }
}
