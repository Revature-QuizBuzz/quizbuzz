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
  question:any =[];
  quizzes: Quiz[] = [];
  userQuestion: any; 
  answers: any = [];
  userAnswers:any = [];
  correctAnswers:any = [];
  correct:any=[];
  userPoints: any = 0;
  totalPoints: number = 100;
  key = 'correct';

 

  constructor(private answerService: AnswerService, private http:HttpClient) { }

  ngOnInit(): void {
    this.getUserAnswer()
    this.getUserQuestion()
    this.getCorrectAnswers()
    this.getScore()
  }
   
  // getScore() {
  //   return (Math.round(this.userPoints%this.totalPoints));
  // }
  
  getUserAnswer() {
    this.userAnswers = localStorage.getItem('answers');
    this.answers = this.userAnswers.split(',');
    console.log(this.answers);
  }
  getUserQuestion() {
    this.questions = localStorage.getItem('question');
    this.question = this.questions.split(',');
    console.log(this.question);
  }

  getCorrectAnswers() {
    this.correctAnswers = localStorage.getItem('correctAnswer');
    this.correct = this.correctAnswers.split(',');
    console.log(this.correct);
  }

  getScore(){
    this.userPoints = localStorage.getItem('score');
  }


  
  }

 


