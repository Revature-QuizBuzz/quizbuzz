import { Component, OnInit } from '@angular/core';
import {Question} from 'src/app/models/questions';
import {Answer} from 'src/app/models/answers';
import { Quiz } from 'src/app/models/quizzes';
import { AnswerService } from '../answer.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-quiz-submission',
  templateUrl: './quiz-submission.component.html',
  styleUrls: ['./quiz-submission.component.css']
})
export class QuizSubmissionComponent implements OnInit {

  answers: Answer[] = [];
  questions: Question[] = [];
  quizzes: Quiz[] = [];
  userAnswer?: Answer;
  userAnswers: Answer[]=[];

  constructor(private answerService: AnswerService) { }
  

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
  }
  onSubmit(form: NgForm): void {
    this.userAnswer = Answer;
  }



}
