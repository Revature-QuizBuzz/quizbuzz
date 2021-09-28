import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Question} from 'src/app/models/questions';
import {Answer} from 'src/app/models/answers';
import { Quiz } from 'src/app/models/quizzes';
import { UserScore } from 'src/app/models/scores';
import { Router } from '@angular/router';
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

  userQuestion: any =[]; 
  answers: any = [];
  userAnswers:any = [];
  correctAnswers:any = [];
  correct:any=[];

  key = 'correct';

  userScore: any = {};
  quiz: any = localStorage.getItem('quizId');
  quizQuestion: any = [];
  userPoints: any = localStorage.getItem('score');
  totalPoints: any = 0;
  date: any;
  // first: any = localStorage.getItem('answers');
  // second: any = localStorage.getItem('question');
  // third: any = localStorage.getItem('correctAnswer');
  //quizInfo: any = [this.first,this.second,this.third];

 

  constructor(private router:Router, private answerService: AnswerService) { }

  ngOnInit(): void {
    this.getUserAnswer()
    this.getUserQuestion()
    this.getCorrectAnswers()
    this.getScore()
    // console.log(this.quizInfo)
    this.date = this.userScore.completedOn?.getDate
  
  }
   
  getUserScore() {
   this.quiz = this.quiz;
   this.answers = localStorage.getItem('answers');
   
  }
  
  getUserAnswer() {
    this.userAnswers = localStorage.getItem('answers');
    this.answers = this.userAnswers.split(',');
   }
  getUserQuestion() {
    this.questions = localStorage.getItem('question');
    this.question = this.questions.split(',');
  }

  getCorrectAnswers() {
    this.correctAnswers = localStorage.getItem('correctAnswer');
    this.correct = this.correctAnswers.split(',');
    // console.log(this.correct.length);
    // console.log("look here");
  }

  getScore(){
    this.userPoints = localStorage.getItem('score');
    // console.log(this.totalPoints);
    this.userScore = Math.round(this.userPoints/this.totalPoints*100);
  }

  
  // addScore(){

  // }
  
  home(){
    this.router.navigate(['home']);
   }

  }

 


