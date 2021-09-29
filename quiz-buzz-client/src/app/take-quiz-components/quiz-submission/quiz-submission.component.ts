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
  userScore: any;
  quiz: any = localStorage.getItem('quizId');
  quizQuestion: any = [];
  userPoints: any = localStorage.getItem('score');
  totalPoints: any = 0;
  date: any;
   

  constructor(private router:Router, private answerService: AnswerService) { }

  ngOnInit(): void {
    this.getUserAnswer()
    this.getUserQuestion()
    this.getCorrectAnswers()
    this.getScore()
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
  }

  getScore(){
    this.userPoints = localStorage.getItem('score');
    this.userScore = this.userPoints + '/' + this.question.length ;
  }
  
  home(){
    this.router.navigate(['home']);
   }

  }

 

  // addScore(text: string): void {
  //   let userAnswer = new this.answers(this.scoreId, text);
  //   this.userAnswers.push(this.userAnswer);
  // }

  // addUserAnswer(userAnswer : Answer) {
  //   this.userAnswer.push(this.userAnswers)
  // }

  // let userAnswers = this.getUserAnswers();

