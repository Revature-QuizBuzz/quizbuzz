import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Quiz } from './models/quizzes';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  private apiUrl: string = "http://localhost:8080"

  constructor(private http: HttpClient) { }

  getQuizzes(): Observable<Quiz[]> {
    return this.http.get<Quiz[]>(`${this.apiUrl}/quizzes`);
  }


  // displayScore(): Observable<ScoreBoard[]> {
  //   return this.http.get<ScoreBoard[]>(`${this.apiUrl}/scoreboard`);
  // }
}
