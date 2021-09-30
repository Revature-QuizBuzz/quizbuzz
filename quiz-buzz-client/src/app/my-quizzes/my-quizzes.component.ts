import { Component, OnInit } from '@angular/core';
import { Quiz } from '../models/quizzes';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { QuizService } from '../quiz.service';

@Component({
  selector: 'app-my-quizzes',
  templateUrl: './my-quizzes.component.html',
  styleUrls: ['./my-quizzes.component.css']
})
export class MyQuizzesComponent implements OnInit {

  quizzes: Quiz[] = [];
  userId = JSON.parse(localStorage.getItem('id')|| '{}');


  constructor(private quizService: QuizService) { }


  ngOnInit(): void {
    this.getUserQuizzes(this.userId);
  }

  getUserQuizzes(id: number) {
    this.quizService.getQuizzesByUserId(id)
     .subscribe(quizzes => {
       this.quizzes = quizzes;
     })
  }
  
  deleteQuiz(quiz: Quiz) {
    console.log(quiz.quizId)
    this.quizService.deleteQuiz(Number(quiz.quizId))
    .subscribe(response => {
      console.log(response)
      this.ngOnInit();
    })
  }

}