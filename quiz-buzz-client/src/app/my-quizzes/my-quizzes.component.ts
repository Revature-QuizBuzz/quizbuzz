import { Component, OnInit } from '@angular/core';
import { Quiz } from '../models/quizzes';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-my-quizzes',
  templateUrl: './my-quizzes.component.html',
  styleUrls: ['./my-quizzes.component.css']
})
export class MyQuizzesComponent implements OnInit {

  quizzes: Quiz[] = [];

  constructor(private http: HttpClient) { }

  private baseUrl = "http://localhost:8080/quizzes"

  ngOnInit(): void {
    this.getUserQuizzes();
  }

  getUserQuizzes() {
    this.getQuizzesById()
     .subscribe(quizzes => {
       this.quizzes = quizzes;
     })
  }

  getQuizzesById(): Observable<Quiz[]> {
    return this.http.get<Quiz[]>(`${this.baseUrl}/user/1`);
  }

}
