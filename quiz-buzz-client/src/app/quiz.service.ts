import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Quiz } from './models/quizzes';
import { Answer } from './models/answers';
import { Question } from './models/questions';

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

  getQuestions(): Observable<Question[]> {
    return this.http.get<Question[]>(`${this.apiUrl}/quizzes`);
  }

  getAnswers(): Observable<Answer[]> {
    return this.http.get<Answer[]>(`${this.apiUrl}/quizzes`);
  }

  // getQandA(selectedQuiz): Observable<Quiz[]> {
  //   if (quizzes.quiz_id == questions.quiz_id) {

  //   }

  //   if (questions.question_id == answers.question_id) {

  //   }

  //   return this.http.get<>(`${this.apiUrl}/quizzes`)
  // }


  // displayScore(): Observable<ScoreBoard[]> {
  //   return this.http.get<ScoreBoard[]>(`${this.apiUrl}/scoreboard`);
  // }
}
