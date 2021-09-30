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
  // questions: Question[] = [];
  public questions: Question[] = [{
      question: "",
      possiblePoints: 0,
      type: ""
  
  }];

  @Output() questionEvent = new EventEmitter<Question[]>();
  @Output() saveEvent = new EventEmitter<boolean>();

  constructor(private router: Router, private http: HttpClient) {
   }

  public _url = "http://localhost:8080/questions/new"

  ngOnInit(): void {
  }

  addQuestion(index:number, stockForm: NgForm) {
    let question: Question = {
      questionId: 0,
      question: "",
      possiblePoints: 0,
      type: ""
    }
    question.question= stockForm.value.question;
    question.possiblePoints = stockForm.value.possiblePoints;
    question.type = stockForm.value.type;
    console.log(question);
    this.questions[index]= question;
    this.questions.push({
      question: "",
      possiblePoints: 0,
      type: ""
    });
    this.selectedType = "";
    console.log(this.questions);
  }

  removeQuestion(i: number) {
    this.questions.splice(i, 1);
  }

  logValue() {
    console.log(this.questions);
  }

  counter(i: number){
    return new Array(i)
  }

  onChange(selectedType: string, index:number) {
    console.log(selectedType);
    this.questions[index].type = selectedType;
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

    let question: Question = {
      questionId: 0,
      question: "",
      possiblePoints: 0,
      type: ""
    }

    question.question = stockForm.value.question;
    question.possiblePoints = stockForm.value.possiblePoints;
    question.type = stockForm.value.type;
    console.log(question);
    this.questionEvent.emit(this.questions);
    this.saveEvent.emit(true);
    this.router.navigate(['quiz/new'])

  }
}
