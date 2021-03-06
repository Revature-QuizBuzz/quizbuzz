import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class CreateQuizService {

  constructor(private http:HttpClient) { }

  getTags() {
    return this.http.get('http://localhost:8080/tags')
  }

}
