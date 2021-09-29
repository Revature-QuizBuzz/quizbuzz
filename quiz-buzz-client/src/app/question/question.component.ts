import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscriber } from 'rxjs';
import { CreateQuizesComponent } from '../create-quizes/create-quizes.component';
import { Answer } from '../models/answers';
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
      type: "",
      answers: []
  
  }];

  @Output() questionEvent = new EventEmitter<Question[]>();
  @Output() saveEvent = new EventEmitter<boolean>();

  @Input() answerEvent?: Answer[];

  constructor(private router: Router, private http: HttpClient) {
   }

  ngOnInit(): void {
    
  }

  addQuestion(index:number, stockForm: NgForm) {
    let question: Question = {
      questionId: 0,
      question: "",
      possiblePoints: 0,
      type: "",
      answers: []
    }
    question.question= stockForm.value.question;
    // question.possiblePoints = stockForm.value.possiblePoints;
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

    let question: Question = {
      question: "",
      possiblePoints: 0,
      type: "",
      answers: []
    }

    question.question = stockForm.value.question;
    // question.possiblePoints = stockForm.value.possiblePoints;
    question.type = stockForm.value.type;
    question.answers = this.questions[this.questions.length - 1].answers;
    this.questions[this.questions.length - 1] = question;
    console.log(question);
    this.questionEvent.emit(this.questions);
    this.saveEvent.emit(true);
    this.router.navigate(['quiz/new'])

  }

  answerCapture($event: Answer[], index:number){
    this.questions[index].answers=$event;
  }
}
