import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { CreateQuizesComponent } from '../create-quizes/create-quizes.component';
import { Question } from '../models/questions';
import { Quiz } from '../models/quizzes';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {
  selectedType = "";
  questions: Question[] = [];
  question: Question = {
    id: 0,
    question: "",
    possiblePoints: 0,
    type: ""
  }

  @Output() questionEvent = new EventEmitter<Question>();

  constructor(private router: Router, private http: HttpClient) { }

  public _url = "http://localhost:8080/questions/new"

  ngOnInit(): void {
  }

  onChange(selectedType: string){
    console.log(selectedType);
    this.selectedType= selectedType;
  }

  onSubmit(stockForm: NgForm) {
    

    // const httpOptions = {
    // headers: new HttpHeaders({'Content-Type':'application/json'})}
    // let quiz: Quiz ={id:stockForm.value.quizid}
    // this.http.post(this._url,({ 
    //   quiz:quiz, 
    //   question:stockForm.value.question, 
    //   possiblePoints:stockForm.value.possiblePoints, 
    //   type:stockForm.value.type, 
    // }), httpOptions
    // ).subscribe({
    //   next: (data) => {
    //     console.log(data)
    //   }
    // })
    // this.router.navigate([""])


    this.question.question = stockForm.value.question;
    this.question.possiblePoints = stockForm.value.possiblePoints;
    this.question.type = stockForm.value.type;
    console.log(this.question);
    this.questionEvent.emit(this.question);

  }
}
