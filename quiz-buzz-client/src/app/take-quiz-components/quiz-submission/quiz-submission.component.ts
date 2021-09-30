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
  userId: any = localStorage.getItem('id');
  userScore: any = localStorage.getItem('score');
  quiz: any = localStorage.getItem('quizId');
  quizQuestion: any = [];
  userPoints: any = localStorage.getItem('score');
  totalPoints: any;
  date: any;

  quizdata:any = [[],[],[]] 
   
  constructor(private router:Router, private http: HttpClient, private answerService: AnswerService) {

  }

  ngOnInit(): void {

    
    this.getUserAnswer();
    this.getUserQuestion();
    this.getCorrectAnswers();
    this.totalPoints = this.question.length;
    this.getScore();
    this.quizdata = [[this.answers],[this.question],[this.correct]]
    
      
   
   console.log(this.quizdata);


    let scoreUrl= "http://localhost:8080/scores/submitQuiz"

    this.http.post(scoreUrl, {      
      user: {userId: this.userId},
      quiz: {quizId: this.quiz},
      score: this.userScore, 
         
    }).subscribe({
              next: (data:any)=>{
               console.log(data)
              }
            })
    
    delete localStorage['answers'];
    delete localStorage['question'];
    delete localStorage['correctAnswer'];
    delete localStorage['score'];
    delete localStorage['quizId'];
  }  
   
   
  
    getUserAnswer() {
      this.userAnswers = localStorage.getItem('answers');
      this.answers = this.userAnswers.split('*');
      this.answers.pop();
    }
    getUserQuestion() {
      this.questions = localStorage.getItem('question');
      this.question = this.questions.split('*');
      this.question.pop();
    }

    getCorrectAnswers() {
      this.correctAnswers = localStorage.getItem('correctAnswer');
      this.correct = this.correctAnswers.split('*');
      this.correct.pop();
    }

  getScore(){
    this.userPoints = localStorage.getItem('score');   
     let math =  (this.userPoints/this.totalPoints)*100;
     this.userScore = Math.round(math);
    
  }
  
  home(){
    this.router.navigate(['home']);
   }

  getAnswers(i:number) {
    return this.answers[i];
  }

  getQuestions(i:number) {
    return this.question[i];
  }

  getCorrect(i:number) {
    return this.correct[i];
  }
}



