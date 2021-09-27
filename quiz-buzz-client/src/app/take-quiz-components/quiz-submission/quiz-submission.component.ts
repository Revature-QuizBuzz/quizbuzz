import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Question} from 'src/app/models/questions';
import {Answer} from 'src/app/models/answers';
import { Quiz } from 'src/app/models/quizzes';
import { AnswerService } from '../answer.service';
import { NgForm, FormGroup, FormControl, FormArray } from '@angular/forms';



@Component({
  selector: 'app-quiz-submission',
  templateUrl: './quiz-submission.component.html',
  styleUrls: ['./quiz-submission.component.css']
})
export class QuizSubmissionComponent implements OnInit {

  questions: any = [];
  quizzes: Quiz[] = [];
  // answers: Answer[] = [];
  // answer: any;
  userQuestion: any; 
  userAnswer?: any;
  userAnswers: any = [];
  userPoints: number = 0;
  totalPoints: number = 100;
  key = 'correct';

  // public testUrl = 'http://localhost:8080/testanswers/create';

  constructor(private answerService: AnswerService, private http:HttpClient) { }

  ngOnInit(): void {

    this.fetchQuestions();
    this.userAnswers = new Array<string>();
    this.userQuestion = this.questions;
    const quizForm = document.querySelector('testForm');

    quizForm?.addEventListener('submit', event => {
      event.preventDefault();
      this.userAnswer = JSON.parse(localStorage.getItem('correct')||'{}');
    
    });

  for ( let i = 0; i < localStorage.length; i++) {
    const key = localStorage.key(i);
    this.userPoints++;
    console.log(`${key}: ${localStorage.getItem('correct')}`);
  }

  //   this.answerService.getUserAnswers(this.key)
  //   .subscribe((data: Answer[]) =>{
  //     console.log(data);
  //     this.userAnswers = data;
  //   });

  }

  getScore() {
    return (Math.round(this.userPoints%this.totalPoints));
  }
  
  // getUserAnswer() {
  //   this.userAnswer = localStorage.getItem('answers');
  //   // let localStorageItem = JSON.parse(localStorage.getItem('answers'));
  //   console.log(this.userAnswer);
  // }

  // submit(quizForm: any){
  //   console.log("Sumbitted for Review");
  //   var quiz_answer = this.userAnswers;
  //   // if( localStorage.getItem('correct')== null){
  //   //   localStorage.setItem('correct','[]');
  //   // }

  //   var old_data1  = JSON.parse(localStorage.getItem('correct')||'{}');
  //   old_data1.push(quiz_answer);
  //   JSON.stringify(old_data1);
  //   localStorage.setItem('correct', old_data1);

  // }

  // this.scoreId = 2;
}
