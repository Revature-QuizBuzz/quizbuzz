import { Injectable } from '@angular/core';
import { Quiz } from '../models/quizzes';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})


export class QuizService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  private baseUrl = "http://localhost:8080/quizzes"
  userId = JSON.parse(localStorage.getItem('id')|| '{}');
 

  constructor(private http: HttpClient){ }

  getQuizzesByUserId(): Observable<Quiz[]> {
    return this.http.get<Quiz[]>(`${this.baseUrl}/user/${this.userId}`);
  }

  getQuizByUserIdAndName(quizName: String): Observable<Quiz> {
    return this.http.get<Quiz>(`${this.baseUrl}/user/${this.userId}/quiz/${quizName}`)
  }

}
