import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Quiz } from '../models/quizzes';

@Injectable({
  providedIn: 'root'
})
export class EditQuizService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  private baseUrl = "http://localhost:8080/quizzes"

  constructor(private http: HttpClient) { }

  getQuiz(id: number): Observable<Quiz> {
    const detailUrl = `${this.baseUrl}/edit/${id}`;
    return this.http.get<Quiz>(detailUrl);
  }

  getAllQuizzes(): Observable<Quiz[]> {
    return this.http.get<Quiz[]>(`${this.baseUrl}`);
  }
}
