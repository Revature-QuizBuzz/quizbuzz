import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Quiz } from '../models/quizzes';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private http:HttpClient, private router:Router) { }

  quizzes:Quiz[] = [];
  score:number = 0;

  ngOnInit(): void {
    this.http.get('http://localhost:8080/quizzes/getTen').subscribe({
      next: (data:any) => {
        console.log(data);
        this.quizzes = data;
      }
    })

    this.http.get('http://localhost:8080/testresults/MyScore/' + localStorage.getItem("id")).subscribe({
      next: (data:any) => {
        this.score = data;
      }
    })
  }

  getName() {
    return localStorage.getItem("firstName") + " " + localStorage.getItem("lastName");
  }

  getTotalScore() {
    return this.score;
  }

  takeQuiz(quizId:number = 0) {
    if(quizId !== 0) {
      localStorage.setItem("quizId", String(quizId));
      this.router.navigate(['take/quiz'])
    }
  }

}
