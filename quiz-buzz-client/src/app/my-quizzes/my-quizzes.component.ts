import { Component, OnInit } from '@angular/core';
import { Quiz } from '../models/quizzes';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { QuizService } from '../services/quiz.service';

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
    this.getUserQuizzes();
  }

  getUserQuizzes() {
    this.quizService.getQuizzesByUserId()
     .subscribe(quizzes => {
       this.quizzes = quizzes;
     })
  }

}
