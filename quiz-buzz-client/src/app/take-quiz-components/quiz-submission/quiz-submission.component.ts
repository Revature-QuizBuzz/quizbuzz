import { Component, OnInit } from '@angular/core';
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

  questions: Question[] = [];
  quizzes: Quiz[] = [];
  answers: Answer[] = [];
  answer: any;
  userAnswer?: any;
  userAnswers: any=[];
  // scoreId: number;

  constructor(private answerService: AnswerService) { 
  
  }

  ngOnInit(): void {

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


  // addScore(text: string): void {
  //   let userAnswer = new this.answers(this.scoreId, text);
  //   this.userAnswers.push(this.userAnswer);
  //   this.scoreId++;
  // }

  // addUserAnswer(userAnswer : Answer) {
  //   this.userAnswer.push(this.userAnswers)
  // }

  // let userAnswers = this.getUserAnswers();

  // this.scoreId = 2;
}
