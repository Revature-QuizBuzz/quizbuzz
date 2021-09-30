import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Question } from '../models/questions';
import { Answer } from '../models/answers';
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
  answersArray?: Answer[]

  @Output() questionEvent = new EventEmitter<Question[]>();
  @Output() saveEvent = new EventEmitter<boolean>();

  @Input() answerEvent?: Answer[];

  constructor(private router: Router, private http: HttpClient) {
  }

  public _url = "http://localhost:8080/questions/new"

  ngOnInit(): void {
  }

  addQuestion(index: number, stockForm: NgForm) {
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
    question.answers = this.answersArray;
    this.questions[index] = question;
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

  counter(i: number) {
    return new Array(i)
  }

  onChange(selectedType: string, index: number) {
    console.log(selectedType);
    this.questions[index].type = selectedType;
  }

  onSubmit(stockForm: NgForm) {

    let question: Question = {
      questionId: 0,
      question: "",
      possiblePoints: 0,
      type: ""
    }

    question.question = stockForm.value.question;
    question.type = stockForm.value.type;
    question.answers = this.answersArray;
    console.log(question);
    this.questions[this.questions.length - 1] = question;
    this.questionEvent.emit(this.questions);
    this.saveEvent.emit(true);
  }

  answerCapture($event: Answer[], index: number) {
    this.answersArray = $event;
    console.log($event);
  }

}
