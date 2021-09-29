import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Question} from 'src/app/models/questions';
import {Answer} from 'src/app/models/answers';
import { Quiz } from 'src/app/models/quizzes';
import { UserScore } from 'src/app/models/scores';
import { Router } from '@angular/router';
import { AnswerService } from '../answer.service';
import { NgForm } from '@angular/forms';


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
  userId: any = localStorage.getItem('');
  userScore: any;
  quiz: any = localStorage.getItem('quizId');
  quizQuestion: any = [];
  userPoints: any = localStorage.getItem('score');
  totalPoints: any = localStorage.getItem('question')?.length;
  date: any;
   
  constructor(private router:Router, private http: HttpClient, private answerService: AnswerService) {

    let scoreUrl= "http://localhost:8080/testresults"

    this.http.post(scoreUrl, {      
      user: {userId: this.userId},
      quiz: {quizId: this.quiz.id},
      score: this.userScore,      
    }).toPromise().then((data : any) => {
      console.log(data)
    })
  }

  ngOnInit(): void { }
   
  
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
  //   this.userScore = this.userPoints + '/' + this.question.length ;
  // }
    console.log(this.totalPoints);
    this.userScore = Math.round(this.userPoints/this.totalPoints*100);
  }
  
  home(){
    this.router.navigate(['home']);
   }

  }


