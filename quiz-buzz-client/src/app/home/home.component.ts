import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Quiz } from '../models/quizzes';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private http:HttpClient) { }

  quizzes:Quiz[] = [];

  ngOnInit(): void {
    this.http.get('http://localhost:8080/quizzes/getTen').subscribe({
      next: (data:any) => {
        console.log(data);
        this.quizzes = data;
      }
    })
  }

  getName() {
    return localStorage.getItem("firstName") + " " + localStorage.getItem("lastName");
  }

  getTotalScore() {
    return 100;
  }

  takeQuiz(quizId:number = 0) {
    console.log(quizId);
  }

}
