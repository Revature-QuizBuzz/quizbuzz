import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class QuestionAnswerService {
  
  private header = new HttpHeaders({'content-type': 'application/json'});

  constructor(private http: HttpClient) { }

  ngOnInit(){}
}