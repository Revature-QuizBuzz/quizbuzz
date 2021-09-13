import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Question } from '../question';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {
  questions: Question[] = [];
  question: Question = {
    id: 0,
    quiz: 0,
    question: "",
    possiblePoints: 0,
    type: ""
  }

  constructor(private router:Router, private http:HttpClient) { }

    public _url = "http://localhost:8080/questions/new"

  ngOnInit(): void {
  }

  onSubmit(stockForm:NgForm){

    const httpOptions = {
    headers: new HttpHeaders({'Content-Type':'application/json'})}

    this.http.post(this._url, JSON.stringify({ 
      quiz:stockForm.value.quiz, 
      question:stockForm.value.question, 
      possiblePoints:stockForm.value.possiblePoints, 
      type:stockForm.value.type, 
    }), httpOptions
    ).subscribe({
      next: (data) => {
        console.log(data)
      }
    })

    this.router.navigate([""])
}

}
