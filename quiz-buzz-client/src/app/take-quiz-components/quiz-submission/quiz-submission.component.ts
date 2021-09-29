import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Question} from 'src/app/models/questions';
import {Answer} from 'src/app/models/answers';
import { Quiz } from 'src/app/models/quizzes';
import { UserScore } from 'src/app/models/scores';
import { Router } from '@angular/router';
import { AnswerService } from '../answer.service';
import { NgForm, FormGroup, FormControl, FormArray } from '@angular/forms';

<<<<<<< HEAD
=======

>>>>>>> main

@Component({
  selector: 'app-quiz-submission',
  templateUrl: './quiz-submission.component.html',
  styleUrls: ['./quiz-submission.component.css']
})
export class QuizSubmissionComponent implements OnInit {

<<<<<<< HEAD
  questions: Question[] = [];
  quizzes: Quiz[] = [];
  answers: Answer[] = [];
  answer: any;
  userAnswer?: any;
  userAnswers: any=[];
  // scoreId: number;

  constructor(private answerService: AnswerService) { 
=======
  questions: any = [];
  question:any =[];

  userQuestion: any =[]; 
  answers: any = [];
  userAnswers:any = [];
  correctAnswers:any = [];
  correct:any=[];

  key = 'correct';

  userScore: any;
  quiz: any = localStorage.getItem('quizId');
  quizQuestion: any = [];
  userPoints: any = localStorage.getItem('score');
  totalPoints: any = 100;
  date: any;
<<<<<<< HEAD
>>>>>>> main
  
  }
=======
  
>>>>>>> TakeQuizzes

 

  constructor(private router:Router, private answerService: AnswerService) { }

  ngOnInit(): void {
<<<<<<< HEAD

    this.answerService.getAllAnswers()
    .subscribe((data: Answer[]) =>{
      console.log(data);
      this.answers = data;
    });
  
    this.answerService.getAllQuiz()
    .subscribe((data: Quiz[]) => {
      console.log(data);
      this.quizzes = data;
    });

    this.answerService.getAllQuestions()
    .subscribe((data: Question[]) => { 
      console.log(data);
      this.questions = data;
    });

    this.userAnswers = new FormGroup({
      currentQuestion : new FormControl (''),
      currentAnswer : new FormControl ('')
    });
    
  }

  getUserAnswer() {
    this.userAnswer = localStorage.getItem('answers');
    // let localStorageItem = JSON.parse(localStorage.getItem('answers'));
    
  }

  // submit() {
  //   localStorage.getItem('answers');
  //   userAnswer = this.answers;
  // }
=======
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
>>>>>>> main

 

  // addScore(text: string): void {
  //   let userAnswer = new this.answers(this.scoreId, text);
  //   this.userAnswers.push(this.userAnswer);
  //   this.scoreId++;
  // }

  // addUserAnswer(userAnswer : Answer) {
  //   this.userAnswer.push(this.userAnswers)
  // }

  // let userAnswers = this.getUserAnswers();

<<<<<<< HEAD
  // this.scoreId = 2;
}
=======
>>>>>>> main
